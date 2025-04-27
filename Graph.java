public class Graph<E> { 
    private boolean[][] edges; // edges[i][j] is true if there is a vertex from i to j
    private E[] labels; // labels[i] contains the label for vertex i

    public Graph(int n) {
        edges = new boolean[n][n]; // All values initially false
        labels = (E[]) new Object[n]; //All values initially null
    }

    public E getLabel(int vertex) {
        return labels[vertex];
    }

    public boolean isEdge(int source, int target) {
        return edges[source][target];
    }

    public void addEdge(int source, int target) {
        edges[source][target] = true;
    }

    public int[] neighbors(int vertex) {
        int i = 0;
        int count = 0;
        int[] answer;

        for (i = 0; i < labels.length; i++) {
            if (edges[vertex][i]) {
                count++;
            }
        }
        answer = new int[count];
        count = 0;
        for (i = 0; i < labels.length; i++) {
            if (edges[vertex][i]) {
                answer[count++] = i;
            }
        }
        return answer;
    }

    public void removeEdge(int source, int target) {
        edges[source][target] = false;
    }

    public void setLabel(int vertex, E newLabel) {
        labels[vertex] = newLabel;
    }

    public int size() {
        return labels.length;
    }
}
