package operations;

import java.util.stream.Stream;

public class Pluck implements IOperation {

    private final int n;

    public Pluck(int n) {
        this.n = n;
    }

    @Override
    public Stream<String> execute(Stream<String> line) {
        return line.map(x -> x.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1)[n]);
    }
}
