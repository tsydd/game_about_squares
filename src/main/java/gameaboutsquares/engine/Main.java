package gameaboutsquares.engine;

import gameaboutsquares.levels.Level;
import gameaboutsquares.levels.Levels;

import java.util.List;

/**
 * @author Tsydzik Dmitry
 * @since 8/16/2014.
 */
public class Main {
    public static void main(String[] args) {
        Level level = Levels.getLevel(21);
        List<Color> solution = new Solver(level.getInitialState(), level.getField()).solve();
        System.out.println(solution);
    }
}
