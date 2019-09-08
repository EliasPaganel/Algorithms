package sorting;

import java.util.Objects;
import java.util.function.Predicate;

public class SelectionSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sorting(T[] mixedArray, SortType type) {
        Objects.requireNonNull(mixedArray);
        Predicate<Integer> predicate = SortType.getPredicate(type);
        T tempItem;
        int leastIndex = 0;
        for (int i = 0; i < mixedArray.length - 1; i++) {
            for (int j = leastIndex + 1; j < mixedArray.length; j++) {
                if(predicate.test(mixedArray[leastIndex].compareTo(mixedArray[j]))) {
                    tempItem = mixedArray[leastIndex];
                    mixedArray[leastIndex] = mixedArray[j];
                    mixedArray[j] = tempItem;
                }
            }
            leastIndex++;
        }
    }
}
