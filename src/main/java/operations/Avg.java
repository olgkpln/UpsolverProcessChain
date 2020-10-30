package operations;

import java.util.stream.Stream;

public class Avg extends AbstractNumericOperation {

    public Avg() {
    }

    @Override
    public Stream<String> execute(Stream<String> stream) {
        return numericFirstColumn(stream).average().stream().mapToObj(String::valueOf);
    }
}
