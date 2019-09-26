package data_structure;

import lombok.AllArgsConstructor;

import java.util.LinkedList;
import java.util.List;


@AllArgsConstructor
public class BFSResult<V> {
    private int numberOfSteps;
    private List<V> vertexList;

    public BFSResult() {
        this.numberOfSteps = 0;
        this.vertexList = new LinkedList<>();
    }

    public BFSResult(int numberOfSteps, List<V> vertexList) {
        this.numberOfSteps = numberOfSteps;
        this.vertexList = vertexList;
    }

    public int getNumberOfSteps() {
        return numberOfSteps;
    }

    public void setNumberOfSteps(int numberOfSteps) {
        this.numberOfSteps = numberOfSteps;
    }

    public void incrementNumberOfSteps() {
        this.numberOfSteps++;
    }

    public List<V> getVertexList() {
        return vertexList;
    }

    public void setVertexList(List<V> vertexList) {
        this.vertexList = vertexList;
    }

    public void addVertexToList(V v) {
        if (v != null) {
            this.vertexList.add(v);
        }
    }
}
