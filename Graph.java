import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
    
    public Queue<E> getBreadthFirstTraversal(int originVertex) {
        boolean[] visited = new boolean[size()];
        Queue<E> traversalOrder = new LinkedList<>();
        Queue<Integer> vertexQueue = new LinkedList<>();

        visited[originVertex] = true;
        traversalOrder.add(labels[originVertex]);
        vertexQueue.add(originVertex);

        while (!vertexQueue.isEmpty()) {
            int currentVertex = vertexQueue.poll();
            int[] neighbors = neighbors(currentVertex);

            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    traversalOrder.add(labels[neighbor]);
                    vertexQueue.add(neighbor);
                }
            }
        }

        return traversalOrder;
    }

    public Queue<E> getDepthFirstTraversal(int originVertex){
        boolean[] visited = new boolean[size()];
        Queue<E> traversalOrder = new LinkedList<>();
        Stack<Integer> vertexStack = new Stack<>();

        visited[originVertex] = true;
        traversalOrder.add(labels[originVertex]);
        vertexStack.push(originVertex);

        while(!vertexStack.isEmpty()){
            Integer topVertex = vertexStack.peek();
            int[] neighbors = neighbors(topVertex);

            boolean foundUnvisitedNeighbor = false;
            int index = 0;
            while(!foundUnvisitedNeighbor && index < neighbors.length){
                int neighbor = neighbors[index];
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    traversalOrder.add(labels[neighbor]);
                    vertexStack.push(neighbor);
                    foundUnvisitedNeighbor = true;
                }
                else{
                    index++;
                }
            }

            if(!foundUnvisitedNeighbor){
                vertexStack.pop();
            }
        }

        return traversalOrder;
    }
}
