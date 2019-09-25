package data_structure;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class UndirectedGraph<T extends Comparable<T>, R> implements Graph<T, R> {

    private Map<Vertex<T>, List<Vertex<T>>> adjacencyList;

    private Set<Vertex<T>> checkedVertices;

    private Queue<Vertex<T>> vertexQueue;

    public UndirectedGraph() {
        this.adjacencyList = new HashMap<>();
        this.checkedVertices = new HashSet<>();
        this.vertexQueue =  new ArrayDeque<>();
    }

    public UndirectedGraph(Map<Vertex<T>, List<Vertex<T>>> adjacencyList, Set<Vertex<T>> checkedVertices, Queue<Vertex<T>> vertexQueue) {
        this.adjacencyList = adjacencyList;
        this.checkedVertices = checkedVertices;
        this.vertexQueue = vertexQueue;
    }

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
    public ResultBFS<Vertex<T>> performBFS(Vertex<T> initialVertex, Vertex<T> endVertex) {
        return this.performBFS(initialVertex, vertex -> vertex.equals(endVertex));
    }

    @Override
    public ResultBFS<Vertex<T>> performBFS(Vertex<T> initialVertex, Predicate<Vertex<T>> vertexPredicate) {
        if (initialVertex == null && vertexPredicate == null) {
            return null;
        }

        if(!adjacencyList.containsKey(initialVertex)) {
            throw new RuntimeException("Initial vertex is missing in the graph");
        }

        vertexQueue.clear();
        checkedVertices.clear();

        ResultBFS<Vertex<T>> result = new ResultBFS<>(0, Arrays.asList(initialVertex));
        if(vertexPredicate.test(initialVertex)) {
            return result;
        }

        fillQueue(adjacencyList.get(initialVertex));

        while (!vertexQueue.isEmpty()) {
            Vertex<T> queueHead = vertexQueue.poll();
            if (vertexPredicate.test(queueHead)) {
                result.incrementNumberOfSteps();
                result.addVertexToPath(queueHead);
                return result;
            } else {
                fillQueue(adjacencyList.get(queueHead));
            }
        }

        return null;
    }

    @Override
    public Map<Vertex<T>, List<Vertex<T>>> getAdjacencyList() {
        return adjacencyList;
    }

    /**
     * Заполняем очередь обработки ранее не обрабатывавшимися узлами
     * @param vertexList список узлов, ктр после проверки будут добавлены в очередь
     */
    private void fillQueue(List<Vertex<T>> vertexList) {
        for (Vertex<T> vertex : vertexList) {
            if (!checkedVertices.contains(vertex)) {
                checkedVertices.add(vertex);
                vertexQueue.offer(vertex);
            }
        }

    }
}
