import operations.OperationChain;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Part3 {

    public static void main(String[] args) {

        var inputFileNames = List.of("0.csv", "1.csv", "2.csv", "3.csv", "4.csv", "5.csv");
        var outputFilePrefix = "result";

        List<Stream<String>> inputStreams = new LinkedList<>();
        for (var fileName : inputFileNames) {
            try {
                Stream<String> stream = Files.lines(Paths.get(Part3.class.getResource(fileName).toURI()));
                inputStreams.add(stream);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        var classAverage = OperationChain
            .create(inputStreams, OperationChain.ChainMode.FOR_EACH)
            .pluck(10)
            .avg()
            .streams();

        var maxAverage = OperationChain
            .create(classAverage, OperationChain.ChainMode.FLATTEN)
            .max();

        int i = 0;
        for (var stream : maxAverage.streams()) {
            try (OutputStream os = new FileOutputStream(String.format("%s%d.csv", outputFilePrefix, i))) {
                stream.forEachOrdered(x -> {
                    try {
                        os.write(x.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }  catch (Exception e) {
                e.printStackTrace();
            }
            i++;
        }

        for (var inputStream : inputStreams) {
            inputStream.close();
        }
    }
}
