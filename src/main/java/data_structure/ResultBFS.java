package data_structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ResultBFS<T> {
    private int numberOfSteps;
    private List<T> path;

    public ResultBFS() {
        this.numberOfSteps = 0;
        this.path = new ArrayList<>();
    }

    public ResultBFS(int numberOfSteps, List<T> path) {
        this.numberOfSteps = numberOfSteps;
        this.path = path;
    }

    public int getNumberOfSteps() {
        return numberOfSteps;
    }

    public void incrementNumberOfSteps() {
        this.numberOfSteps++;
    }

    public void setNumberOfSteps(int numberOfSteps) {
        this.numberOfSteps = numberOfSteps;
    }

    public List<T> getPath() {
        return path;
    }

    public void setPath(List<T> path) {
        this.path = path;
    }

    public boolean addVertexToPath(T t) {
        if (!this.path.contains(t)) {
            return this.path.add(t);
        }
        return false;
    }
}
