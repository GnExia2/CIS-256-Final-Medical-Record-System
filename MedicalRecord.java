import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MedicalRecord {
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Appointment> appointments;
    private Graph patientDoctorGraph;

    public MedicalRecord() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.appointments = new ArrayList<>();
        this.patientDoctorGraph = new Graph();
    }

    public void addPatient(String id, String name, String medicalCondition, int severityLevel) {
        patients.add(new Patient(id, name, medicalCondition, severityLevel));
        patientDoctorGraph.addVertex(id);
    }

    public void addDoctor(String id, String name, String specialization) {
        doctors.add(new Doctor(id, name, specialization));
        patientDoctorGraph.addVertex(id);
    }

    public void scheduleAppointment(String patientId, String doctorId, Date date) {
        appointments.add(new Appointment(patientId, doctorId, date));
        patientDoctorGraph.addEdge(patientId, doctorId);
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
