import java.util.function.BinaryOperator;
import java.util.function.Supplier;

@FunctionalInterface
public interface SmartInterface<T> {
    boolean run(T[] array, BinaryOperator<T> binaryOperator, Supplier<T> defaultValue);
}
