package search;

import java.util.Objects;

/**
 * Реализация бинарного поиска, по массиву типов, которые наследуют интерфейс Comparable
 *
 * @param <T>
 */
public class BinarySearch<T extends Comparable<T>> implements Search<T> {


    public int search(T[] sortedArray, T item) {
        Objects.requireNonNull(sortedArray, "SortedArray is null");
        Objects.requireNonNull(item, "Item is null");

        if (sortedArray.length <= 0) {
            return -1;
        }

        return binarySearch(sortedArray, item, 0, sortedArray.length - 1);
    }

    private int binarySearch(T[] array, T item, int firstIndex, int lastIndex) {
        int resultIndex = -1;

        if (firstIndex <= lastIndex) {
            int middleIndex = (lastIndex - firstIndex) / 2 + firstIndex;
            if (array[middleIndex].compareTo(item) == 0) {
                resultIndex = middleIndex;
            } else if (array[middleIndex].compareTo(item) > 0) {
                resultIndex = binarySearch(array, item, firstIndex, middleIndex - 1);
            } else if (array[middleIndex].compareTo(item) < 0) {
                resultIndex = binarySearch(array, item, middleIndex + 1, lastIndex);
            }
        }

        return resultIndex;
    }
}
