import java.util.*;

public class Graph {
    private List<Patient> patients;
    private Map<Patient, List<Patient>> relationships;

    public Graph() {
        this.patients = new ArrayList<>();
        this.relationships = new HashMap<>();
    }

    // Add a patient to the graph
    public void addNode(Patient patient) {
        patients.add(patient);
        relationships.put(patient, new ArrayList<>());
    }

    // Add a relationship between two patients
    public void addEdge(Patient patient1, Patient patient2) {
        relationships.get(patient1).add(patient2);
        relationships.get(patient2).add(patient1);
    }

    // Get all patients in the graph
    public List<Patient> getAllPatients() {
        return patients;
    }

    // Get neighbors of a specific patient
    public List<Patient> getNeighbors(Patient patient) {
        return relationships.get(patient);
    }

    // Get a patient by ID
    public Patient getPatientByID(String patientID) {
        for (Patient patient : patients) {
            if (patient.getPatientID().equals(patientID)) {
                return patient;
            }
        }
        return null;
    }
}
