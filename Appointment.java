import java.util.Date;

public class Appointment {
    private String patientId;
    private String doctorId;
    private Date date;

    public Appointment(String patientId, String doctorId, Date date) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public Date getDate() {
        return date;
    }
}
