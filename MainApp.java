// MainApp.java

public class MainApp {
    public static void main(String[] args) {
        // Create an instance of MedicalRecordSystem
        MedicalRecordSystem medicalRecordSystem = new MedicalRecordSystem();

        // Create a Graph instance
        Graph graph = new Graph();

        // Example: Creating a Patient
        Patient newPatient = new Patient("P001", "John Doe", 30, "Hypertension", 2);

        // Example: Adding the patient to the system using PatientManager
        PatientManager patientManager = new PatientManager(graph);
        patientManager.addPatient(medicalRecordSystem, newPatient);

        // Run the user interface
        MedicalRecordSystemUI.runUserInterface(medicalRecordSystem);
    }
}
