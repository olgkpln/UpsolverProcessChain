package operations;

import java.util.stream.Stream;

public class Sum extends AbstractNumericOperation {

    public Sum() {
    }

    @Override
    public Stream<String> execute(Stream<String> stream) {
        return Stream.of(String.valueOf(numericFirstColumn(stream).sum()));
    }
}
