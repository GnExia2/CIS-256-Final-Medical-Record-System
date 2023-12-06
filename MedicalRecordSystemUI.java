import java.util.Scanner;

public class MedicalRecordSystemUI {

    public static void runUserInterface(MedicalRecordSystem medicalRecordSystem) {
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;

            do {
                System.out.println("\nMedical Record System Menu:");
                System.out.println("1. Add Patient");
                System.out.println("2. Add Relationship");
                System.out.println("3. Prioritize Patients");
                System.out.println("4. Optimize Treatment Plans");
                System.out.println("5. Integrate Data Structures");
                System.out.println("6. View All Patients");  // New option
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter patient details:");
                        System.out.print("Patient ID: ");
                        System.out.print("Name: ");
                        System.out.print("Age: ");
                        scanner.nextLine(); // Consume newline character
                        break;
                        
                    case 2:
                        // Implement relationship addition functionality
                        break;
                        
                    case 3:
                        medicalRecordSystem.prioritizePatients();
                        break;

                    case 4:
                        medicalRecordSystem.optimizeTreatmentPlans();
                        break;
                    case 5:
                        medicalRecordSystem.integrateDataStructures();
                        break;
                    case 6:
                        // View all patients
                        viewAllPatients(medicalRecordSystem);
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

        // New method to view all patients
        private static void viewAllPatients(MedicalRecordSystem medicalRecordSystem) {
            System.out.println("\nAll Patients:");
            for (Patient patient : medicalRecordSystem.getGraph().getAllPatients()) {
                displayPatientInformation(patient);
            }
        }
    
        // Helper method to display patient information
        private static void displayPatientInformation(Patient patient) {
            System.out.println("Patient ID: " + patient.getPatientID());
            System.out.println("Name: " + patient.getName());
            System.out.println("Age: " + patient.getAge());
            System.out.println("Medical History: " + patient.getMedicalHistory());
            System.out.println("-------------");
        }
}
