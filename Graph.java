// Graph.java
import java.util.ArrayList;
import java.util.List;

// Represents a graph using an adjacency list
public class Graph {
    // List of vertices in the graph
    List<Vertex> vertices;

    // Constructor to initialize the graph
    public Graph() {
        this.vertices = new ArrayList<>();
    }

    // Adds a new vertex to the graph
    public void addVertex(String label) {
        vertices.add(new Vertex(label));
    }

    // Adds an edge between two vertices in the graph
    public void addEdge(String label1, String label2) {
        // Find the vertices with the given labels
        Vertex v1 = findVertex(label1);
        Vertex v2 = findVertex(label2);

        // If both vertices exist, add an edge between them
        if (v1 != null && v2 != null) {
            v1.addNeighbor(v2);
        }
    }

    // Finds a vertex with the given label in the graph
    private Vertex findVertex(String label) {
        for (Vertex vertex : vertices) {
            if (vertex.label.equals(label)) {
                return vertex;
            }
        }
        return null; // Return null if the vertex is not found
    }

    // Prints the graph, showing the neighbors of each vertex
    public void printGraph() {
        for (Vertex vertex : vertices) {
            System.out.print(vertex.label + ": ");
            for (Vertex neighbor : vertex.getNeighbors()) {
                System.out.print(neighbor.label + " ");
            }
            System.out.println();
        }
    }
}
