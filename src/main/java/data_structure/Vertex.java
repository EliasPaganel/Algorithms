package data_structure;

import lombok.*;

import java.util.Objects;


public class Vertex<T extends Comparable> {

    private String name;
    private T value;
    private int rank;

    public Vertex(String name, T value) {
        this.name = name;
        this.value = value;
        this.rank = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return name.equals(vertex.name) &&
                value.equals(vertex.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", rank=" + rank +
                '}';
    }
}
