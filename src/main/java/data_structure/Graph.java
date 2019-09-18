package data_structure;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public interface Graph<T extends Comparable<T>, R> {

    boolean hasVertex(Vertex<T> vertex);
    boolean hasEdge(Vertex<T> firstVertex, Vertex<T> secondVertex);
    void addVertex(Vertex<T> vertex);
    void addEdge(Vertex<T> firstVertex, Vertex<T> secondVertex);
    R performBFS(Function<T, R> function);
    Map<Vertex<T>, List<Vertex<T>>> getAdjacencyList();
}
