package sorting;

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
        T pivot = mixedArray[lastIndex];
        int i = firstIndex - 1;

        for (int j = firstIndex; j < lastIndex; j++) {
            if (!order.test(mixedArray[j].compareTo(pivot))) {
                i++;

                T swapTemp = mixedArray[j];
                mixedArray[j] = mixedArray[i];
                mixedArray[i] = swapTemp;
            }
        }

        T swapTemp = mixedArray[i + 1];
        mixedArray[i + 1] = mixedArray[lastIndex];
        mixedArray[lastIndex] = swapTemp;

        return i + 1;
    }
}
