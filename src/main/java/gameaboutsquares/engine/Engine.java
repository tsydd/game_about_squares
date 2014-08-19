package gameaboutsquares.engine;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author Tsydzik Dmitry
 * @since 8/16/2014.
 */
public class Engine {
    private static Map<Direction, Consumer<Position>> transitions = new HashMap<>();

    static {
        transitions.put(Direction.UP, pos -> pos.setY(pos.getY() + 1));
        transitions.put(Direction.DOWN, pos -> pos.setY(pos.getY() - 1));
        transitions.put(Direction.LEFT, pos -> pos.setX(pos.getX() - 1));
        transitions.put(Direction.RIGHT, pos -> pos.setX(pos.getX() + 1));
    }

    public static void click(Color color, Field field, FieldState fieldState) {
        SquareState squareState = fieldState.getSquareStates().get(color);
        Consumer<Position> transition = transitions.get(squareState.getDirection());
        move(squareState, field, fieldState, transition);
    }

    private static void move(SquareState squareState, Field field, FieldState fieldState, Consumer<Position> transition) {
        Position position = squareState.getPosition();
        transition.accept(position);
        field.getArrows().stream()
                .filter(arrow -> position.equals(arrow.getPosition()))
                .findAny()
                .ifPresent(arrow -> squareState.setDirection(arrow.getDirection()));
        fieldState.getSquareStates().values().stream()
                .filter(ss -> ss != squareState)
                .filter(ss -> position.equals(ss.getPosition()))
                .findAny()
                .ifPresent(ss -> move(ss, field, fieldState, transition));
    }

    public static boolean isFinal(FieldState fieldState, Field field) {
        for (Map.Entry<Color, Position> entry : field.getFinalPositions().entrySet()) {
            Color color = entry.getKey();
            Position finalSquarePosition = entry.getValue();
            Position squarePosition = fieldState.getSquareStates().get(color).getPosition();
            if (!Objects.equals(finalSquarePosition, squarePosition)) {
                return false;
            }
        }
        return true;
    }
}
