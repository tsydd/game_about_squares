package gameaboutsquares.levels;

import gameaboutsquares.engine.Color;
import gameaboutsquares.engine.Direction;
import gameaboutsquares.engine.Field;
import gameaboutsquares.engine.FieldState;

import java.util.Arrays;
import java.util.List;

/**
 * @author Tsydzik Dmitry
 * @since 8/16/2014.
 */
public class Levels {

    public static List<Level> levels = Arrays.asList(
            // 0
            new LevelImpl(
                    new Field().addPosition(Color.RED, 0, 0),
                    new FieldState().add(Color.RED, Direction.DOWN, 0, 2)),
            // 1
            new LevelImpl(
                    new Field()
                            .addPosition(Color.RED, 0, 1)
                            .addPosition(Color.BLUE, 0, 2),
                    new FieldState()
                            .add(Color.RED, Direction.UP, 0, 0)
                            .add(Color.BLUE, Direction.DOWN, 0, 3))
            ,
            // 2
            new LevelImpl(
                    new Field()
                            .addPosition(Color.RED, 2, 2)
                            .addPosition(Color.BLUE, 1, 2)
                            .addPosition(Color.BLACK, 1, 1),
                    new FieldState()
                            .add(Color.RED, Direction.RIGHT, 0, 2)
                            .add(Color.BLUE, Direction.UP, 1, 0)
                            .add(Color.BLACK, Direction.LEFT, 3, 1)),
            // 3
            new LevelImpl(
                    new Field()
                            .addPosition(Color.RED, 0, 2)
                            .addPosition(Color.BLUE, 2, 0),
                    new FieldState()
                            .add(Color.RED, Direction.LEFT, 4, 3)
                            .add(Color.BLUE, Direction.DOWN, 2, 5)),
            // 4
            new LevelImpl(
                    new Field().addPosition(Color.RED, 1, 2)
                            .addPosition(Color.BLUE, 3, 0)
                            .addPosition(Color.BLACK, 2, 1),
                    new FieldState()
                            .add(Color.RED, Direction.DOWN, 1, 3)
                            .add(Color.BLUE, Direction.RIGHT, 0, 2)
                            .add(Color.BLACK, Direction.DOWN, 2, 2)),
            // 5
            new LevelImpl(
                    new Field()
                            .addPosition(Color.RED, 1, 2)
                            .addPosition(Color.BLUE, 2, 1)
                            .addPosition(Color.BLACK, 3, 0),
                    new FieldState()
                            .add(Color.RED, Direction.DOWN, 1, 3)
                            .add(Color.BLUE, Direction.RIGHT, 0, 2)
                            .add(Color.BLACK, Direction.DOWN, 2, 2)),
            // 6
            new LevelImpl(
                    new Field()
                            .addPosition(Color.RED, 2, 0)
                            .addPosition(Color.BLUE, 1, 2)
                            .addPosition(Color.BLACK, 0, 3),
                    new FieldState()
                            .add(Color.RED, Direction.DOWN, 3, 3)
                            .add(Color.BLUE, Direction.LEFT, 4, 2)
                            .add(Color.BLACK, Direction.UP, 2, 1)),
            // 7
            new LevelImpl(
                    new Field()
                            .addPosition(Color.BLUE, 2, 2)
                            .addArrow(Direction.RIGHT, 0, 0)
                            .addArrow(Direction.UP, 2, 0),
                    new FieldState()
                            .add(Color.BLUE, Direction.DOWN, 0, 2)),
            // 8
            new LevelImpl(
                    new Field()
                            .addPosition(Color.YELLOW, 2, 2)
                            .addPosition(Color.BLACK, 3, 2)
                            .addArrow(Direction.RIGHT, 0, 0)
                            .addArrow(Direction.UP, 2, 0),
                    new FieldState()
                            .add(Color.YELLOW, Direction.DOWN, 0, 2)
                            .add(Color.BLACK, Direction.RIGHT, 0, 0)),
            // 9
            new LevelImpl(
                    new Field()
                            .addPosition(Color.YELLOW, 1, 1)
                            .addPosition(Color.BLUE, 2, 1)
                            .addArrow(Direction.RIGHT, 0, 0)
                            .addArrow(Direction.UP, 2, 0)
                            .addArrow(Direction.LEFT, 3, 0),
                    new FieldState()
                            .add(Color.YELLOW, Direction.RIGHT, 0, 0)
                            .add(Color.BLUE, Direction.UP, 2, 0)),
            // 10
            new LevelImpl(
                    new Field()
                            .addPosition(Color.BLACK, 0, 2)
                            .addPosition(Color.RED, 1, 2)
                            .addPosition(Color.BLUE, 3, 2)
                            .addArrow(Direction.RIGHT, 2, 2),
                    new FieldState()
                            .add(Color.BLACK, Direction.UP, 2, 0)
                            .add(Color.RED, Direction.DOWN, 2, 4)
                            .add(Color.BLUE, Direction.LEFT, 4, 2)),
            // 11
            new LevelImpl(
                    new Field()
                            .addPosition(Color.RED, 1, 2)
                            .addPosition(Color.BLUE, 2, 2)
                            .addPosition(Color.BLACK, 3, 2)
                            .addArrow(Direction.DOWN, 2, 4),
                    new FieldState()
                            .add(Color.RED, Direction.RIGHT, 0, 4)
                            .add(Color.BLUE, Direction.LEFT, 4, 4)
                            .add(Color.BLACK, Direction.UP, 2, 0)),
            // 12
            new LevelImpl(
                    new Field()
                            .addPosition(Color.YELLOW, 1, 1)
                            .addPosition(Color.BLACK, 1, 2)
                            .addArrow(Direction.DOWN, 1, 3)
                            .addArrow(Direction.LEFT, 3, 2),
                    new FieldState()
                            .add(Color.YELLOW, Direction.RIGHT, 0, 1)
                            .add(Color.BLACK, Direction.UP, 2, 0)),
            // 13
            new LevelImpl(
                    new Field()
                            .addPosition(Color.YELLOW, 0, 1)
                            .addPosition(Color.BLUE, 1, 3)
                            .addPosition(Color.BLACK, 1, 5)
                            .addArrow(Direction.DOWN, 1, 4),
                    new FieldState()
                            .add(Color.BLACK, Direction.DOWN, 1, 4)
                            .add(Color.BLUE, Direction.UP, 2, 0)
                            .add(Color.YELLOW, Direction.LEFT, 3, 2)),
            // 14
            new LevelImpl(
                    new Field()
                            .addPosition(Color.RED, 0, 2)
                            .addPosition(Color.BLUE, 1, 1)
                            .addPosition(Color.BLACK, 2, 0)
                            .addPosition(Color.YELLOW, 2, 2),
                    new FieldState()
                            .add(Color.YELLOW, Direction.RIGHT, 0, 1)
                            .add(Color.BLUE, Direction.UP, 1, 0)
                            .add(Color.BLACK, Direction.DOWN, 1, 2)
                            .add(Color.RED, Direction.LEFT, 2, 1)),
            // 15
            new LevelImpl(
                    new Field()
                            .addPosition(Color.RED, 1, 1)
                            .addPosition(Color.BLUE, 1, 0)
                            .addArrow(Direction.RIGHT, 0, 1)
                            .addArrow(Direction.DOWN, 0, 2)
                            .addArrow(Direction.LEFT, 3, 2),
                    new FieldState()
                            .add(Color.RED, Direction.DOWN, 0, 2)
                            .add(Color.BLUE, Direction.UP, 2, 0)),
            // 16
            new LevelImpl(
                    new Field()
                            .addPosition(Color.RED, 0, 1)
                            .addPosition(Color.BLUE, 3, 1)
                            .addArrow(Direction.RIGHT, 0, 2)
                            .addArrow(Direction.UP, 1, 0)
                            .addArrow(Direction.DOWN, 2, 2)
                            .addArrow(Direction.LEFT, 2, 1),
                    new FieldState()
                            .add(Color.RED, Direction.RIGHT, 0, 2)
                            .add(Color.BLUE, Direction.LEFT, 2, 1)),
            // 17
            new LevelImpl(
                    new Field()
                            .addPosition(Color.RED, 1, 1)
                            .addPosition(Color.BLACK, 2, 1)
                            .addPosition(Color.BLUE, 3, 1)
                            .addArrow(Direction.DOWN, 0, 2)
                            .addArrow(Direction.RIGHT, 0, 1)
                            .addArrow(Direction.UP, 2, 0)
                            .addArrow(Direction.LEFT, 3, 2),
                    new FieldState()
                            .add(Color.RED, Direction.DOWN, 0, 2)
                            .add(Color.BLACK, Direction.RIGHT, 0, 1)
                            .add(Color.BLUE, Direction.LEFT, 3, 2)),
            // 18
            new LevelImpl(
                    new Field()
                            .addPosition(Color.RED, 1, 1)
                            .addPosition(Color.BLACK, 2, 1)
                            .addPosition(Color.BLUE, 3, 1)
                            .addArrow(Direction.DOWN, 0, 2)
                            .addArrow(Direction.RIGHT, 0, 1)
                            .addArrow(Direction.UP, 2, 0)
                            .addArrow(Direction.LEFT, 3, 2),
                    new FieldState()
                            .add(Color.BLACK, Direction.DOWN, 0, 2)
                            .add(Color.RED, Direction.RIGHT, 0, 1)
                            .add(Color.BLUE, Direction.LEFT, 3, 2)),
            // 19
            new LevelImpl(
                    new Field()
                            .addPosition(Color.BLACK, 2, 2)
                            .addPosition(Color.BLUE, 2, 4)
                            .addPosition(Color.RED, 2, 6)
                            .addArrow(Direction.RIGHT, 0, 0)
                            .addArrow(Direction.DOWN, 0, 3)
                            .addArrow(Direction.RIGHT, 1, 1)
                            .addArrow(Direction.DOWN, 1, 2)
                            .addArrow(Direction.UP, 2, 1)
                            .addArrow(Direction.UP, 3, 0)
                            .addArrow(Direction.LEFT, 3, 2),
                    new FieldState()
                            .add(Color.RED, Direction.DOWN, 0, 3)
                            .add(Color.BLUE, Direction.DOWN, 1, 2)
                            .add(Color.BLACK, Direction.UP, 2, 1)),
            // 20
            new LevelImpl(
                    new Field()
                            .addPosition(Color.BLACK, 0, 1)
                            .addPosition(Color.PURPLE, 1, 0)
                            .addPosition(Color.GREEN, 1, 2)
                            .addPosition(Color.GRAY, 2, 1)
                            .addArrow(Direction.RIGHT, 0, 0)
                            .addArrow(Direction.UP, 2, 0)
                            .addArrow(Direction.DOWN, 0, 2)
                            .addArrow(Direction.LEFT, 2, 2)
                            .addArrow(Direction.UP, 0, -2),
                    new FieldState()
                            .add(Color.GREEN, Direction.RIGHT, 0, 0)
                            .add(Color.GRAY, Direction.UP, 2, 0)
                            .add(Color.BLACK, Direction.DOWN, 0, 2)
                            .add(Color.PURPLE, Direction.LEFT, 2, 2)),
            // 21
            new LevelImpl(
                    new Field()
                            .addPosition(Color.GRAY, 0, 3)
                            .addPosition(Color.YELLOW, 2, 1)
                            .addPosition(Color.GREEN, 2, 2)
                            .addPosition(Color.RED, 2, 3)
                            .addArrow(Direction.RIGHT, 0, 0)
                            .addArrow(Direction.DOWN, 0, 1)
                            .addArrow(Direction.UP, 0, 2)
                            .addArrow(Direction.DOWN, 0, 4)
                            .addArrow(Direction.UP, 2, 0)
                            .addArrow(Direction.LEFT, 2, 4),
                    new FieldState()
                            .add(Color.RED, Direction.RIGHT, 0, 0)
                            .add(Color.GREEN, Direction.UP, 2, 0)
                            .add(Color.YELLOW, Direction.LEFT, 2, 4)
                            .add(Color.GRAY, Direction.DOWN, 0, 4)),
            // 22
            new LevelImpl(
                    new Field()
                            .addPosition(Color.RED, 2, 4)
                            .addArrow(Direction.RIGHT, 0, 2)
                            .addArrow(Direction.UP, 1, 0)
                            .addArrow(Direction.DOWN, 1, 4)
                            .addArrow(Direction.LEFT, 4, 1),
                    new FieldState()
                            .add(Color.RED, Direction.RIGHT, 0, 2)
                            .add(Color.BLUE, Direction.DOWN, 1, 4)
                            .add(Color.BLACK, Direction.DOWN, 4, 3)),
            // 23
            new LevelImpl(
                    new Field()
                            .addPosition(Color.RED, 1, 1)
                            .addPosition(Color.BLUE, 2, 1)
                            .addPosition(Color.BLACK, 3, 1)
                            .addArrow(Direction.RIGHT, 0, 2)
                            .addArrow(Direction.UP, 2, 0)
                            .addArrow(Direction.DOWN, 2, 4)
                            .addArrow(Direction.LEFT, 4, 3),
                    new FieldState()
                            .add(Color.BLACK, Direction.RIGHT, 0, 2)
                            .add(Color.BLUE, Direction.DOWN, 1, 4)
                            .add(Color.RED, Direction.LEFT, 4, 3)),
            // 24
            new LevelImpl(
                    new Field()
                            .addPosition(Color.RED, 0, 5)
                            .addPosition(Color.BLUE, 1, 4)
                            .addPosition(Color.BLACK, 2, 3)
                            .addArrow(Direction.DOWN, 0, 3)
                            .addArrow(Direction.DOWN, 1, 2)
                            .addArrow(Direction.UP, 2, 1)
                            .addArrow(Direction.RIGHT, 0, 0)
                            .addArrow(Direction.RIGHT, 1, 1)
                            .addArrow(Direction.UP, 3, 0)
                            .addArrow(Direction.LEFT, 3, 2),
                    new FieldState()
                            .add(Color.RED, Direction.DOWN, 0, 3)
                            .add(Color.BLUE, Direction.DOWN, 1, 2)
                            .add(Color.BLACK, Direction.UP, 2, 1)),
            // 25
            new LevelImpl(
                    new Field()
                            .addPosition(Color.RED, 0, 3)
                            .addPosition(Color.BLUE, 1, 3)
                            .addPosition(Color.BLACK, 2, 3)
                            .addArrow(Direction.RIGHT, 0, 0)
                            .addArrow(Direction.DOWN, 0, 2)
                            .addArrow(Direction.UP, 2, 0)
                            .addArrow(Direction.LEFT, 3, 2),
                    new FieldState()
                            .add(Color.BLACK, Direction.RIGHT, 0, 0)
                            .add(Color.BLUE, Direction.DOWN, 0, 2)
                            .add(Color.RED, Direction.UP, 2, 0)),
            // 26
            new LevelImpl(
                    new Field()
                            .addPosition(Color.BLUE, 0, 2)
                            .addPosition(Color.RED, 1, 0)
                            .addPosition(Color.BLACK, 3, 1)
                            .addPosition(Color.YELLOW, 2, 3)
                            .addArrow(Direction.RIGHT, 0, 1)
                            .addArrow(Direction.UP, 2, 0)
                            .addArrow(Direction.LEFT, 3, 2)
                            .addArrow(Direction.DOWN, 1, 3),
                    new FieldState()
                            .add(Color.BLUE, Direction.RIGHT, 0, 1)
                            .add(Color.RED, Direction.UP, 2, 0)
                            .add(Color.BLACK, Direction.LEFT, 3, 2)
                            .add(Color.YELLOW, Direction.DOWN, 1, 3)),
            // 27
            new LevelImpl(
                    new Field()
                            .addPosition(Color.RED, 1, 1)
                            .addPosition(Color.BLUE, 2, 1)
                            .addPosition(Color.BLACK, 3, 1)
                            .addArrow(Direction.RIGHT, 0, 2)
                            .addArrow(Direction.DOWN, 1, 4)
                            .addArrow(Direction.LEFT, 4, 3)
                            .addArrow(Direction.UP, 3, 0)
                            .addArrow(Direction.DOWN, 3, 4),
                    new FieldState()
                            .add(Color.RED, Direction.RIGHT, 0, 2)
                            .add(Color.BLACK, Direction.DOWN, 1, 4)
                            .add(Color.BLUE, Direction.LEFT, 4, 3)),
            // 28
            new LevelImpl(
                    new Field()
                            .addPosition(Color.BLUE, 0, 3)
                            .addArrow(Direction.RIGHT, 0, 2)
                            .addArrow(Direction.UP, 1, 0)
                            .addArrow(Direction.DOWN, 1, 4)
                            .addArrow(Direction.LEFT, 4, 1),
                    new FieldState()
                            .add(Color.RED, Direction.RIGHT, 0, 2)
                            .add(Color.BLUE, Direction.DOWN, 1, 4)
                            .add(Color.BLACK, Direction.DOWN, 4, 3)),
            // 29
            new LevelImpl(
                    new Field()
                            .addPosition(Color.RED, 0, 1)
                            .addPosition(Color.BLUE, 1, 0)
                            .addPosition(Color.BLACK, 0, -1)
                            .addPosition(Color.YELLOW, -1, 0)
                            .addArrow(Direction.DOWN, 0, 2)
                            .addArrow(Direction.LEFT, 2, 0)
                            .addArrow(Direction.UP, 0, -2),
                    new FieldState()
                            .add(Color.RED, Direction.RIGHT, -2, 0)
                            .add(Color.BLUE, Direction.DOWN, 0, 2)
                            .add(Color.BLACK, Direction.LEFT, 2, 0)
                            .add(Color.YELLOW, Direction.UP, 0, -2)),
            // 30
            new LevelImpl(
                    new Field()
                            .addPosition(Color.RED, 0, 1)
                            .addPosition(Color.BLUE, 0, 2)
                            .addPosition(Color.BLACK, 1, 3)
                            .addArrow(Direction.RIGHT, 0, 0)
                            .addArrow(Direction.DOWN, 0, 3)
                            .addArrow(Direction.UP, 2, 0)
                            .addArrow(Direction.LEFT, 3, 3),
                    new FieldState()
                            .add(Color.RED, Direction.RIGHT, 0, 0)
                            .add(Color.BLACK, Direction.DOWN, 0, 3)
                            .add(Color.BLUE, Direction.UP, 2, 0)),
            // 31
            new LevelImpl(
                    new Field()
                            .addPosition(Color.RED, 0, 0)
                            .addPosition(Color.BLUE, -2, 0)
                            .addPosition(Color.BLACK, 2, 0)
                            .addArrow(Direction.RIGHT, -1, 1)
                            .addArrow(Direction.DOWN, 0, 2)
                            .addArrow(Direction.LEFT, 1, 0)
                            .addArrow(Direction.UP, 0, -2),
                    new FieldState()
                            .add(Color.BLACK, Direction.RIGHT, -1, 1)
                            .add(Color.BLUE, Direction.DOWN, 0, 2)
                            .add(Color.RED, Direction.LEFT, 1, 0)),
            // 32
            new LevelImpl(
                    new Field()
                            .addPosition(Color.BLUE, 0, 3)
                            .addPosition(Color.RED, 2, 4)
                            .addArrow(Direction.RIGHT, 0, 2)
                            .addArrow(Direction.DOWN, 1, 4)
                            .addArrow(Direction.UP, 1, 0)
                            .addArrow(Direction.LEFT, 4, 1),
                    new FieldState()
                            .add(Color.RED, Direction.RIGHT, 0, 2)
                            .add(Color.BLUE, Direction.DOWN, 1, 4)
                            .add(Color.BLACK, Direction.DOWN, 4, 3)),
            // 33
            new LevelImpl(
                    new Field()
                            .addPosition(Color.BLUE, 0, 3)
                            .addPosition(Color.RED, 1, 3)
                            .addPosition(Color.BLACK, 2, 3)
                            .addArrow(Direction.RIGHT, 1, 0)
                            .addArrow(Direction.DOWN, 1, 2)
                            .addArrow(Direction.UP, 3, 0)
                            .addArrow(Direction.LEFT, 4, 2),
                    new FieldState()
                            .add(Color.BLACK, Direction.RIGHT, 1, 0)
                            .add(Color.BLUE, Direction.DOWN, 1, 2)
                            .add(Color.RED, Direction.UP, 3, 0)),
            // 34
            new LevelImpl(
                    new Field()
                            .addPosition(Color.BLACK, 1, 0)
                            .addPosition(Color.RED, 2, 1)
                            .addPosition(Color.BLUE, 3, 0)
                            .addArrow(Direction.RIGHT, 0, 1)
                            .addArrow(Direction.DOWN, 0, 2)
                            .addArrow(Direction.LEFT, 3, 2)
                            .addArrow(Direction.UP, 2, 0),
                    new FieldState()
                            .add(Color.RED, Direction.RIGHT, 0, 1)
                            .add(Color.BLACK, Direction.DOWN, 0, 2)
                            .add(Color.BLUE, Direction.LEFT, 3, 2)),
            // 35
            new LevelImpl(
                    new Field()
                            .addPosition(Color.BLACK, 2, 4)
                            .addPosition(Color.RED, 3, 4)
                            .addPosition(Color.YELLOW, 4, 4)
                            .addArrow(Direction.RIGHT, 0, 1)
                            .addArrow(Direction.DOWN, 1, 4)
                            .addArrow(Direction.UP, 3, 0)
                            .addArrow(Direction.LEFT, 4, 3),
                    new FieldState()
                            .add(Color.YELLOW, Direction.RIGHT, 0, 0)
                            .add(Color.RED, Direction.RIGHT, 1, 0)
                            .add(Color.BLACK, Direction.RIGHT, 2, 0))
    );
}
