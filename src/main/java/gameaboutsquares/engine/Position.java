package gameaboutsquares.engine;

/**
 * @author Dmitry Tsydzik
 * @since 8/16/2014.
 */
public class Position {
    private int x;
    private int y;

    public Position(Position position) {
        this.x = position.x;
        this.y = position.y;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Position position = (Position) object;

        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return x * 31 + y;
    }

    @Override
    public String toString() {
        return String.format("[%d, %d]", x, y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
