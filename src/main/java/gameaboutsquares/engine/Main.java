package gameaboutsquares.engine;

import gameaboutsquares.levels.Levels;

import java.util.List;

/**
 * @author Tsydzik Dmitry
 * @since 8/16/2014.
 */
public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<Color> solution = new Solver(Levels.getLevel(20)).solve();
        System.out.println(solution);
        System.out.println(System.currentTimeMillis() - start);
    }
}
