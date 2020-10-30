import operations.Min;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

public class MinTests {

    @Test
    public void basicMinTest() {
        var min = new Min();
        var res = min.execute("1,2,3".lines());
        assert res.collect(Collectors.joining("\n")).compareTo("1.0") == 0;
    }

    @Test
    public void complexMinTest() {
        var min = new Min();
        var res = min.execute(
                ("1,2,3\n" +
                "4,5,6").lines());
        assert res.collect(Collectors.joining("\n")).compareTo("1.0") == 0;
    }

    @Test
    public void evenMoreComplexMinTest() {
        var min = new Min();
        var res = min.execute(
                ("a,b,c\n" +
                 "1,2,3\n" +
                 "4,5,6").lines());
        assert res.collect(Collectors.joining("\n")).compareTo("1.0") == 0;
    }

}
