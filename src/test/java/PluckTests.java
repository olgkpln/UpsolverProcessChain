import operations.Pluck;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

public class PluckTests {

    @Test
    public void ctorTest() {
        var pluck = new Pluck(5);
    }

    @Test
    public void basicPluckTest() {
        var pluck = new Pluck(5);
        var plucked = pluck.execute("a,b,c,d,e,f".lines());
        assert plucked.collect(Collectors.joining(",")).compareTo("f") == 0;
    }
}
