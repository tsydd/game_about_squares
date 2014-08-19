package gameaboutsquares.engine;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Tsydzik Dmitry
 * @since 8/16/2014.
 */
public class Step {
    private Color color;
    private FieldState fieldState;
    private int depth;
    private static AtomicInteger maxDepth = new AtomicInteger();

    public Step(Color color, FieldState fieldState, int depth) {
        this.color = color;
        this.fieldState = fieldState;
        this.depth = depth;
        if (maxDepth.compareAndSet(depth - 1, depth)) {
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
