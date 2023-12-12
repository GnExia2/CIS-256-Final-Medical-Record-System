import java.util.Date;

// Class to represent an appointment in the medical record system
public class Appointment {
    // Appointment attributes
    private String patientId;       // ID of the patient associated with the appointment
    private String doctorId;        // ID of the doctor associated with the appointment
    private Date date;              // Date and time of the appointment

    // Constructor to initialize a new Appointment object
    public Appointment(String patientId, String doctorId, Date date) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }

    // Getter method to retrieve the patient's ID associated with the appointment
    public String getPatientId() {
        return patientId;
    }

    // Getter method to retrieve the doctor's ID associated with the appointment
    public String getDoctorId() {
        return doctorId;
    }

    // Getter method to retrieve the date and time of the appointment
    public Date getDate() {
        return date;
    }
}
