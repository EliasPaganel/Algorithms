package sorting;

import java.lang.reflect.Array;
import java.util.function.Predicate;

public class MergeSort<T extends Comparable<T>> implements Sort<T> {
    public void sorting(T[] mixedArray, SortType type) {
        execute(mixedArray, SortType.getPredicate(type));
    }

    @SuppressWarnings("unchecked")
    private void execute(T[] mixedArray, Predicate<Integer> order) {
        int length = mixedArray.length;
        if (length < 2) {
            return;
        }

        int middle = length / 2;

        T[] leftHalf = (T[]) Array.newInstance(mixedArray[length - 1].getClass(), middle);
        T[] rightHalf = (T[]) Array.newInstance(mixedArray[length - 1].getClass(), length - middle);

        for (int i = 0; i < middle; i++) {
            leftHalf[i] = mixedArray[i];
        }

        for (int i = middle; i < length; i++) {
            rightHalf[i - middle] = mixedArray[i];
        }

        execute(leftHalf, order);
        execute(rightHalf, order);
        merge(mixedArray, leftHalf, rightHalf, order);
    }

    private void merge(T[] entire, T[] leftHalf, T[] rightHalf, Predicate<Integer> order) {
        int i = 0, j = 0, k = 0;

        while (i < leftHalf.length && j < rightHalf.length) {
            if (order.test(leftHalf[i].compareTo(rightHalf[j]))) {
                entire[k++] = rightHalf[j++];
            } else {
                entire[k++] = leftHalf[i++];
            }
        }

        while (i < leftHalf.length) {
            entire[k++] = leftHalf[i++];
        }

        while (j < rightHalf.length) {
            entire[k++] = rightHalf[j++];
        }
    }
}

