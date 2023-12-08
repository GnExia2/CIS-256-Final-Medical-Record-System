import java.util.ArrayList;
import java.util.List;

public class Graph {
    List<Vertex> vertices;

    public Graph() {
        this.vertices = new ArrayList<>();
    }

    public void addVertex(String label) {
        vertices.add(new Vertex(label));
    }

    public void addEdge(String label1, String label2) {
        Vertex v1 = findVertex(label1);
        Vertex v2 = findVertex(label2);

        if (v1 != null && v2 != null) {
            v1.addNeighbor(v2);
        }
    }

    public void printGraph() {
        for (Vertex vertex : vertices) {
            System.out.print(vertex.label + ": ");
            for (Vertex neighbor : vertex.getNeighbors()) {
                System.out.print(neighbor.label + " ");
            }
            System.out.println();
        }
    }

    private Vertex findVertex(String label) {
        for (Vertex vertex : vertices) {
            if (vertex.label.equals(label)) {
                return vertex;
            }
        }
        return null;
    }

    static class Vertex {
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
}
