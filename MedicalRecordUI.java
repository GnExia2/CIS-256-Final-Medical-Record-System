import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MedicalRecordUI {
    private static final Scanner scanner = new Scanner(System.in);
    private static final MedicalRecordSystem recordSystem = new MedicalRecordSystem();

    public static void main(String[] args) {
        launchUI(recordSystem);
    }

    public static void launchUI(MedicalRecordSystem recordSystem) {
        displayMenu(recordSystem);
    }

    public static void displayMenu(MedicalRecordSystem recordSystem) {
        int choice;
        do {
            // Display the main menu
            System.out.println("\n==== Medical Record System ====");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Patient Information");
            System.out.println("5. View Most Connected Patient");
            System.out.println("6. View All Patients");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            // Get user input for menu choice
            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            // Perform action based on user choice
            switch (choice) {
                case 1:
                    addPatient(recordSystem);
                    break;
                case 2:
                    addDoctor(recordSystem);
                    break;
                case 3:
                    scheduleAppointment(recordSystem);
                    break;
                case 4:
                    viewPatientInformation(recordSystem);
                    break;
                case 5:
                    viewMostConnectedPatient(recordSystem);
                    break;
                case 6:
                    viewAllPatients(recordSystem);
                    break;
                case 7:
                    System.out.println("Exiting the Medical Record System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 7);
    }


    // Method to add a new patient to the system
    private static void addPatient(MedicalRecordSystem recordSystem) {
        // Implement logic to gather patient information and add to the system
        // For simplicity, let's assume patient ID, name, and medical condition are entered
        System.out.print("Enter Patient ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Patient Medical Condition: ");
        String medicalCondition = scanner.nextLine();

        // Add the patient to the system
        recordSystem.addPatient(id, name, medicalCondition);

        System.out.println("Patient added successfully!");
    }

    // Method to add a new doctor to the system
    private static void addDoctor(MedicalRecordSystem recordSystem) {
        // Implement logic to gather doctor information and add to the system
        // For simplicity, let's assume doctor ID, name, and specialty are entered
        System.out.print("Enter Doctor ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Doctor Specialty: ");
        String specialty = scanner.nextLine();

        // Add the doctor to the system
        recordSystem.addDoctor(id, name, specialty);

        System.out.println("Doctor added successfully!");
    }

    // Method to schedule a new appointment
    private static void scheduleAppointment(MedicalRecordSystem recordSystem) {
        // Implement logic to gather appointment information and add to the system
        // For simplicity, let's assume patient ID, doctor ID, and date are entered
        System.out.print("Enter Patient ID for Appointment: ");
        String patientId = scanner.nextLine();

        System.out.print("Enter Doctor ID for Appointment: ");
        String doctorId = scanner.nextLine();

        System.out.print("Enter Appointment Date (yyyy-MM-dd): ");
        String dateString = scanner.nextLine();

        // Parse the date
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Schedule the appointment
        recordSystem.scheduleAppointment(patientId, doctorId, date);

        System.out.println("Appointment scheduled successfully!");
    }

    private static void viewPatientInformation(MedicalRecordSystem recordSystem) {
        System.out.println("\n=== View Patient Information ===");
        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine();

        Patient patient = recordSystem.getPatientById(patientId);
        if (patient != null) {
            System.out.println("Patient Information:");
            System.out.println("ID: " + patient.id);
            System.out.println("Name: " + patient.name);
            System.out.println("Medical Condition: " + patient.medicalCondition);

            List<Appointment> appointments = recordSystem.getAppointmentsForPatient(patientId);
            if (!appointments.isEmpty()) {
                System.out.println("\nAppointments:");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                for (Appointment appointment : appointments) {
                    System.out.println("Date: " + dateFormat.format(appointment.date) +
                            ", Doctor: " + appointment.doctorId);
                }
            } else {
                System.out.println("No appointments found for this patient.");
            }
        } else {
            System.out.println("Patient not found. Please check the ID and try again.");
        }
    }

    private static void viewAllPatients(MedicalRecordSystem recordSystem) {
        List<Patient> allPatients = recordSystem.getAllPatients();
    
        if (!allPatients.isEmpty()) {
            System.out.println("\n=== All Patients ===");
            for (Patient patient : allPatients) {
                System.out.println("ID: " + patient.id);
                System.out.println("Name: " + patient.name);
                System.out.println("Medical Condition: " + patient.medicalCondition);
                System.out.println("-------------");
            }
        } else {
            System.out.println("No patients found.");
        }
    }

    // Method to view the most connected patient
    private static void viewMostConnectedPatient(MedicalRecordSystem recordSystem) {
        System.out.println("\nViewing Most Connected Patient:");
        MedicalRecordSystem.displayMostConnectedPatient(recordSystem);
    }


}
