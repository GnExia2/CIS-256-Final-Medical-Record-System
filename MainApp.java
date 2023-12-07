public class MainApp {
    public static void main(String[] args) {
        // Create an instance of MedicalRecordSystem
        MedicalRecordSystem medicalRecordSystem = new MedicalRecordSystem();

        // Example: Creating and adding a patient
        Patient newPatient1 = new Patient("P001", "John Doe", 30, "Hypertension", 2);
        medicalRecordSystem.addPatient(newPatient1);

        Patient newPatient2 = new Patient("P002", "Jane Smith", 25, "Asthma", 3);
        medicalRecordSystem.addPatient(newPatient2);

        Patient newPatient3 = new Patient("P003", "Bob Johnson", 40, "Diabetes", 1);
        medicalRecordSystem.addPatient(newPatient3);

        Patient newPatient4 = new Patient("P004", "Alice Brown", 22, "Migraine", 2);
        medicalRecordSystem.addPatient(newPatient4);

        Patient newPatient5 = new Patient("P005", "Tom Wilson", 35, "Arthritis", 4);
        medicalRecordSystem.addPatient(newPatient5);

        Patient newPatient6 = new Patient("P006", "Sara Davis", 28, "Allergies", 1);
        medicalRecordSystem.addPatient(newPatient6);

        Patient newPatient7 = new Patient("P007", "Mike Miller", 45, "Heart Disease", 3);
        medicalRecordSystem.addPatient(newPatient7);

        Patient newPatient8 = new Patient("P008", "Emily White", 33, "Depression", 2);
        medicalRecordSystem.addPatient(newPatient8);

        Patient newPatient9 = new Patient("P009", "Chris Robinson", 50, "Cancer", 5);
        medicalRecordSystem.addPatient(newPatient9);

        // Run the user interface
        MedicalRecordSystemUI.runUserInterface(medicalRecordSystem);
    }
}
