import operations.Filter;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

public class FilterTests {

    @Test
    public void ctorTest() {
        var filter = new Filter(5,"A");
    }

    @Test
    public void basicFilterTest() {
        var filter = new Filter(5, "f");
        var filtered = filter.execute("a,b,c,d,e,f".lines());
        assert filtered.collect(Collectors.joining("\n")).compareTo("a,b,c,d,e,f") == 0;
    }

    @Test
    public void complexFilterTest() {
        var filter = new Filter(5,"f");
        var filtered = filter.execute("a,b,c,d,e,f\na,b,c,d,e,g".lines());
        assert filtered.collect(Collectors.joining("\n")).compareTo("a,b,c,d,e,f") == 0;
    }

    @Test
    public void evenMoreComplexFilterTest() {
        var filter = new Filter(5, "f");
        var filtered = filter.execute((
                "a,b,c,d,e,f\n" +
                "a,b,c,d,e,g\n" +
                "1,2,3,4,5,f").lines());
        assert filtered.collect(Collectors.joining("\n")).compareTo(
                "a,b,c,d,e,f\n" +
                "1,2,3,4,5,f") == 0;
    }

}
