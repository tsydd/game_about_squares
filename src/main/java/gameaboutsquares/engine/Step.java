package gameaboutsquares.engine;

/**
 * @author Tsydzik Dmitry
 * @since 8/16/2014.
 */
public class Step {
    private Color color;
    private FieldState fieldState;
    private int depth;
    private static int maxDepth;

    public Step(Color color, FieldState fieldState, int depth) {
        this.color = color;
        this.fieldState = fieldState;
        this.depth = depth;
        if (depth > maxDepth) {
            maxDepth = depth;
            System.out.println(depth);
        }
    }

    public Color getColor() {
        return color;
    }

    public FieldState getFieldState() {
        return fieldState;
    }

    public int getDepth() {
        return depth;
    }
}
