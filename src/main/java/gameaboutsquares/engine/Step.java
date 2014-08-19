package gameaboutsquares.engine;

/**
 * @author Tsydzik Dmitry
 * @since 8/16/2014.
 */
public class Step {
    private Color color;
    private FieldState fieldState;

    public Step(Color color, FieldState fieldState) {
        this.color = color;
        this.fieldState = fieldState;
    }

    public Color getColor() {
        return color;
    }

    public FieldState getFieldState() {
        return fieldState;
    }
}
