import java.util.Scanner;

// Class representing the user interface for the Medical Record System
public class MedicalRecordSystemUI {
    // Static method to run the user interface
    public static void runUserInterface(MedicalRecordSystem medicalRecordSystem) {
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;

            // User interface loop
            do {
                // Display menu options
                System.out.println("\nMedical Record System Menu:");
                System.out.println("1. Add Patient");
                System.out.println("2. Add Relationship");
                System.out.println("3. Prioritize Patients");
                System.out.println("4. Optimize Treatment Plans");
                System.out.println("5. Integrate Data Structures");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                // Process user choice
                switch (choice) {
                    case 1:
                        // Implement patient addition functionality
                        addPatient(medicalRecordSystem, scanner);
                        break;
                    case 2:
                        // Implement relationship addition functionality
                        // (This section is not implemented in the provided code)
                        System.out.println("Feature not implemented yet.");
                        break;
                    case 3:
                        // Prioritize patients based on medical history length
                        medicalRecordSystem.prioritizePatients();
                        break;
                    case 4:
                        // Optimize treatment plans for all patients
                        medicalRecordSystem.optimizeTreatmentPlans();
                        break;
                    case 5:
                        // Integrate data structures (Set, PriorityQueue, BTree)
                        medicalRecordSystem.integrateDataStructures();
                        break;
                    case 0:
                        System.out.println("Exiting Medical Record System. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 0);
        }
    }

    // Method to interactively add a patient to the system
    private static void addPatient(MedicalRecordSystem medicalRecordSystem, Scanner scanner) {
        // Collect patient information from the user
        System.out.print("Enter Patient ID: ");
        String patientID = scanner.next();
        System.out.print("Enter Patient Name: ");
        String name = scanner.next();
        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Patient Medical History: ");
        String medicalHistory = scanner.next();
        System.out.print("Enter Severity of Illness: ");
        int severityOfIllness = scanner.nextInt();

        // Create a new patient
        Patient newPatient = new Patient(patientID, name, age, medicalHistory, severityOfIllness);

        // Add the patient to the system
        medicalRecordSystem.addPatient(newPatient);

        System.out.println("Patient added successfully!");
    }
}
