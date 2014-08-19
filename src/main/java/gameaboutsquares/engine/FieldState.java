package gameaboutsquares.engine;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author Tsydzik Dmitry
 * @since 8/16/2014.
 */
public class FieldState {
    private Map<Color, SquareState> squareStates = new HashMap<>();

    public FieldState() {
    }

    public FieldState(FieldState fieldState) {
        fieldState.squareStates
                .forEach((color, state) -> add(color, new SquareState(state)));
    }

    public FieldState add(Color color, Direction direction, int x, int y) {
        return add(color, new SquareState(direction, x, y));
    }


    public FieldState add(Color color, SquareState squareState) {
        squareStates.put(color, squareState);
        return this;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        squareStates.forEach((color, state) -> joiner.add(String.format("%s: %s", color, state)));
        return joiner.toString();
    }

    @Override
    public int hashCode() {
        return squareStates.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        FieldState another = (FieldState) obj;
        return Objects.equals(squareStates, another.squareStates);
    }

    public Map<Color, SquareState> getSquareStates() {
        return squareStates;
    }
}
