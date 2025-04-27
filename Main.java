public class Main {
    public static void main(String[] args) {
        // creat the graph
        Graph<Character> graph = new Graph<Character>(9);

        // declare all vertices
        graph.setLabel(0, 'A');
        graph.setLabel(1, 'D');
        graph.setLabel(2, 'G');
        graph.setLabel(3, 'B');
        graph.setLabel(4, 'E');
        graph.setLabel(5, 'H');
        graph.setLabel(6, 'C');
        graph.setLabel(7, 'F');
        graph.setLabel(8, 'I');

        // declare all edges
        graph.addEdge(0, 3);    // (A,B)
        graph.addEdge(0, 1);    // (A,D)
        graph.addEdge(0, 4);    // (A,E)
        graph.addEdge(3, 4);    // (B,E)
        graph.addEdge(1, 2);    // (D,G)
        graph.addEdge(4, 7);    // (E,F)
        graph.addEdge(4, 5);    // (E,H)
        graph.addEdge(2, 5);    // (G,H)
        graph.addEdge(7, 6);    // (F,C)
        graph.addEdge(7, 5);    // (F,H)
        graph.addEdge(5, 8);    // (H,I)
        graph.addEdge(6, 3);    // (C,B)
        graph.addEdge(8, 7);    // (I,F)
    
    }
}
