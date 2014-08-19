package gameaboutsquares.engine;

import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

/**
 * @author Tsydzik Dmitry
 * @since 8/16/2014.
 */
public class Arrow {
    private Direction direction;
    private Position position;

    public Arrow(@Nonnull Direction direction, int x, int y) {
        this.direction = direction;
        this.position = new Position(x, y);
    }

    @NotNull
    public Direction getDirection() {
        return direction;
    }

    @NotNull
    public Position getPosition() {
        return position;
    }
}
