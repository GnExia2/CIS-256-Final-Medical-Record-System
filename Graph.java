import java.util.*;

// Class representing a graph in the medical record system
public class Graph {
    // Map to store patients and their relationships
    private Map<Patient, List<Patient>> adjacencyList;

    // Constructor to initialize a new graph
    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    // Method to add a patient node to the graph
    public void addNode(Patient patient) {
        if (!adjacencyList.containsKey(patient)) {
            adjacencyList.put(patient, new ArrayList<>());
        }
    }

    // Method to add an edge (relationship) between two patients
    public void addEdge(Patient patient1, Patient patient2) {
        adjacencyList.get(patient1).add(patient2);
        adjacencyList.get(patient2).add(patient1);
    }

    // Method to get all patients in the graph
    public List<Patient> getAllPatients() {
        return new ArrayList<>(adjacencyList.keySet());
    }

    // Method to check if the graph has a cycle
    public boolean hasCycle() {
        Set<Patient> visited = new HashSet<>();
        for (Patient patient : getAllPatients()) {
            if (!visited.contains(patient) && hasCycleDFS(patient, null, visited)) {
                return true;
            }
        }
        return false;
    }

    // Helper method for DFS to detect cycles
    private boolean hasCycleDFS(Patient current, Patient parent, Set<Patient> visited) {
        visited.add(current);

        for (Patient neighbor : adjacencyList.get(current)) {
            if (!visited.contains(neighbor)) {
                if (hasCycleDFS(neighbor, current, visited)) {
                    return true;
                }
            } else if (!neighbor.equals(parent)) {
                return true;
            }
        }

        return false;
    }
}
