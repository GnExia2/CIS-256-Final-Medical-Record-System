import java.util.*;

public class MedicalRecord {
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Appointment> appointments;
    private Graph patientDoctorGraph;
    private PriorityQueue<Appointment> appointmentPriorityQueue;
    private Stack<Patient> patientHistoryStack;
    private Set<Doctor> uniqueDoctors;

    public MedicalRecord() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.appointments = new ArrayList<>();
        this.patientDoctorGraph = new Graph();
        this.appointmentPriorityQueue = new PriorityQueue<>(Comparator.comparing(Appointment::getDate));
        this.patientHistoryStack = new Stack<>();
        this.uniqueDoctors = new HashSet<>();
    }

    public void addPatient(String id, String name, String medicalCondition, int severityLevel) {
        Patient newPatient = new Patient(id, name, medicalCondition, severityLevel);
        patients.add(newPatient);
        patientHistoryStack.push(newPatient);
        patientDoctorGraph.addVertex(id);
    }

    public void addDoctor(String id, String name, String specialization) {
        Doctor newDoctor = new Doctor(id, name, specialization);
        doctors.add(newDoctor);
        uniqueDoctors.add(newDoctor);
        patientDoctorGraph.addVertex(id);
    }

    public void scheduleAppointment(String patientId, String doctorId, Date date) {
        Appointment newAppointment = new Appointment(patientId, doctorId, date);
        appointments.add(newAppointment);
        appointmentPriorityQueue.add(newAppointment);
        patientDoctorGraph.addEdge(patientId, doctorId);
    }

    // Method to schedule appointment using priority queue
    public void scheduleAppointmentWithPriorityQueue(String patientId, String doctorId, Date date) {
        Appointment newAppointment = new Appointment(patientId, doctorId, date);
        appointments.add(newAppointment);
        appointmentPriorityQueue.add(newAppointment);
        patientDoctorGraph.addEdge(patientId, doctorId);
    }

    // Method to get the next scheduled appointment
    public Appointment getNextScheduledAppointment() {
        return appointmentPriorityQueue.peek();
    }

    // Method to add a patient and push onto the stack
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

    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    public List<Patient> getAllPatients() {
        return patients;
    }

    public void printPatientConnections() {
        patientDoctorGraph.printGraph();
    }

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

    public Patient findPatientById(String patientId) {
        for (Patient patient : patients) {
            if (patient.getId().equals(patientId)) {
                return patient;
            }
        }
        return null;
    }
}
