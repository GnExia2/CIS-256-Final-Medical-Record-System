// PatientManager.java
public class PatientManager {
    private Graph graph;

    public PatientManager(Graph graph) {
        this.graph = graph;
    }

    // Updated method to add a new patient to the system
    public void addPatient(Patient newPatient) {
        // Add the patient to the graph
        graph.addNode(newPatient);

        System.out.println("Patient added successfully!");
    }
}
