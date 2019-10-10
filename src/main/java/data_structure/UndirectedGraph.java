package data_structure;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UndirectedGraph<T extends Comparable<T>> implements Graph<T> {

    private Map<Vertex<T>, List<Vertex<T>>> adjacencyList;

    private Set<Vertex<T>> checkedVertices;

    private Queue<Vertex<T>> vertexQueue;

    public UndirectedGraph() {
        this.adjacencyList = new HashMap<>();
        this.checkedVertices = new HashSet<>();
        this.vertexQueue = new ArrayDeque<>();
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
        if (hasVertex(firstVertex) && hasVertex(secondVertex)) {
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

        if (!firstElemEdge.contains(secondVertex)) {
            firstElemEdge.add(secondVertex);
        }
        if (!secondElemEdge.contains(firstVertex)) {
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
        if (initialVertex == null || vertexPredicate == null) {
            throw new RuntimeException("initialVertex or condition is null");
        }

        if (!adjacencyList.containsKey(initialVertex)) {
            throw new PathNotFoundException("Initial vertex is missing in the graph");
        }

        vertexQueue.clear();
        checkedVertices.clear();

        checkedVertices.add(initialVertex);
        vertexQueue.offer(initialVertex);

        while (!vertexQueue.isEmpty()) {
            Vertex<T> queueHead = vertexQueue.poll();
//            result.addVertexToPath(queueHead);
            if (vertexPredicate.test(queueHead)) {
                return buildRoute(queueHead);
            } else {
                fillQueue(queueHead);
            }
        }
        throw new PathNotFoundException();
    }

    /**
     * Построение маршрута от начального узла до искомого, путем прохода от искомого к начальному
     *
     * @param foundVertex искомый узел
     * @return объект, ктр содержил в себе построенный маршрут и кол-во шагов от А до В
     */
    private ResultBFS<Vertex<T>> buildRoute(Vertex<T> foundVertex) {
        ResultBFS<Vertex<T>> result = new ResultBFS<>();

        Vertex<T> currentVertex = foundVertex;
        result.addVertexToPath(currentVertex);

        while (currentVertex.getRank() > 0) {
            int prevRank = currentVertex.getRank() - 1;
            List<Vertex<T>> previousRankVertices = checkedVertices.stream()
                    .filter(vertex -> vertex.getRank() == prevRank)
                    .collect(Collectors.toList());

            if (!previousRankVertices.isEmpty()) {
                for (Vertex<T> previousRankVertex : previousRankVertices) {
                    if (adjacencyList.get(previousRankVertex).contains(currentVertex)) {
                        result.addVertexToPath(previousRankVertex);
                        currentVertex = previousRankVertex;
                        break;
                    }
                }
            }
        }

        Collections.reverse(result.getPath());
        return result;
    }

    @Override
    public Map<Vertex<T>, List<Vertex<T>>> getAdjacencyList() {
        return adjacencyList;
    }

    /**
     * Заполняем очередь обработки ранее не обрабатывавшимися узлами
     * @param parentVertex родительский узел, у которого берем список дочерних узлов, которые после проверки будут добавлены в очередь
     */
    private void fillQueue(Vertex<T> parentVertex) {
        List<Vertex<T>> childVertices = adjacencyList.get(parentVertex);
        for (Vertex<T> vertex : childVertices) {
            if (!checkedVertices.contains(vertex)) {
                vertex.setRank(parentVertex.getRank() + 1);
                checkedVertices.add(vertex);
                vertexQueue.offer(vertex);
            }
        }

    }
}
