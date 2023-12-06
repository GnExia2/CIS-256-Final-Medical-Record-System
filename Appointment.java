

// Appointment.java

public class Appointment implements Comparable<Appointment> {
    private Patient patient;
    private String time;

    public Appointment(Patient patient, String time) {
        this.patient = patient;
        this.time = time;
    }

    public Patient getPatient() {
        return patient;
    }

    @Override
    public int compareTo(Appointment other) {
        // Compare appointments based on patient names for simplicity
        return this.patient.getName().compareTo(other.getPatient().getName());
    }

    @Override
    public String toString() {
        return "Appointment for " + patient.getName() + " at " + time;
    }
}
