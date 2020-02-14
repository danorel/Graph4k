package graph;

import java.util.*;

import graph.body.Edge4k;
import graph.body.Vertex4k;


public class Graph4k implements Comparable<Graph4k>, Cloneable {

    private Map<Vertex4k, List<Vertex4k>> vertices;

    private Graph4k() {
        this.vertices = new HashMap<>();
    }

    private Graph4k(Graph4k another) {
        this.vertices = another.vertices;
    }

    public boolean removeVertex(
            Vertex4k remove) {
        if(!vertices.containsKey(remove)){
            return false;
        }
        for(Vertex4k vertex4k : vertices.keySet()) {
            if(!(vertex4k.equals(remove))){
                vertices
                        .get(vertex4k)
                        .remove(remove);
            }
        }
        vertices.remove(remove);
        return true;
    }

    boolean containsVertex(
            Vertex4k search) {
        return vertices.containsKey(search);
    }

    public static class GraphBuilder {
        Graph4k graph4k;

        public GraphBuilder() {
            this.graph4k = new Graph4k();
        }

        /*
            Not implemented yer
         */
        public GraphBuilder add(
                Edge4k edge4k) {
            return add(
                    edge4k.getFirst(),
                    edge4k.getSecond()
            );
        }

        public GraphBuilder add(
                Vertex4k f,
                Vertex4k s) {
            if(!graph4k.vertices.containsKey(f)) {
                graph4k.vertices.put(f, new ArrayList<>());
            }
            if(!graph4k.vertices.containsKey(s)) {
                graph4k.vertices.put(s, new ArrayList<>());
            }
            graph4k
                    .vertices
                    .get(f)
                    .add(s);
            graph4k
                    .vertices
                    .get(s)
                    .add(f);
            /*
                Sort the vertices in the ascending order by values
             */
            graph4k
                    .vertices
                    .get(f)
                    .sort(Vertex4k::compareTo);
            graph4k
                    .vertices
                    .get(s)
                    .sort(Vertex4k::compareTo);
            return this;
        }

        public Graph4k construct() {
            return new Graph4k(graph4k);
        }
    }

    public int compareTo(Graph4k graph4k) {
        return this.hashCode() - graph4k.hashCode();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for(Vertex4k keyVertex : vertices.keySet()) {
            hash += keyVertex.hashCode();
            for(Vertex4k valueVertex : vertices.get(keyVertex))
                hash += valueVertex.hashCode();
        }
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if(object instanceof Graph4k) {
            Graph4k graph4k = (Graph4k) object;
            return this.compareTo(graph4k) == 0;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Set<Vertex4k> vertex4ks = this.vertices
                .keySet();
        for(Vertex4k vertex4k : vertex4ks) {
            builder
                    .append("{")
                    .append(vertex4k)
                    .append("}");
            this.vertices
                    .get(vertex4k)
                    .forEach(vertex -> {
                        builder
                                .append("->")
                                .append(vertex);
                    });
            builder.append("\n");
        }
        return builder.toString();
    }

    @Override
    public Graph4k clone(){
        Graph4k graph4k = new Graph4k();
        try {
            graph4k  = (Graph4k) super.clone();
        } catch (CloneNotSupportedException exception) {
            exception.printStackTrace();
        }
        graph4k.vertices = new HashMap<>();
        for(Vertex4k keyVertex : this.vertices.keySet()) {
            graph4k.vertices
                    .put(
                        new Vertex4k(keyVertex.getValue()),
                        new ArrayList<>()
            );
            for(Vertex4k valueVertex : this.vertices.get(keyVertex)) {
                graph4k.vertices
                        .get(keyVertex)
                        .add(valueVertex);
            }
        }
        return graph4k;
    }
}
