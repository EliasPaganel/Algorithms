package sorting;

import java.util.function.Predicate;

public class MergeSort<T extends Comparable<T>> implements Sort<T> {
    public void sorting(T[] mixedArray, SortType type) {
        mixedArray = execute(mixedArray, 0, mixedArray.length - 1, SortType.getPredicate(type));
    }

    private T[] execute(T[] mixedArray, int firstIndex, int lastIndex, Predicate<Integer> order) {
        if(firstIndex >= lastIndex) {
            return mixedArray[];
        }

        int middleIndex = (lastIndex - firstIndex) / 2 + firstIndex;

        T[] leftSubArr = execute(mixedArray, firstIndex, middleIndex, order);
        T[] rightSubArr = execute(mixedArray, middleIndex + 1, lastIndex, order);

        return merge(leftSubArr, rightSubArr, order);
    }

    private T[] merge(T[] leftSubArr, T[] rightSubArr, Predicate<Integer> order) {

    }
}
