package data_structure;

import java.util.*;
import java.util.function.Function;

public class UndirectedGraph<T extends Comparable<T>, R> implements Graph<T, R> {

    private Map<Vertex<T>, List<Vertex<T>>> adjacencyList = new HashMap<>();

    @Override
    public boolean hasVertex(Vertex<T> vertex) {
        return adjacencyList.containsKey(vertex);
    }

    @Override
    public boolean hasEdge(Vertex<T> firstVertex, Vertex<T> secondVertex) {
        if (adjacencyList.containsKey(firstVertex) && adjacencyList.containsKey(secondVertex)) {
            List<Vertex<T>> edges = adjacencyList.get(firstVertex);

            return Collections.binarySearch(edges, secondVertex, Comparator.comparing(Vertex::getValue)) >= 0;
        }
        return false;
    }

    @Override
    public void addVertex(Vertex<T> vertex) {
        adjacencyList.computeIfAbsent(vertex, vertex1 -> new ArrayList<>());
    }

    @Override
    public void addEdge(Vertex<T> firstVertex, Vertex<T> secondVertex) {
        addVertex(firstVertex);
        addVertex(secondVertex);

        List<Vertex<T>> firstElemEdge = adjacencyList.get(firstVertex);
        List<Vertex<T>> secondElemEdge = adjacencyList.get(secondVertex);

        if(!firstElemEdge.contains(secondVertex)) {
            firstElemEdge.add(secondVertex);
        }
        if(!secondElemEdge.contains(firstVertex)) {
            secondElemEdge.add(firstVertex);
        }

        firstElemEdge.sort(Comparator.comparing(Vertex::getValue));
        secondElemEdge.sort(Comparator.comparing(Vertex::getValue));
    }

    @Override
    public R performBFS(Function<T, R> function) {
        return null;
    }

    @Override
    public Map<Vertex<T>, List<Vertex<T>>> getAdjacencyList() {
        return adjacencyList;
    }
}
