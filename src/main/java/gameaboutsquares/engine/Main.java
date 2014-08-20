package gameaboutsquares.engine;

import gameaboutsquares.levels.Levels;

import java.util.List;

/**
 * @author Tsydzik Dmitry
 * @since 8/16/2014.
 */
public class Main {

    private static void solveLevel(int levelIndex) {
        long start = System.currentTimeMillis();
        List<Color> solution = new Solver(Levels.levels.get(levelIndex)).solve();
        System.out.printf("level: %d%ntime: %d%nsteps: %d%nsolution: %s%n%n",
                levelIndex,
                System.currentTimeMillis() - start,
                solution.size(),
                solution);
    }
    public static void main(String[] args) {
        solveAll();
    }

    private static void solveAll() {
        for (int i = 0; i < Levels.levels.size(); i++) {
            try {
                solveLevel(i);
            } catch (NullPointerException ignored) {
                System.err.printf("level %d is not solved%n%n", i);
            }
        }
    }
}
