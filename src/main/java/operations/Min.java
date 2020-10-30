package operations;

import java.util.stream.Stream;

public class Min extends AbstractNumericOperation {

    public Min() {
    }

    @Override
    public Stream<String> execute(Stream<String> stream) {
        return numericFirstColumn(stream).min().stream().mapToObj(String::valueOf);
    }
}
