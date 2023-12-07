import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class MedicalRecordSystem {
    // Class attributes for storing patient information and data structures
    private Graph graph;
    private Set<String> medicalConditionsSet;
    private PriorityQueue<Appointment> appointmentQueue;
    private BTree medicalRecordsBTree;
    private List<Patient> allPatients;
    

    // Constructor to initialize the MedicalRecordSystem
    public MedicalRecordSystem() {
        this.graph = new Graph();
        this.medicalConditionsSet = new HashSet<>();
        this.appointmentQueue = new PriorityQueue<>();
        this.medicalRecordsBTree = new BTree();
    }

    // Method to add a patient to the graph
    public void addPatient(Patient patient) {
        graph.addNode(patient);
    }

    // Method to add a relationship between two patients in the graph
    public void addRelationship(Patient patient1, Patient patient2) {
        graph.addEdge(patient1, patient2);
    }

    // Method to prioritize patients based on medical history length
    public void prioritizePatients() {
        Queue<Patient> priorityQueue = new PriorityQueue<>((p1, p2) ->
                Integer.compare(p2.getMedicalHistory().length(), p1.getMedicalHistory().length()));

        for (Patient patient : graph.getAllPatients()) {
            priorityQueue.add(patient);
        }

        System.out.println("Prioritized Patients:");
        while (!priorityQueue.isEmpty()) {
            displayPatientInformation(priorityQueue.poll());
        }
    }

    // Method to optimize treatment plans for all patients
    public void optimizeTreatmentPlans() {
        for (Patient patient : graph.getAllPatients()) {
            int newAge = patient.getAge() + 1;
            patient.setMedicalHistory(patient.getMedicalHistory() + " Updated treatment plan for age " + newAge);
        }
    }

    public List<Patient> getAllPatients() {
        List<Patient> allPatients = new ArrayList<>();
        // Logic to retrieve all patients from the graph or any other data structure
        // and add them to the 'allPatients' list
        return allPatients;
    }

    // Method to get a patient by ID
    public Patient getPatientByID(String patientID) {
        for (Patient patient : allPatients) {
            if (patient.getPatientID().equals(patientID)) {
                return patient; // Found the patient with the given ID
            }
        }
        return null; // Patient not found
    }

    // Method to schedule an appointment
    public void scheduleAppointment(Appointment appointment) {
        appointmentQueue.add(appointment);
    }

    // Method to get all appointments
    public List<Appointment> getAllAppointments() {
        List<Appointment> allAppointments = new ArrayList<>();

        while (!appointmentQueue.isEmpty()) {
            allAppointments.add(appointmentQueue.poll());
        }

        return allAppointments;
    }



    // Getter methods for data structures
    public Set<String> getMedicalConditionsSet() {
        return medicalConditionsSet;
    }

    public PriorityQueue<Appointment> getAppointmentQueue() {
        return appointmentQueue;
    }

    public BTree getMedicalRecordsBTree() {
        return medicalRecordsBTree;
    }

    // Helper method to display patient information
    private void displayPatientInformation(Patient patient) {
        System.out.println("Patient ID: " + patient.getPatientID());
        System.out.println("Name: " + patient.getName());
        System.out.println("Age: " + patient.getAge());
        System.out.println("Medical History: " + patient.getMedicalHistory());
        System.out.println("Severity of Illness: " + patient.getSeverityOfIllness());
        System.out.println("----------------------");
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Create an instance of MedicalRecordSystem
        MedicalRecordSystem medicalRecordSystem = new MedicalRecordSystem();
        // Run the user interface
        MedicalRecordSystemUI.runUserInterface(medicalRecordSystem);
    }
}
