package gameaboutsquares.engine;

import gameaboutsquares.levels.Level;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiPredicate;

/**
 * @author Tsydzik Dmitry
 * @since 8/16/2014.
 */
public class Solver {

    private static Map<BiPredicate<Position, Solver>, Direction> outPredicates = new HashMap<>();

    private Level level;
    private Map<FieldState, Step> stepMap = new ConcurrentHashMap<>();
    private Queue<Step> stepQueue = new LinkedBlockingQueue<>();

    private AtomicReference<Step> lastStep = new AtomicReference<>();

    private int minX = Integer.MAX_VALUE;
    private int minY = Integer.MAX_VALUE;
    private int maxX = Integer.MIN_VALUE;
    private int maxY = Integer.MIN_VALUE;

    static {
        outPredicates.put((pos, solver) -> pos.getX() > solver.maxX, Direction.LEFT);
        outPredicates.put((pos, solver) -> pos.getX() < solver.minX, Direction.RIGHT);
        outPredicates.put((pos, solver) -> pos.getY() > solver.maxY, Direction.DOWN);
        outPredicates.put((pos, solver) -> pos.getY() < solver.minY, Direction.UP);
    }

    private boolean isAcceptable(FieldState fs) {
        return !fs.getSquareStates().values().stream()
                .filter(ss -> {
                    AtomicBoolean isOut = new AtomicBoolean();
                    outPredicates.forEach((predicate, direction) -> {
                        boolean isGoingOut = predicate.test(ss.getPosition(), this) && ss.getDirection() != direction;
                        isOut.compareAndSet(false, isGoingOut);
                    });
                    return isOut.get();
                })
                .findAny()
                .isPresent();
    }

    public Solver(Level level) {
        this.level = level;
        updateMinMax();
    }

    private void updateMinMax() {
        level.getField().getArrows().stream()
                .map(Arrow::getPosition)
                .forEach(this::updateMinMax);
        level.getField().getFinalPositions().values()
                .forEach(this::updateMinMax);
    }

    private void updateMinMax(Position position) {
        int x = position.getX();
        int y = position.getY();

        if (x < minX) minX = x;
        if (y < minY) minY = y;
        if (x > maxX) maxX = x;
        if (y > maxY) maxY = y;
    }

    public List<Color> solve() {
        if (Engine.isFinal(level.getInitialState(), level.getField())) {
            return Collections.emptyList();
        }
        addSteps(level.getInitialState(), 1);
//        runParallel();
        runSequential();
        Step step = lastStep.get();
        List<Color> result = new LinkedList<>();
        while (!Objects.equals(level.getInitialState(), step.getFieldState())) {
            result.add(0, step.getColor());
            step = stepMap.get(step.getFieldState());
        }
        result.add(0, step.getColor());
        return result;
    }

    private void runSequential() {
        while (lastStep.get() == null) {
            Step step = stepQueue.poll();
            FieldState newFieldState = new FieldState(step.getFieldState());
            Engine.click(step.getColor(), level.getField(), newFieldState);
            boolean isNewState = stepMap.putIfAbsent(newFieldState, step) == null;
            if (Engine.isFinal(newFieldState, level.getField())) {
                lastStep.compareAndSet(null, step);
            } else if (isNewState) {
                addSteps(newFieldState, step.getDepth() + 1);
            }
        }
    }

    private void runParallel() {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        List<ForkJoinTask<?>> tasks = new LinkedList<>();
        for (int i = 0; i < pool.getParallelism(); i++) {
            tasks.add(pool.submit(this::runSequential));
        }
        tasks.stream().forEach(ForkJoinTask::join);
    }

    private void addSteps(FieldState fieldState, int depth) {
        if (isAcceptable(fieldState)) {
            fieldState.getSquareStates().keySet().stream()
                    .forEach(color -> stepQueue.add(new Step(color, fieldState, depth)));
        }
    }
}
