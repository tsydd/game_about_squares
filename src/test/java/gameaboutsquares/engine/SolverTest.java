package gameaboutsquares.engine;

import gameaboutsquares.levels.Levels;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class SolverTest {

    @DataProvider(name = "data")
    public Object[][] getData() {
        Object[][] levels = new Object[Levels.levels.size()][1];
        for (int i = 0; i < levels.length; i++) {
            levels[i][0] = i;
        }
        return levels;
    }

    @Test(dataProvider = "data")
    public void testLevelsComplete(int levelIndex) throws Exception {
        List<Color> solution = new Solver(Levels.levels.get(levelIndex)).solve();
        System.out.printf("%d: %d: %s", levelIndex, solution.size(), solution);
    }
}