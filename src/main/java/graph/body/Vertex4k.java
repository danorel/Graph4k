package graph.body;

public class Vertex4k implements Comparable<Vertex4k> {

    private Comparable value;

    public Vertex4k(Comparable value) {
        this.value = value;
    }

    public Comparable getValue() {
        return value;
    }

    public int compareTo(Vertex4k vertex4k) {
        return this.hashCode() - vertex4k.hashCode();
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if(object instanceof Vertex4k) {
            Vertex4k vertex4k = (Vertex4k) object;
            return this.compareTo(vertex4k) == 0;
        }
        return false;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
