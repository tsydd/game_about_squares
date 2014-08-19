package gameaboutsquares.engine;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Tsydzik Dmitry
 * @since 8/16/2014.
 */
public class Field {
    private Map<Color, Position> finalPositions = new HashMap<>();
    private List<@Nonnull Arrow> arrows = new LinkedList<>();

    public Field addArrow(Direction direction, int x, int y) {
        arrows.add(new Arrow(direction, x, y));
        return this;
    }

    public Field addPosition(Color color, int x, int y) {
        finalPositions.put(color, new Position(x, y));
        return this;
    }

    public Map<Color, Position> getFinalPositions() {
        return finalPositions;
    }

    public List<@Nonnull Arrow> getArrows() {
        return arrows;
    }
}
