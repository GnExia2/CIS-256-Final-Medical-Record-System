import java.util.*;
import java.util.stream.Collectors;

public class MedicalRecordSystem {
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Appointment> appointments;
    private Graph patientGraph;

    public MedicalRecordSystem() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.appointments = new ArrayList<>();
        this.patientGraph = new Graph();
    }

    public void addPatient(String id, String name, String medicalCondition) {
        Patient patient = new Patient(id, name, medicalCondition);
        patients.add(patient);
        patientGraph.addVertex(id);
    }

    public void addDoctor(String id, String name, String specialty) {
        Doctor doctor = new Doctor(id, name, specialty);
        doctors.add(doctor);
    }

    public void scheduleAppointment(String patientId, String doctorId, Date date) {
        Appointment appointment = new Appointment(patientId, doctorId, date);
        appointments.add(appointment);
    }

    public void connectPatients(String patient1Id, String patient2Id) {
        patientGraph.addEdge(patient1Id, patient2Id);
    }

    public Patient findMostConnectedPatient() {
        Map<String, Integer> appointmentCount = new HashMap<>();

        // Count appointments for each patient
        for (Appointment appointment : appointments) {
            String patientId = appointment.patientId;
            appointmentCount.put(patientId, appointmentCount.getOrDefault(patientId, 0) + 1);
        }

        // Find the patient with the maximum appointment count
        Optional<Map.Entry<String, Integer>> maxEntry = appointmentCount.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue));

        if (maxEntry.isPresent()) {
            String mostConnectedPatientId = maxEntry.get().getKey();
            return getPatientById(mostConnectedPatientId);
        }

        return null;
    }

    public static void displayMostConnectedPatient(MedicalRecordSystem recordSystem) {
        Patient mostConnectedPatient = recordSystem.findMostConnectedPatient();

        if (mostConnectedPatient != null) {
            System.out.println("\n=== Most Connected Patient ===");
            System.out.println("ID: " + mostConnectedPatient.id);
            System.out.println("Name: " + mostConnectedPatient.name);
            System.out.println("Medical Condition: " + mostConnectedPatient.medicalCondition);
        } else {
            System.out.println("No patients found.");
        }
    }
    

    public Patient getPatientById(String id) {
        for (Patient patient : patients) {
            if (patient.id.equals(id)) {
                return patient;
            }
        }
        return null;
    }

    public Doctor getDoctorById(String id) {
        for (Doctor doctor : doctors) {
            if (doctor.id.equals(id)) {
                return doctor;
            }
        }
        return null;
    }

    public List<Appointment> getAppointmentsForPatient(String patientId) {
        return appointments.stream()
                .filter(appointment -> appointment.patientId.equals(patientId))
                .collect(Collectors.toList());
    }

    public void printPatientConnections() {
        System.out.println("\n=== Patient Connections ===");
        patientGraph.printGraph();
    }

    public void printMostConnectedPatient() {
        Patient mostConnectedPatient = findMostConnectedPatient();

        if (mostConnectedPatient != null) {
            System.out.println("\n=== Most Connected Patient ===");
            System.out.println("ID: " + mostConnectedPatient.id);
            System.out.println("Name: " + mostConnectedPatient.name);
            System.out.println("Medical Condition: " + mostConnectedPatient.medicalCondition);
        } else {
            System.out.println("No patients found.");
        }
    }

    // Add this method to MedicalRecordSystem
    public List<Patient> getAllPatients() {
        return patients;
    }

}
