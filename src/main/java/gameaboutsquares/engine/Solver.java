package gameaboutsquares.engine;

import java.util.*;

/**
 * @author Tsydzik Dmitry
 * @since 8/16/2014.
 */
public class Solver {
    private FieldState initialFieldState;
    private Field field;

    private Map<FieldState, Step> stepMap = new HashMap<>();
    private Queue<Step> stepQueue = new LinkedList<>();

    public Solver(FieldState initialFieldState, Field field) {
        this.initialFieldState = initialFieldState;
        this.field = field;
    }

    public List<Color> solve() {
        if (Engine.isFinal(initialFieldState, field)) {
            return Collections.emptyList();
        }
        addSteps(initialFieldState, 1);
        boolean solved = false;
        Step step = null;
        while (!solved) {
            step = stepQueue.poll();
            FieldState newFieldState = new FieldState(step.getFieldState());
            Engine.click(step.getColor(), field, newFieldState);
            boolean isNewState = stepMap.putIfAbsent(newFieldState, step) == null;
            if (Engine.isFinal(newFieldState, field)) {
                solved = true;
            } else if (isNewState) {
                addSteps(newFieldState, step.getDepth() + 1);
            }
        }
        List<Color> result = new LinkedList<>();
        while (!Objects.equals(initialFieldState, step.getFieldState())) {
            result.add(0, step.getColor());
            step = stepMap.get(step.getFieldState());
        }
        result.add(0, step.getColor());
        return result;
    }

    private void addSteps(FieldState fieldState, int depth) {
        fieldState.getSquareStates().keySet().stream()
                .forEach(color -> stepQueue.add(new Step(color, fieldState, depth)));
    }
}
