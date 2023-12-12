import java.util.ArrayList;
import java.util.List;
// Class to represent a vertex in a graph
public class Vertex {
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
