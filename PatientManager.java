// PatientManager.java

// Class representing a manager for handling patient-related operations
public class PatientManager {
    // Graph to store patient relationships
    private Graph graph;

    // Constructor to initialize a new PatientManager with a graph
    public PatientManager(Graph graph) {
        this.graph = graph;
    }

    // Method to add a new patient to the system
    public void addPatient(MedicalRecordSystem medicalRecordSystem, Patient newPatient) {
        // Add the patient to the graph
        graph.addNode(newPatient);

        // Inform the user that the patient has been added successfully
        System.out.println("Patient added successfully!");
    }
}
