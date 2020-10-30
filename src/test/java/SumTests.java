import operations.Sum;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

public class SumTests {

    @Test
    public void basicSumTest() {
        var sum = new Sum();
        var res = sum.execute("1,2,3".lines());

        assert res.collect(Collectors.joining("\n")).compareTo("1.0") == 0;
    }

    @Test
    public void complexSumTest() {
        var sum = new Sum();
        var res = sum.execute((
                "1,2,3\n" +
                "4,5,6").lines());
        assert res.collect(Collectors.joining("\n")).compareTo("5.0") == 0;
    }

    @Test
    public void evenMoreComplexSumTest() {
        var sum = new Sum();
        var res = sum.execute((
                "a,b,c\n" +
                "1,2,3\n" +
                "4,5,6").lines());
        assert res.collect(Collectors.joining("\n")).compareTo("5.0") == 0;
    }

}
