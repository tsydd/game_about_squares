package gameaboutsquares.levels;

import gameaboutsquares.engine.Field;
import gameaboutsquares.engine.FieldState;

/**
 * @author Tsydzik Dmitry
 * @since 8/16/2014.
 */
public class LevelImpl implements Level {

    private Field field;
    private FieldState initialState;

    public LevelImpl(Field field, FieldState initialState) {
        this.field = field;
        this.initialState = initialState;
    }

    @Override
    public Field getField() {
        return field;
    }

    @Override
    public FieldState getInitialState() {
        return initialState;
    }
}
