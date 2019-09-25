package data_structure;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Graph<T extends Comparable<T>, R> {

    boolean hasVertex(Vertex<T> vertex);
    boolean hasEdge(Vertex<T> firstVertex, Vertex<T> secondVertex);
    void addVertex(Vertex<T> vertex);
    void addEdge(Vertex<T> firstVertex, Vertex<T> secondVertex);
    ResultBFS<Vertex<T>> performBFS(Vertex<T> initialVertex, Predicate<Vertex<T>> vertexPredicate);
    ResultBFS<Vertex<T>> performBFS(Vertex<T> initialVertex, Vertex<T> endVertex);
    Map<Vertex<T>, List<Vertex<T>>> getAdjacencyList();
}
