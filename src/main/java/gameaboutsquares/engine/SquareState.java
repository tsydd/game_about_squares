package gameaboutsquares.engine;

import javax.annotation.Nonnull;

/**
 * @author Tsydzik Dmitry
 * @since 8/16/2014.
 */
public class SquareState {
    private Direction direction;
    private Position position;

    public SquareState(@Nonnull SquareState squareState) {
        this.position = new Position(squareState.position);
        this.direction = squareState.direction;
    }

    public SquareState(@Nonnull Direction direction, int x, int y) {
        this.direction = direction;
        this.position = new Position(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SquareState another = (SquareState) obj;
        return direction.equals(another.direction) && position.equals(another.position);
    }

    @Override
    public int hashCode() {
        return position.hashCode() * 31 + direction.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s: %s", direction, position);
    }

    @Nonnull
    public Direction getDirection() {
        return direction;
    }

    public void setDirection(@Nonnull Direction direction) {
        this.direction = direction;
    }

    @Nonnull
    public Position getPosition() {
        return position;
    }

    public void setPosition(@Nonnull Position position) {
        this.position = position;
    }
}
