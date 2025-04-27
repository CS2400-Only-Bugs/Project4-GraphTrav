import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        // creat the graph
        Graph<Character> graph = new Graph<Character>(9);

        // declare all vertices
        graph.setLabel(0, 'A');
        graph.setLabel(1, 'B');
        graph.setLabel(2, 'C');
        graph.setLabel(3, 'D');
        graph.setLabel(4, 'E');
        graph.setLabel(5, 'F');
        graph.setLabel(6, 'G');
        graph.setLabel(7, 'H');
        graph.setLabel(8, 'I');

        // declare all edges
        graph.addEdge(0, 1);    // (A,B)
        graph.addEdge(0, 3);    // (A,D)
        graph.addEdge(0, 4);    // (A,E)
        graph.addEdge(1, 4);    // (B,E)
        graph.addEdge(3, 6);    // (D,G)
        graph.addEdge(4, 5);    // (E,F)
        graph.addEdge(4, 7);    // (E,H)
        graph.addEdge(6, 7);    // (G,H)
        graph.addEdge(5, 2);    // (F,C)
        graph.addEdge(5, 7);    // (F,H)
        graph.addEdge(7, 8);    // (H,I)
        graph.addEdge(2, 1);    // (C,B)
        graph.addEdge(8, 5);    // (I,F)
    

        Queue<Character> traversalOrder = new LinkedList<>();
        traversalOrder = graph.getBreadthFirstTraversal(4);

        while (!traversalOrder.isEmpty()) {
            System.out.println(traversalOrder.poll());
        }
    }
}
