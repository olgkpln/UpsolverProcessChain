import operations.OperationChain;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessChain {

    public static void main(String[] args) {

        var inputFileName = "0.csv";
        var outputFileName = "result.csv";

        try(Stream<String> stream = Files.lines(Paths.get(ProcessChain.class.getResource(inputFileName).toURI()));
            OutputStream os = new FileOutputStream(outputFileName)) {

            var result = OperationChain
                    .create(stream)
                    .filter(3, "Iowa")
                    .pluck(10)
                    .max()
                    .stream()
                    .collect(Collectors.joining("\n"));


            os.write(result.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
