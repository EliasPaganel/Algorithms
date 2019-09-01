package search;

import java.util.Objects;

public class LinearSearch<T extends Comparable<T>> implements Search<T>{

    public int search(T[] sortedArray, T item) {
        Objects.requireNonNull(sortedArray, "SortedArray is null");
        Objects.requireNonNull(item, "Item is null");

        if (sortedArray.length <= 0) {
            return -1;
        }

        for (int i = 0; i < sortedArray.length; i++) {
            if (sortedArray[i].compareTo(item) == 0) {
                return i;
            }
        }

        return -1;
    }
}
