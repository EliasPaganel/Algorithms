package sorting;

import java.util.Objects;
import java.util.function.Predicate;

public interface Sort<T extends Comparable<T>> {

    /**
     *
     * @param mixedArray Массив, ктр должен быть отсортирован
     * @param type Переменная в ктр передается как сортировать массив, по убыванию - DESC, по возрастанию - ASC
     */
    void sorting(T[] mixedArray, SortType type);

    enum SortType {
        ASC,
        DESC;

        static Predicate<Integer> getPredicate(SortType type) {
            Predicate<Integer> predicate;
            if (Objects.equals(SortType.DESC, type)) {
                predicate = number -> number < 0;
            } else {
                predicate = number -> number > 0;
            }
            return predicate;
        }
    }

}
