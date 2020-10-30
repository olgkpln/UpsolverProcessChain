package operations;

import java.util.stream.Stream;

public class Filter implements IOperation {

    private final int n;
    private final String x;

    public Filter(int n, String x) {
        this.n = n;
        this.x = x;
    }

    @Override
    public Stream<String> execute(Stream<String> stream) {
        return stream.filter(s -> s.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1)[n].compareTo(x) == 0);
    }
}
