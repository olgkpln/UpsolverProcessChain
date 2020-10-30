package operations;

import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public abstract class AbstractNumericOperation implements IOperation {

    protected Stream<String> filterNonNumeric(Stream<String> stream) {
        return stream.filter(x -> {
            var s = x.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            try {
                Double.parseDouble(s[0]);
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        });
    }

    protected DoubleStream numericFirstColumn(Stream<String> stream) {
        return filterNonNumeric(stream).mapToDouble(x -> Double.parseDouble(x.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1)[0]));
    }

}
