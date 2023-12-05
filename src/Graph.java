package src;

// Graph.java

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
    private Map<Patient, Set<Patient>> adjacencyList;

    // Constructor
    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    // Method to add a patient node to the graph
    public void addNode(Patient patient) {
        adjacencyList.putIfAbsent(patient, new HashSet<>());
    }

    // Method to add a relationship (edge) between two patients
    public void addEdge(Patient patient1, Patient patient2) {
        adjacencyList.get(patient1).add(patient2);
        adjacencyList.get(patient2).add(patient1);
    }

    // Other graph-related methods will be added in future commits
}