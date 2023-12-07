// Appointment.java

// Class representing an appointment in the medical record system
public class Appointment implements Comparable<Appointment> {
    // Patient associated with the appointment
    private Patient patient;
    // Description of the appointment
    private String description;
    private String details;

    // Constructor to initialize an appointment
    public Appointment(Patient patient, String description) {
        this.patient = patient;
        this.description = description;
    }

    // Getter method for retrieving the associated patient
    public Patient getPatient() {
        return patient;
    }

    // Getter method for retrieving the description of the appointment
    public String getDescription() {
        return description;
    }

    // Method to get details of the appointment
    public String getDetails() {
        return "Patient: " + patient.getName() + ", Details: " + details;
    }



    // Comparable interface method for comparing appointments based on patient severity
    @Override
    public int compareTo(Appointment other) {
        // Compare appointments based on patient severity of illness
        return Integer.compare(this.patient.getSeverityOfIllness(), other.patient.getSeverityOfIllness());
    }
}
