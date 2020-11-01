import operations.OperationChain;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Part1 {

    public static void main(String[] args) {

        var inputFileName = "0.csv";
        var outputFileName = "result.csv";

        try (Stream<String> stream = Files.lines(Paths.get(Part1.class.getResource(inputFileName).toURI()));
            OutputStream os = new FileOutputStream(outputFileName)) {

            var result = OperationChain
                    .create(List.of(stream), OperationChain.ChainMode.FOR_EACH)
                    .filter(3, "Iowa")
                    .pluck(10)
                    .max()
                    .streams()
                    .get(0);

            result.forEachOrdered(x -> {
                try {
                    os.write(x.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
