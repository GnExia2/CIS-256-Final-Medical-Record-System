import java.util.Date;

public class Appointment {
    String patientId;
    String doctorId;
    Date date;

    public Appointment(String patientId, String doctorId, Date date) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }
}
