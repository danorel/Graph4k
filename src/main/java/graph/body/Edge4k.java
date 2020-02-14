package graph.body;


public class Edge4k implements Comparable<Edge4k> {

    private Vertex4k
            _f,
            _s;

    public Edge4k(
            Vertex4k f,
            Vertex4k s) {
        this._f = f;
        this._s = s;
    }

    public Vertex4k getFirst() {
        return _f;
    }

    public Vertex4k getSecond() {
        return _s;
    }

    public int compareTo(Edge4k edge4k) {
        return this.hashCode() - edge4k.hashCode();
    }

    @Override
    public int hashCode() {
        return _f.hashCode() + _s.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if(object instanceof Edge4k) {
            Edge4k edge4k = (Edge4k) object;
            return this.compareTo(edge4k) == 0;
        }
        return false;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("[")
                .append(_f)
                .append("<->")
                .append(_s)
                .append("]")
                .toString();
    }
}
