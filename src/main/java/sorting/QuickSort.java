package sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.function.Predicate;

public class QuickSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sorting(T[] mixedArray, SortType type) {
        Predicate<Integer> order = SortType.getPredicate(type);
        run(mixedArray, order, 0, mixedArray.length - 1);
    }

    private void run(T[] mixedArray, Predicate<Integer> order, int firstIndex, int lastIndex) {
        if (firstIndex >= lastIndex) {
            return;
        }
        int partitionIndex = partition(mixedArray, order, firstIndex, lastIndex);

        run(mixedArray, order, firstIndex, partitionIndex - 1);
        run(mixedArray, order, partitionIndex + 1, lastIndex);
    }

    private int partition(T[] mixedArray, Predicate<Integer> order, int firstIndex, int lastIndex) {
        int pivotIndex = new SplittableRandom().nextInt(firstIndex, lastIndex + 1);

        exchange(mixedArray, pivotIndex, lastIndex);

        T pivot = mixedArray[lastIndex];
        int i = firstIndex - 1;

        for (int j = firstIndex; j < lastIndex; j++) {
            if (!order.test(mixedArray[j].compareTo(pivot))) {
                i++;
                exchange(mixedArray, j, i);
            }
        }
        exchange(mixedArray, i + 1, lastIndex);
        return i + 1;
    }

    private void exchange(T[] mixedArray, int firstIndex, int secondIndex) {
        T swapTemp = mixedArray[firstIndex];
        mixedArray[firstIndex] = mixedArray[secondIndex];
        mixedArray[secondIndex] = swapTemp;
    }
}
