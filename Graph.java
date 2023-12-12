import java.util.ArrayList;
import java.util.List;
// Class to represent an undirected graph
public class Graph {
    List<Vertex> vertices;   // List of vertices in the graph

    // Constructor to initialize a new Graph object
    public Graph() {
        this.vertices = new ArrayList<>();
    }

    // Method to add a new vertex to the graph
    public void addVertex(String label) {
        vertices.add(new Vertex(label));
    }

    // Method to add an undirected edge between two vertices in the graph
    public void addEdge(String label1, String label2) {
        Vertex v1 = findVertex(label1);
        Vertex v2 = findVertex(label2);

        // If both vertices exist, add each other as neighbors
        if (v1 != null && v2 != null) {
            v1.addNeighbor(v2);
            v2.addNeighbor(v1);
        }
    }

    // Method to print the adjacency list representation of the graph
    public void printGraph() {
        for (Vertex vertex : vertices) {
            System.out.print(vertex.label + ": ");
            for (Vertex neighbor : vertex.getNeighbors()) {
                System.out.print(neighbor.label + " ");
            }
            System.out.println();
        }
    }

    // Helper method to find a vertex in the graph based on its label
    private Vertex findVertex(String label) {
        for (Vertex vertex : vertices) {
            if (vertex.label.equals(label)) {
                return vertex;
            }
        }
        return null;
    }

    // Inner class representing a vertex in the graph
    static class Vertex {
        String label;              // Unique identifier for the vertex
        List<Vertex> neighbors;    // List of neighboring vertices

        // Constructor to initialize a new Vertex object with a given label
        public Vertex(String label) {
            this.label = label;
            this.neighbors = new ArrayList<>();  // Initialize the list of neighbors
        }

        // Method to add a neighboring vertex to the current vertex
        public void addNeighbor(Vertex neighbor) {
            neighbors.add(neighbor);
        }

        // Method to retrieve the list of neighboring vertices
        public List<Vertex> getNeighbors() {
            return neighbors;
        }
    }
}
