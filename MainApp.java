// MainApp.java

public class MainApp {
    public static void main(String[] args) {
        // Create an instance of MedicalRecordSystem
        MedicalRecordSystem medicalRecordSystem = new MedicalRecordSystem();

        // Example: Creating 10 Patients
        Patient patient1 = new Patient("P001", "John Doe", 30, "Hypertension", 2);
        Patient patient2 = new Patient("P002", "Jane Smith", 25, "Diabetes", 3);
        Patient patient3 = new Patient("P003", "Bob Johnson", 45, "Heart Disease", 1);
        Patient patient4 = new Patient("P004", "Alice Brown", 35, "Asthma", 2);
        Patient patient5 = new Patient("P005", "Charlie Wilson", 28, "Migraine", 1);
        Patient patient6 = new Patient("P006", "Eva Davis", 50, "Arthritis", 3);
        Patient patient7 = new Patient("P007", "Frank Miller", 40, "Depression", 2);
        Patient patient8 = new Patient("P008", "Grace Taylor", 32, "Allergies", 1);
        Patient patient9 = new Patient("P009", "David Lee", 60, "Cancer", 4);
        Patient patient10 = new Patient("P010", "Sophie Wilson", 22, "Anxiety", 1);

        // Adding patients to the system using PatientManager
        PatientManager patientManager = new PatientManager(medicalRecordSystem.getGraph());
        patientManager.addPatient(patient1);
        patientManager.addPatient(patient2);
        patientManager.addPatient(patient3);
        patientManager.addPatient(patient4);
        patientManager.addPatient(patient5);
        patientManager.addPatient(patient6);
        patientManager.addPatient(patient7);
        patientManager.addPatient(patient8);
        patientManager.addPatient(patient9);
        patientManager.addPatient(patient10);

        // Run the user interface
        MedicalRecordSystemUI.runUserInterface(medicalRecordSystem);
    }
}
