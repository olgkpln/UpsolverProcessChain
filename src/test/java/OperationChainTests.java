import operations.OperationChain;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperationChainTests {

    private List<Stream<String>> getTestData() throws URISyntaxException, IOException {
        return List.of(Files.lines(Paths.get(Part1.class.getResource("SampleStudentData.csv").toURI())));
    }

    @Test
    public void pluckTest() throws IOException, URISyntaxException {
        String sum = OperationChain
                .create(getTestData(), OperationChain.ChainMode.FOR_EACH)
                .pluck(11)
                .streams()
                .get(0)
                .collect(Collectors.joining("\n"));
        assert sum.compareTo("mark\n85\n28\n54\n71\n19") == 0;
    }

    @Test
    public void sumTest() throws IOException, URISyntaxException {
        String sum = OperationChain
                .create(getTestData(), OperationChain.ChainMode.FOR_EACH)
                .pluck(11)
                .sum()
                .streams()
                .get(0)
                .collect(Collectors.joining("\n"));
        assert sum.compareTo("257.0") == 0;
    }

    @Test
    public void avgTest() throws IOException, URISyntaxException {
        String avg = OperationChain
                .create(getTestData(), OperationChain.ChainMode.FOR_EACH)
                .pluck(11)
                .avg()
                .streams()
                .get(0)
                .collect(Collectors.joining("\n"));
        assert avg.compareTo("51.4") == 0;
    }

    @Test
    public void ceilTest() throws IOException, URISyntaxException {
        String ceil = OperationChain
                .create(getTestData(), OperationChain.ChainMode.FOR_EACH)
                .pluck(11)
                .avg()
                .ceil()
                .streams()
                .get(0)
                .collect(Collectors.joining("\n"));
        assert ceil.compareTo("52.0") == 0;
    }

    @Test
    public void minTest() throws IOException, URISyntaxException {
        String min = OperationChain
                .create(getTestData(), OperationChain.ChainMode.FOR_EACH)
                .pluck(11)
                .min()
                .streams()
                .get(0)
                .collect(Collectors.joining("\n"));
        assert min.compareTo("19.0") == 0;
    }

    @Test
    public void maxTest() throws IOException, URISyntaxException {
        String max = OperationChain
                .create(getTestData(), OperationChain.ChainMode.FOR_EACH)
                .pluck(11)
                .max()
                .streams()
                .get(0)
                .collect(Collectors.joining("\n"));
        assert max.compareTo("85.0") == 0;
    }

    @Test
    public void filterTest() throws IOException, URISyntaxException {
        String max = OperationChain
                .create(getTestData(), OperationChain.ChainMode.FOR_EACH)
                .pluck(11)
                .filter(0, "85")
                .streams()
                .get(0)
                .collect(Collectors.joining("\n"));
        assert max.compareTo("85") == 0;
    }

    @Test
    public void filterPluckMax() throws IOException, URISyntaxException {
        String max = OperationChain
                .create(getTestData(), OperationChain.ChainMode.FOR_EACH)
                .filter(3,"Iowa")
                .pluck(11)
                .max()
                .streams()
                .get(0)
                .collect(Collectors.joining("\n"));
        assert max.compareTo("54.0") == 0;
    }

}
