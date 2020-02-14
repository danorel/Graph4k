import graph.Graph4k;
import graph.body.Vertex4k;

public class App {
    public static void main(String[] args) {
        Vertex4k _1 = new Vertex4k(1);
        Vertex4k _2 = new Vertex4k(2);
        Vertex4k _3 = new Vertex4k(3);
        Vertex4k _4 = new Vertex4k(4);
        Vertex4k _5 = new Vertex4k(5);
        Graph4k graph4k1 = new Graph4k
                .GraphBuilder()
                .add(_1, _2)
                .add(_1, _3)
                .add(_1, _5)
                .add(_2, _3)
                .add(_2, _4)
                .add(_4, _1)
                .construct();
        System.out.println(graph4k1);

        Graph4k graph4k2 = graph4k1.clone();
        System.out.println(graph4k2);
    }
}
