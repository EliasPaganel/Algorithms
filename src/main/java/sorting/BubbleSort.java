package sorting;

import java.util.function.Predicate;

public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    public void sorting(T[] mixedArray, SortType type) {
        if (mixedArray == null || mixedArray.length == 0) {
            throw new RuntimeException("Input parameters is null");
        }
        Predicate<Integer> predicate = SortType.getPredicate(type);

        T tempItem;
        for (int i = 0; i < mixedArray.length - 1; i++) {
            for (int j = mixedArray.length - 1; j > 0; j--) {
                if(predicate.test(mixedArray[j - 1].compareTo(mixedArray[j]))){
                    tempItem = mixedArray[j];
                    mixedArray[j] = mixedArray[j - 1];
                    mixedArray[j - 1] = tempItem;
                }
            }
        }
    }
}
