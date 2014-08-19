package gameaboutsquares.engine;

import gameaboutsquares.levels.Levels;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
    public void testName(int levelIndex) throws Exception {
        System.out.println(new Solver(Levels.levels.get(levelIndex)).solve());
    }
}