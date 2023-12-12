import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

// Class to represent the user interface for the medical record system
public class MedicalRecordUI {
    // Scanner object for user input
    private static final Scanner scanner = new Scanner(System.in);

    // Method to launch the medical record system UI
    public static void launchUI(MedicalRecord recordSystem) {
        int choice;
        do {
            // Display menu options to the user
            System.out.println("\n==== Medical Record System ====");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Patient Information");
            System.out.println("5. View Most Severe Patient");
            System.out.println("6. View All Patients");
            System.out.println("7. View All Doctors");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            // Get user input for menu choice
            choice = scanner.nextInt();
            scanner.nextLine();

            // Execute corresponding method based on user choice
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
                    viewMostSeverePatient(recordSystem);
                    break;
                case 6:
                    viewAllPatients(recordSystem);
                    break;
                case 7:
                    viewAllDoctors(recordSystem);
                    break;
                case 8:
                    System.out.println("Exiting the Medical Record System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 8);
    }

    // Method to add a new patient using user input
    private static void addPatient(MedicalRecord recordSystem) {
        System.out.print("Enter patient ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter medical condition: ");
        String condition = scanner.nextLine();
        System.out.print("Enter severity level (1-10): ");
        int severityLevel = scanner.nextInt();

        // Call the corresponding method in the MedicalRecord class to add a patient
        recordSystem.addPatient(id, name, condition, severityLevel);
        System.out.println("Patient added successfully!");
    }

    // Method to add a new doctor using user input
    private static void addDoctor(MedicalRecord recordSystem) {
        System.out.print("Enter doctor ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter doctor name: ");
        String name = scanner.nextLine();
        System.out.print("Enter doctor specialization: ");
        String specialization = scanner.nextLine();

        // Call the corresponding method in the MedicalRecord class to add a doctor
        recordSystem.addDoctor(id, name, specialization);
        System.out.println("Doctor added successfully!");
    }

    // Method to schedule an appointment using user input
    private static void scheduleAppointment(MedicalRecord recordSystem) {
        System.out.print("Enter patient ID: ");
        String patientId = scanner.nextLine();
        System.out.print("Enter doctor ID: ");
        String doctorId = scanner.nextLine();

        try {
            // Get user input for appointment date and parse it
            System.out.print("Enter appointment date (yyyy-MM-dd HH:mm:ss): ");
            String dateString = scanner.nextLine();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = dateFormat.parse(dateString);

            // Call the corresponding method in the MedicalRecord class to schedule an appointment
            recordSystem.scheduleAppointment(patientId, doctorId, date);
            System.out.println("Appointment scheduled successfully!");
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter a valid date.");
        }
    }

    // Method to view patient information using user input
    private static void viewPatientInformation(MedicalRecord recordSystem) {
        System.out.print("Enter patient ID: ");
        String patientId = scanner.nextLine();

        // Call the corresponding method in the MedicalRecord class to get patient information
        Patient patient = recordSystem.findPatientById(patientId);

        if (patient != null) {
            // Display patient information
            System.out.println("\n==== Patient Information ====");
            System.out.println("Patient ID: " + patient.getId());
            System.out.println("Patient Name: " + patient.getName());
            System.out.println("Medical Condition: " + patient.getMedicalCondition());
            System.out.println("Severity Level: " + patient.getSeverityLevel());
        } else {
            System.out.println("Patient not found.");
        }
    }

    // Method to view the most severe patient in the system
    private static void viewMostSeverePatient(MedicalRecord recordSystem) {
        // Call the corresponding method in the MedicalRecord class to get the most severe patient
        Patient mostSeverePatient = recordSystem.findMostSeverePatient();

        if (mostSeverePatient != null) {
            // Display information about the most severe patient
            System.out.println("\n==== Most Severe Patient ====");
            System.out.println("Patient ID: " + mostSeverePatient.getId());
            System.out.println("Patient Name: " + mostSeverePatient.getName());
            System.out.println("Medical Condition: " + mostSeverePatient.getMedicalCondition());
            System.out.println("Severity Level: " + mostSeverePatient.getSeverityLevel());
        } else {
            System.out.println("No patients found.");
        }
    }

    // Method to view information about all patients in the system
    private static void viewAllPatients(MedicalRecord recordSystem) {
        // Call the corresponding method in the MedicalRecord class to get all patients
        System.out.println("\n==== All Patients ====");
        List<Patient> patients = recordSystem.getAllPatients();

        if (!patients.isEmpty()) {
            // Display information about each patient
            for (Patient patient : patients) {
                System.out.println("Patient ID: " + patient.getId());
                System.out.println("Patient Name: " + patient.getName());
                System.out.println("Medical Condition: " + patient.getMedicalCondition());
                System.out.println("Severity Level: " + patient.getSeverityLevel());
                System.out.println("---------------------");
            }
        } else {
            System.out.println("No patients found.");
        }
    }

    // Method to view information about all doctors in the system
    private static void viewAllDoctors(MedicalRecord recordSystem) {
        // Call the corresponding method in the MedicalRecord class to get all doctors
        System.out.println("\n==== All Doctors ====");
        List<Doctor> doctors = recordSystem.getAllDoctors();

        if (!doctors.isEmpty()) {
            // Display information about each doctor
            for (Doctor doctor : doctors) {
                System.out.println("Doctor ID: " + doctor.getId());
                System.out.println("Doctor Name: " + doctor.getName());
                System.out.println("Specialization: " + doctor.getSpecialization());
                System.out.println("---------------------");
            }
        } else {
            System.out.println("No doctors found.");
        }
    }
}
