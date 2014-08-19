package gameaboutsquares.levels;

import gameaboutsquares.engine.Field;
import gameaboutsquares.engine.FieldState;

/**
 * @author Tsydzik Dmitry
 * @since 8/16/2014.
 */
public interface Level {
    Field getField();

    FieldState getInitialState();
}
