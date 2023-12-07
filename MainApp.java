// MainApp.java

// Main class to run the Medical Record System application
public class MainApp {
    public static void main(String[] args) {
        // Create an instance of MedicalRecordSystem
        MedicalRecordSystem medicalRecordSystem = new MedicalRecordSystem();

        // Example: Creating a Patient
        Patient newPatient = new Patient("P001", "John Doe", 30, "Hypertension", 2);

        // Example: Adding the patient to the system using PatientManager
        PatientManager patientManager = new PatientManager();
        patientManager.addPatient(medicalRecordSystem, newPatient);

        // Run the user interface
        MedicalRecordSystemUI.runUserInterface(medicalRecordSystem);
    }
}
