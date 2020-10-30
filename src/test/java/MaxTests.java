import operations.Max;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

public class MaxTests {

    @Test
    public void basicMaxTest() {
        var max = new Max();
        var res = max.execute("1,2,3".lines());
        assert res.collect(Collectors.joining("\n")).compareTo("1.0") == 0;
    }

    @Test
    public void complexMaxTest() {
        var max = new Max();
        var res = max.execute(
                ("1,2,3\n" +
                "4,5,6").lines());
        assert res.collect(Collectors.joining("\n")).compareTo("4.0") == 0;
    }

    @Test
    public void evenMoreComplexMaxTest() {
        var max = new Max();
        var res = max.execute(
                ("a,b,c\n" +
                 "1,2,3\n" +
                 "4,5,6").lines());
        assert res.collect(Collectors.joining("\n")).compareTo("4.0") == 0;
    }

}
