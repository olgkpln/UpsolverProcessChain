package operations;

import java.util.stream.Stream;

public interface IOperation {

    Stream<String> execute(Stream<String> stream);
}
