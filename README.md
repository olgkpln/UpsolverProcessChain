# UpsolverProcessChain

This project offers a solution for Upsolver code interview question which can be found [here](https://gist.github.com/shanielh/e9be971efb5331f653490e90c014d255).

The solution uses basic Java's Stream API capabilities and wraps them with the operations I was required to implement.

You can find the proposed solutions for each part under Part1.java, Part2.java and Part3.java which are the main() bootstrap
code that uses the OperationChain API which simplifies the writing & reading of the code and uses the Stream API conventions.

## How to use OperationChain  
Use the built in `create(...)` static initializer and provide 2 parameters:
- `List<Stream<String>> streams` list of streams we want to apply the operations on
- `ChainMode mode` the chain mode 
    - `FOR_EACH` to handle each stream separately.
    - `FLATTEN` to flatten the results into single output.
      
After the initialization things become easier, the class provides the following methods:
- `sum` - Outputs the sum of the first column in the data
- `avg` - Outputs the average of the first column in the data
- `min` - Outputs the minimum value of the first column in the data
- `max` - Outputs the maximum value of the first column in the data
- `pluck({n})` - Outputs the `n`’th field (zero indexed) as row from every row
- `filter({n},{x})` - Outputs all the rows where `n`’th field is equal to `x`
- `ceil` - Outputs the ceiling (round up) of the first column in the data

The `sum`, `avg`, `min`, `max` and `ceil` operations are ignoring non numeric values and simply skips them.

In order to chain operation simply apply the methods of after the other, for example in order to preform this:  
```
pluck(11) -> avg -> ceil
```
you should write
```java
OperationChain.create(List.of(stream), OperationChain.ChainMode.FOR_EACH)
    .pluck(11)    
    .avg()
    .ceil();
```
in order to retrieve the result use the `streams()` method which effectively returns a `List<Stream<String>>` as a result.  

You can find examples of usage in the Part1.java, Part2.java and Part3.java including a proposal of how to read and write
from and to the source and target files.

Note that for part 3 there are no intermediate files created, the output of the first calculation is used as the input
for the second part:
```java
var classAverage = OperationChain
    .create(inputStreams, OperationChain.ChainMode.FOR_EACH)
    .pluck(10)
    .avg()
    .streams();

var maxAverage = OperationChain
    .create(classAverage, OperationChain.ChainMode.FLATTEN)
    .max();
```

## How to run
I've used Maven in order to ease the build of the project.
You can run the different parts of the solution from the command line of directly from you IDE (IJ in my case).
The provided input files are located under the resources directory and the results are written directly to the project root.

## Testing
I've also written some unit tests which helped me change the code quicker when progressing from part 1 to parts 2 and 3.

## GitHub Workflow
There is also automatic code ccompilationand testing using the GitHub workflows engine. 

# Thanks for giving me the chance