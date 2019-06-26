package search;

public interface Search<T extends Comparable<T>> {

    /**
     * Ищет в отсортированном массиве искомое значение.
     * @param sortedArray Отсортированный массив
     * @param item Искомое значение
     * @return Индекс искомого значения, если найдено, иначе возвращается число "-1"
     */
    int search(T[] sortedArray, T item);
}
