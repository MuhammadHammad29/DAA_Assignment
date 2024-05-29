package EdgeList;
import java.util.ArrayList;
import java.util.List;

class Edge {
    int source;
    int destination;

    // Constructor for an edge
    public Edge(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "(" + source + ", " + destination + ")";
    }
}

public class Graph {
    private int numberOfVertices;
    private List<Edge> edgeList;

    // Constructor
    public Graph(int numberOfVertices) {
        if (numberOfVertices <= 0) {
            throw new IllegalArgumentException("Number of vertices must be positive.");
        }
        this.numberOfVertices = numberOfVertices;
        edgeList = new ArrayList<>();
    }

    // Method to add an edge to the graph
    public void addEdge(int source, int destination) {
        if (source < 0 || source >= numberOfVertices || destination < 0 || destination >= numberOfVertices) {
            throw new IllegalArgumentException("Invalid vertex index.");
        }
        edgeList.add(new Edge(source, destination));
    }

    // Method to print the edge list representation of the graph
    public void printGraph() {
        System.out.println("\nEdge List Representation:");
        System.out.println("Connected Edges:");
        for (Edge edge : edgeList) {
            System.out.println(edge);
        }
    }

    public static void main(String[] args) {
        int numberOfVertices = 4; // Number of vertices

        try {
            Graph graph = new Graph(numberOfVertices);

            // Adding edges to make the graph fully connected
            graph.addEdge(0, 1);
            graph.addEdge(0, 2);
            graph.addEdge(0, 3);
            graph.addEdge(1, 2);
            graph.addEdge(1, 3);
            graph.addEdge(2, 3);

            // Print the edge list representation of the graph
            graph.printGraph();
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

