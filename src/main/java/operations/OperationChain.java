package operations;

import java.util.stream.Stream;

public class OperationChain {

    private Stream<String> stream;

    private OperationChain() {}

    private OperationChain(Stream<String> stream) {
        this.stream = stream;
    }

    public static OperationChain create(Stream<String> stream) {
        return new OperationChain(stream);
    }

    public Stream<String> stream() {
        return stream;
    }

    public OperationChain sum() {
        return new OperationChain(new Sum().execute(stream));
    }

    public OperationChain avg() {
        return new OperationChain(new Avg().execute(stream));
    }

    public OperationChain min() {
        return new OperationChain(new Min().execute(stream));
    }

    public OperationChain max() {
        return new OperationChain(new Max().execute(stream));
    }

    public OperationChain pluck(int n) {
        return new OperationChain(new Pluck(n).execute(stream));
    }

    public OperationChain filter(int n, String x) {
        return new OperationChain(new Filter(n, x).execute(stream));
    }

    public OperationChain ceil() {
        return new OperationChain(new Ceil().execute(stream));
    }




}
