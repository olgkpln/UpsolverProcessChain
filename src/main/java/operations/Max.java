package operations;

import java.util.stream.Stream;

public class Max extends AbstractNumericOperation {

    public Max() {
    }

    @Override
    public Stream<String> execute(Stream<String> stream) {
        return numericFirstColumn(stream).max().stream().mapToObj(String::valueOf);
    }
}
