package data_structure;

import lombok.*;

import java.util.Objects;


@AllArgsConstructor
@NoArgsConstructor
public class Vertex<T extends Comparable> {

    private String name;
    private T value;

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

}
