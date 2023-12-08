import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MedicalRecordUI {
    private static final Scanner scanner = new Scanner(System.in);

    public static void launchUI(MedicalRecord recordSystem) {
        int choice;
        do {
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

            choice = scanner.nextInt();
            scanner.nextLine();

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

    private static void addPatient(MedicalRecord recordSystem) {
        System.out.print("Enter patient ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter medical condition: ");
        String condition = scanner.nextLine();
        System.out.print("Enter severity level (1-10): ");
        int severityLevel = scanner.nextInt();

        recordSystem.addPatient(id, name, condition, severityLevel);
        System.out.println("Patient added successfully!");
    }

    private static void addDoctor(MedicalRecord recordSystem) {
        System.out.print("Enter doctor ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter doctor name: ");
        String name = scanner.nextLine();
        System.out.print("Enter doctor specialization: ");
        String specialization = scanner.nextLine();

        recordSystem.addDoctor(id, name, specialization);
        System.out.println("Doctor added successfully!");
    }

    private static void scheduleAppointment(MedicalRecord recordSystem) {
        System.out.print("Enter patient ID: ");
        String patientId = scanner.nextLine();
        System.out.print("Enter doctor ID: ");
        String doctorId = scanner.nextLine();

        try {
            System.out.print("Enter appointment date (yyyy-MM-dd HH:mm:ss): ");
            String dateString = scanner.nextLine();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = dateFormat.parse(dateString);

            recordSystem.scheduleAppointment(patientId, doctorId, date);
            System.out.println("Appointment scheduled successfully!");
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter a valid date.");
        }
    }

    private static void viewPatientInformation(MedicalRecord recordSystem) {
        System.out.print("Enter patient ID: ");
        String patientId = scanner.nextLine();

        Patient patient = recordSystem.findPatientById(patientId);

        if (patient != null) {
            System.out.println("\n==== Patient Information ====");
            System.out.println("Patient ID: " + patient.getId());
            System.out.println("Patient Name: " + patient.getName());
            System.out.println("Medical Condition: " + patient.getMedicalCondition());
            System.out.println("Severity Level: " + patient.getSeverityLevel());
        } else {
            System.out.println("Patient not found.");
        }
    }

    private static void viewMostSeverePatient(MedicalRecord recordSystem) {
        Patient mostSeverePatient = recordSystem.findMostSeverePatient();

        if (mostSeverePatient != null) {
            System.out.println("\n==== Most Severe Patient ====");
            System.out.println("Patient ID: " + mostSeverePatient.getId());
            System.out.println("Patient Name: " + mostSeverePatient.getName());
            System.out.println("Medical Condition: " + mostSeverePatient.getMedicalCondition());
            System.out.println("Severity Level: " + mostSeverePatient.getSeverityLevel());
        } else {
            System.out.println("No patients found.");
        }
    }

    private static void viewAllPatients(MedicalRecord recordSystem) {
        System.out.println("\n==== All Patients ====");
        List<Patient> patients = recordSystem.getAllPatients();

        if (!patients.isEmpty()) {
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

    private static void viewAllDoctors(MedicalRecord recordSystem) {
        System.out.println("\n==== All Doctors ====");
        List<Doctor> doctors = recordSystem.getAllDoctors();

        if (!doctors.isEmpty()) {
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
