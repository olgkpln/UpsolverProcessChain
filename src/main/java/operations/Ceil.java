package operations;

import java.util.stream.Stream;

public class Ceil extends AbstractNumericOperation {

    public Ceil() {
    }

    @Override
    public Stream<String> execute(Stream<String> line) {
        return numericFirstColumn(line).map(Math::ceil).mapToObj(String::valueOf);
    }
}
