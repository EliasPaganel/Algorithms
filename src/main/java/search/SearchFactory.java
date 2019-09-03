package search;

public class SearchFactory {

    public static <T extends Comparable<T>> Search<T> getInstance(TypeSearch typeSearch) {
        if (typeSearch == null) {
            throw new RuntimeException("TypeSearch is null");
        }
        Search<T> instance = null;
        switch (typeSearch) {
            case BINARY_SEARCH: {
                instance = new BinarySearch<T>();
            }
            case LINEAR_SEARCH: {
                instance = new LinearSearch<T>();
            }
        }
        return instance;
    }

    public enum TypeSearch {
        BINARY_SEARCH,
        LINEAR_SEARCH;

    }
}
