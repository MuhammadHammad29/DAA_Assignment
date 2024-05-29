package AdjacenyList;
import java.util.LinkedList;

//this implementation is for undirected graph
public class Graph {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    // Initializes the graph with the specified number of vertices
    public Graph(int vertices) {
        if (vertices <= 0) {
            throw new IllegalArgumentException("Number of vertices must be positive");
        }
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Adds an undirected edge between source and destination
    public void addEdge(int source, int destination) {
        validateVertex(source);
        validateVertex(destination);
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source); // Because the graph is undirected
    }

    // Checks if a vertex index is valid
    private void validateVertex(int v) {
        if (v < 0 || v >= vertices) {
            throw new IllegalArgumentException("Vertex " + v + " is not valid");
        }
    }

    // Prints the adjacency list representation of the graph
    public void printGraph() {
        System.out.println();
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ":");
            for (Integer node : adjacencyList[i]) {
                System.out.print(" -> " + node);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices

        Graph graph = new Graph(V);

        // Adding edges to the undirected graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        // method called for printing graph
        graph.printGraph();
    }
}
