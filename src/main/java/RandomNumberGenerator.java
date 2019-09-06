import java.util.Arrays;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class RandomNumberGenerator<T extends Number> {

    private Random rnd;

    public T[] genArray(int length) {
        return null;
    }

    public T operation(T[] array, BinaryOperator<T> binaryOperator, Supplier<T> defaultValue) {
        if (array.length == 0) {
            return defaultValue.get();
        }
        return execute(array, binaryOperator);
    }

    private T execute(T[] array, BinaryOperator<T> binaryOperator) {
        if(array.length == 1) {
            return array[0];
        }
        return binaryOperator.apply(array[0], execute(Arrays.copyOfRange(array, 1, array.length), binaryOperator));
    }

    public T operationCycle(T[] array, BinaryOperator<T> binaryOperator, Supplier<T> defaultValue) {
        T temp = defaultValue.get();
        if (array.length == 0) {
            return temp;
        }

        if(array.length == 1) {
            return array[0];
        }

        for (T item : array) {
            temp = binaryOperator.apply(temp, item);
        }
        return temp;
    }

    public void testFunction(SmartInterface<T> smartInterface, Integer times, String tastName, T[] array, BinaryOperator<T> binaryOperator, Supplier<T> defaultValue) {
        long beginTesting = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            smartInterface.run(array, binaryOperator, defaultValue);
        }
        long endTesting = System.currentTimeMillis();
        double timeProcessing = (endTesting - beginTesting)/1000.0;
        System.out.println(tastName + " " + timeProcessing + "s");
    }
}
