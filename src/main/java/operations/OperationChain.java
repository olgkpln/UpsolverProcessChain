package operations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperationChain {

    private final ChainMode mode;
    private List<Stream<String>> streams;

    private OperationChain(List<Stream<String>> streams, ChainMode mode) {
        if (mode == ChainMode.FLATTEN) {
            while (streams.size() > 1) {
                var first = streams.remove(0);
                var second = streams.remove(0);
                var concatenated = Stream.concat(first, second);
                streams.add(0, concatenated);
            }
        }
        this.streams = streams;
        this.mode = mode;
    }

    public static OperationChain create(List<Stream<String>> streams, ChainMode mode) {
        return new OperationChain(streams, mode);
    }

    public List<Stream<String>> streams() {
        return streams;
    }

    public OperationChain sum() {
        return new OperationChain(streams.stream().map(x -> new Sum().execute(x)).collect(Collectors.toList()), mode);
    }

    public OperationChain avg() {
        return new OperationChain(streams.stream().map(x -> new Avg().execute(x)).collect(Collectors.toList()), mode);
    }

    public OperationChain min() {
        return new OperationChain(streams.stream().map(x -> new Min().execute(x)).collect(Collectors.toList()), mode);
    }

    public OperationChain max() {
        return new OperationChain(streams.stream().map(x -> new Max().execute(x)).collect(Collectors.toList()), mode);
    }

    public OperationChain pluck(int n) {
        return new OperationChain(streams.stream().map(x -> new Pluck(n).execute(x)).collect(Collectors.toList()), mode);
    }

    public OperationChain filter(int n, String s) {
        return new OperationChain(streams.stream().map(x -> new Filter(n, s).execute(x)).collect(Collectors.toList()), mode);
    }

    public OperationChain ceil() {
        return new OperationChain(streams.stream().map(x -> new Ceil().execute(x)).collect(Collectors.toList()), mode);
    }

    public enum ChainMode {
        FOR_EACH,
        FLATTEN
    }


}
