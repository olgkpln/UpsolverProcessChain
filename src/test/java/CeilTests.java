import operations.Ceil;
import operations.Pluck;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

public class CeilTests {

    @Test
    public void ctorTest() {
        var ceil = new Ceil();
    }

    @Test
    public void basicPluckTest() {
        var ceil = new Ceil();
        var roundedUp = ceil.execute("1.2,3.4,5.6".lines());
        assert roundedUp.collect(Collectors.joining("\n")).compareTo("2.0") == 0;
    }

    @Test
    public void complexPluckTest() {
        var ceil = new Ceil();
        var roundedUp = ceil.execute((
                "1.2,3.4,5.6\n" +
                "7.8,9.1,2.3").lines());
        assert roundedUp.collect(Collectors.joining("\n")).compareTo("2.0\n8.0") == 0;
    }

    @Test
    public void evenMoreComplexPluckTest() {
        var ceil = new Ceil();
        var roundedUp = ceil.execute((
                "a,b,c\n" +
                "1.2,3.4,5.6\n" +
                "7.8,9.1,2.3").lines());
        assert roundedUp.collect(Collectors.joining("\n")).compareTo("2.0\n8.0") == 0;
    }

}
