import search.Search;
import search.SearchFactory;
import sorting.BubbleSort;
import sorting.SelectionSort;
import sorting.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
        Integer[] integersMesh = {2323, 3, -1, 0, 34, 1, 8, 13, 5,  2, 21};
        Integer[] integersASC = {-1, 0, 1, 2, 3, 5, 8, 13, 21, 34};
        Integer[] integersDESC = {34, 21, 13, 8, 5, 3, 2, 1, 0, -1};

        Sort<Integer> sort = new SelectionSort<>();

        Integer[] sortingArray = sort.sorting(integersMesh, Sort.SortType.DESC);

        for (Integer integer : sortingArray) {
            System.out.print(integer + " ");
        }
//        System.out.println(Integer.toBinaryString(-2));
    }
}
