import search.Search;
import search.SearchFactory;
import sorting.BubbleSort;
import sorting.QuickSort;
import sorting.SelectionSort;
import sorting.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static search.SearchFactory.TypeSearch.BINARY_SEARCH;
import static search.SearchFactory.TypeSearch.LINEAR_SEARCH;

public class Main {
    public static void main(String[] args) {

//        Search<Integer> instance = SearchFactory.getInstance(BINARY_SEARCH);
//        try {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//            while (true) {
//                int input = Integer.parseInt(reader.readLine());
//                int resultInt = instance.search(new Integer[]{1, 1, 2, 3, 5, 8, 13, 21, 34}, input);
//                System.out.println(resultInt);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Double[] integersMesh = {2323.0, 3.0, -1.0, 0.0, 34.0, 1.0, 8.0, 13.0, 5.0,  2.0, 21.0};
        Integer[] integersASC = {-1, 0, 1, 2, 3, 5, 8, 13, 21, 34};
        Integer[] integersDESC = {34, 21, 13, 8, 5, 3, 2, 1, 0, -1};
//
        Sort<Integer> sort = new QuickSort<>();
//
        sort.sorting(integersDESC, Sort.SortType.ASC);


        for (Integer integer : integersDESC) {
            System.out.print(integer + " ");
        }
//        System.out.println(Integer.toBinaryString(-2));

//        Double[] doubles = new Double[6000];
//        Arrays.fill(doubles, 323.0);
//        RandomNumberGenerator<Double> doubleRandomNumberGenerator = new RandomNumberGenerator<>();
//        Double operation = doubleRandomNumberGenerator.operation(doubles, (aDouble, aDouble2) -> aDouble + aDouble2, () -> 0.0);
//        System.out.println(operation);

//        Double aDouble1 = doubleRandomNumberGenerator.operationCycle(doubles, (aDouble, aDouble2) -> aDouble + aDouble2, () -> 0.0);
//        System.out.println(aDouble1);

//        Integer times = 1000;
//        doubleRandomNumberGenerator.testFunction(
//                (array, binaryOperator, defaultValue) -> {new RandomNumberGenerator<Double>().operation(array, binaryOperator, defaultValue); return true;},
//                times,
//                "recursiveOperation",
//                doubles,
//                Double::sum,
//                () -> 0.0);
//
//
//        doubleRandomNumberGenerator.testFunction(
//                (array, binaryOperator, defaultValue) -> {
//                    new RandomNumberGenerator<Double>().operationCycle(array, binaryOperator, defaultValue);
//                    return true;
//                },
//                times,
//                "recursiveCycle",
//                doubles,
//                (a, b) -> a + b,
//                () -> 0.0);
//
//        doubleRandomNumberGenerator.testFunction(
//                (array, binaryOperator, defaultValue) -> {
//                    Arrays.stream(array).reduce(defaultValue.get(), binaryOperator);
//                    return true;
//                },
//                times,
//                "Stream - reduce",
//                doubles,
//                Double::sum,
//                () -> 0.0);

    }
}
