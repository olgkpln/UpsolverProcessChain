import operations.Avg;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

public class AvgTests {

    @Test
    public void basicAvgTest() {
        var avg = new Avg();
        var res = avg.execute("1,2,3".lines());
        assert res.collect(Collectors.joining("\n")).compareTo("1.0") == 0;
    }

    @Test
    public void complexAvgTest() {
        var avg = new Avg();
        var res = avg.execute(
                ("1,2,3\n" +
                "4,5,6").lines());
        assert res.collect(Collectors.joining("\n")).compareTo("2.5") == 0;
    }

    @Test
    public void evenMoreComplexAvgTest() {
        var avg = new Avg();
        var res = avg.execute(
                ("a,b,c\n" +
                 "1,2,3\n" +
                 "4,5,6").lines());
        assert res.collect(Collectors.joining("\n")).compareTo("2.5") == 0;
    }

}
