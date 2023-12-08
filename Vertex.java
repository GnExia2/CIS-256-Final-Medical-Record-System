import java.util.ArrayList;
import java.util.List;

public class Vertex {
    String label;
    List<Vertex> neighbors;

    public Vertex(String label) {
        this.label = label;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(Vertex neighbor) {
        neighbors.add(neighbor);
    }

    public List<Vertex> getNeighbors() {
        return neighbors;
    }
}