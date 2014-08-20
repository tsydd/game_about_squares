package gameaboutsquares.engine;

import gameaboutsquares.levels.Level;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 * @author Tsydzik Dmitry
 * @since 8/16/2014.
 */
public class Solver {

    private static Map<Direction, BoundsContext> boundsContextMap = new HashMap<>();

    private Level level;
    private Map<FieldState, Step> stepMap = new ConcurrentHashMap<>();
    private BlockingQueue<Step> stepQueue = new LinkedBlockingQueue<>();

    private AtomicReference<Step> lastStep = new AtomicReference<>();

    private int minX = Integer.MAX_VALUE;
    private int minY = Integer.MAX_VALUE;
    private int maxX = Integer.MIN_VALUE;
    private int maxY = Integer.MIN_VALUE;

    static {
        BiPredicate<Integer, Integer> le = (a, b) -> a <= b;
        BiPredicate<Integer, Integer> ge = (a, b) -> a >= b;
        boundsContextMap.put(Direction.RIGHT, new BoundsContext(Position::getX, le, (Solver s) -> s.maxX, Direction.LEFT));
        boundsContextMap.put(Direction.LEFT, new BoundsContext(Position::getX, ge, (Solver s) -> s.minX, Direction.RIGHT));
        boundsContextMap.put(Direction.UP, new BoundsContext(Position::getY, le, (Solver s) -> s.maxY, Direction.DOWN));
        boundsContextMap.put(Direction.DOWN, new BoundsContext(Position::getY, ge, (Solver s) -> s.minY, Direction.UP));
    }

    private static class BoundsContext {
        Function<Position, Integer> getDimension;
        BiPredicate<Integer, Integer> inBoundsPredicate;
        Function<Solver, Integer> boundFunction;
        Direction reverseDirection;

        private BoundsContext(Function<Position, Integer> getDimension, BiPredicate<Integer, Integer> inBoundsPredicate, Function<Solver, Integer> boundFunction, Direction reverseDirection) {
            this.getDimension = getDimension;
            this.inBoundsPredicate = inBoundsPredicate;
            this.boundFunction = boundFunction;
            this.reverseDirection = reverseDirection;
        }
    }

    private boolean isAcceptable(FieldState fs) {
        return !fs.getSquareStates().values().stream()
                .filter(ss -> {
                    BoundsContext boundsContext = boundsContextMap.get(ss.getDirection());

                    Function<SquareState, Integer> getDimension = ((Function<SquareState, Position>) SquareState::getPosition)
                            .andThen(boundsContext.getDimension);
                    BiPredicate<Integer, Integer> inBoundsPredicate = boundsContext.inBoundsPredicate;
                    Function<Solver, Integer> boundFunction = boundsContext.boundFunction;
                    Direction reverseDirection = boundsContext.reverseDirection;

                    return !inBoundsPredicate.test(getDimension.apply(ss), boundFunction.apply(this))
                            && !fs.getSquareStates().values().stream()
                            .filter(squareState -> squareState != ss)
                            .filter(squareState -> squareState.getDirection() == reverseDirection)
                            .filter(squareState -> inBoundsPredicate.negate().test(getDimension.apply(squareState), getDimension.apply(ss)))
                            .findAny()
                            .isPresent();
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

        if (x < minX) {
            minX = x;
        }
        if (y < minY) {
            minY = y;
        }
        if (x > maxX) {
            maxX = x;
        }
        if (y > maxY) {
            maxY = y;
        }
    }

    public List<Color> solve() {
        if (Engine.isFinal(level.getInitialState(), level.getField())) {
            return Collections.emptyList();
        }
        addSteps(level.getInitialState());
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
            Step step;
            try {
                step = stepQueue.take();
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted");
            }
            FieldState newFieldState = new FieldState(step.getFieldState());
            Engine.click(step.getColor(), level.getField(), newFieldState);
            boolean isNewState = stepMap.putIfAbsent(newFieldState, step) == null;
            if (Engine.isFinal(newFieldState, level.getField())) {
                lastStep.compareAndSet(null, step);
            } else if (isNewState) {
                addSteps(newFieldState);
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

    private void addSteps(FieldState fieldState) {
        if (isAcceptable(fieldState)) {
            fieldState.getSquareStates().keySet().stream()
                    .forEach(color -> stepQueue.add(new Step(color, fieldState)));
        }
    }
}
