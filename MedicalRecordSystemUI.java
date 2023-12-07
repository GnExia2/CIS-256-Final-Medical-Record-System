import java.util.List;
import java.util.Scanner;

public class MedicalRecordSystemUI {

    public static void runUserInterface(MedicalRecordSystem medicalRecordSystem) {
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;

            do {
                System.out.println("\nMedical Record System Menu:");
                System.out.println("1. Add Patient");
                System.out.println("2. View All Patients");
                System.out.println("3. Schedule Appointment");
                System.out.println("4. View All Appointments");
                System.out.println("5. Prioritize Patients (Manual Greedy Algorithm)");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addPatient(medicalRecordSystem, scanner);
                        break;
                    case 2:
                        viewAllPatients(medicalRecordSystem);
                        break;
                    case 3:
                        scheduleAppointment(medicalRecordSystem, scanner);
                        break;
                    case 4:
                        viewAllAppointments(medicalRecordSystem);
                        break;
                    case 5:
                        prioritizePatients(medicalRecordSystem);
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

    private static void addPatient(MedicalRecordSystem medicalRecordSystem, Scanner scanner) {
        // Implement patient addition functionality
        System.out.print("Enter patient ID: ");
        String patientID = scanner.next();
        System.out.print("Enter patient name: ");
        String name = scanner.next();
        System.out.print("Enter patient age: ");
        int age = scanner.nextInt();
        System.out.print("Enter patient medical history: ");
        String medicalHistory = scanner.next();
        System.out.print("Enter patient severity of illness: ");
        int severityOfIllness = scanner.nextInt();

        // Create a new patient and add it to the system
        Patient newPatient = new Patient(patientID, name, age, medicalHistory, severityOfIllness);
        medicalRecordSystem.addPatient(newPatient);

        System.out.println("Patient added successfully!");
    }

    // Method to view all patients
    public static void viewAllPatients(MedicalRecordSystem medicalRecordSystem) {
        // Get all patients from the MedicalRecordSystem
        List<Patient> allPatients = medicalRecordSystem.getAllPatients();

        // Display information for each patient using displayPatientInformation method
        for (Patient patient : allPatients) {
            displayPatientInformation(patient);
        }
    }


    private static void scheduleAppointment(MedicalRecordSystem medicalRecordSystem, Scanner scanner) {
        // Implement functionality to schedule an appointment
        System.out.print("Enter patient ID for appointment: ");
        String patientID = scanner.next();
        Patient patient = medicalRecordSystem.getPatientByID(patientID);

        if (patient != null) {
            Appointment newAppointment = new Appointment(patient, "Next appointment");
            medicalRecordSystem.scheduleAppointment(newAppointment);
            System.out.println("Appointment scheduled successfully!");
        } else {
            System.out.println("Patient not found. Please check the patient ID.");
        }
    }

    private static void viewAllAppointments(MedicalRecordSystem medicalRecordSystem) {
        // Implement functionality to view all appointments
        System.out.println("\nAll Appointments:");
        for (Appointment appointment : medicalRecordSystem.getAllAppointments()) {
            displayAppointmentInformation(appointment);
        }
    }

    private static void prioritizePatients(MedicalRecordSystem medicalRecordSystem) {
        // Implement functionality to prioritize patients using a manual greedy algorithm
        System.out.println("\nPrioritized Patients (Manual Greedy Algorithm):");
        for (Patient patient : medicalRecordSystem.prioritizePatients()) {
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

    private static void displayAppointmentInformation(Appointment appointment) {
        System.out.println("Patient ID: " + appointment.getPatient().getPatientID());
        System.out.println("Appointment Details: " + appointment.getDetails());
        System.out.println("-------------");
    }
}
