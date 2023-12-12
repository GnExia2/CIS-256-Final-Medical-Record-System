import java.util.*;

// Class to represent a medical record system
public class MedicalRecord {
    // Lists to store patients, doctors, and appointments
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Appointment> appointments;

    // Graph to represent relationships between patients and doctors
    private Graph patientDoctorGraph;

    // Priority queue to manage appointments based on date
    private PriorityQueue<Appointment> appointmentPriorityQueue;

    // Stack to keep track of patient history
    private Stack<Patient> patientHistoryStack;

    // Set to store unique doctors using HashSet
    private Set<Doctor> uniqueDoctors;

    // Constructor to initialize lists and data structures
    public MedicalRecord() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.appointments = new ArrayList<>();
        this.patientDoctorGraph = new Graph();
        this.appointmentPriorityQueue = new PriorityQueue<>(Comparator.comparing(Appointment::getDate));
        this.patientHistoryStack = new Stack<>();
        this.uniqueDoctors = new HashSet<>();
    }

    // Method to add a new patient to the system
    public void addPatient(String id, String name, String medicalCondition, int severityLevel) {
        Patient newPatient = new Patient(id, name, medicalCondition, severityLevel);
        patients.add(newPatient);
        patientHistoryStack.push(newPatient);
        patientDoctorGraph.addVertex(id);
    }

    // Method to add a new doctor to the system
    public void addDoctor(String id, String name, String specialization) {
        Doctor newDoctor = new Doctor(id, name, specialization);
        doctors.add(newDoctor);
        uniqueDoctors.add(newDoctor);
        patientDoctorGraph.addVertex(id);
    }

    // Method to schedule an appointment between a patient and a doctor
    public void scheduleAppointment(String patientId, String doctorId, Date date) {
        Appointment newAppointment = new Appointment(patientId, doctorId, date);
        appointments.add(newAppointment);
        appointmentPriorityQueue.add(newAppointment);
        patientDoctorGraph.addEdge(patientId, doctorId);
    }

    // Method to get the next scheduled appointment using priority queue
    public Appointment getNextScheduledAppointment() {
        return appointmentPriorityQueue.peek();
    }

    // Method to add a patient with history to the system and update the stack
    public void addPatientWithHistory(String id, String name, String medicalCondition, int severityLevel) {
        Patient newPatient = new Patient(id, name, medicalCondition, severityLevel);
        patients.add(newPatient);
        patientHistoryStack.push(newPatient);
        patientDoctorGraph.addVertex(id);
    }

    // Method to get the most recently added patient from the stack
    public Patient getMostRecentPatient() {
        return patientHistoryStack.isEmpty() ? null : patientHistoryStack.peek();
    }

    // Method to add a doctor to the unique set
    public void addUniqueDoctor(String id, String name, String specialization) {
        Doctor newDoctor = new Doctor(id, name, specialization);
        doctors.add(newDoctor);
        uniqueDoctors.add(newDoctor);
        patientDoctorGraph.addVertex(id);
    }

    // Method to retrieve all doctors in the system
    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    // Method to retrieve all patients in the system
    public List<Patient> getAllPatients() {
        return patients;
    }

    // Method to print patient-doctor connections in the graph
    public void printPatientConnections() {
        patientDoctorGraph.printGraph();
    }

    // Method to find the most severe patient among connected patients
    public Patient findMostSeverePatient() {
        List<Patient> connectedPatients = getConnectedPatients();

        if (!connectedPatients.isEmpty()) {
            Patient mostSeverePatient = connectedPatients.get(0);

            for (Patient patient : connectedPatients) {
                if (patient.getSeverityLevel() > mostSeverePatient.getSeverityLevel()) {
                    mostSeverePatient = patient;
                }
            }

            return mostSeverePatient;
        }

        return null;
    }

    // Helper method to retrieve connected patients from the graph
    private List<Patient> getConnectedPatients() {
        List<Patient> connectedPatients = new ArrayList<>();

        for (Graph.Vertex vertex : patientDoctorGraph.vertices) {
            Patient patient = findPatientById(vertex.label);
            if (patient != null) {
                connectedPatients.add(patient);
            }
        }

        return connectedPatients;
    }

    // Method to find a patient by ID
    public Patient findPatientById(String patientId) {
        for (Patient patient : patients) {
            if (patient.getId().equals(patientId)) {
                return patient;
            }
        }
        return null;
    }
}
