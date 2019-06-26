import search.Search;
import search.SearchFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static search.SearchFactory.TypeSearch.BINARY_SEARCH;

public class Main {
    public static void main(String[] args) {
        Search<Integer> instance = SearchFactory.getInstance(BINARY_SEARCH);

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                int input = Integer.parseInt(reader.readLine());
                int resultInt = instance.search(new Integer[]{1, 1, 2, 3, 5, 8, 13, 21, 34}, input);
                System.out.println(resultInt);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
