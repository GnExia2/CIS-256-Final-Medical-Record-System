import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InitialDataLoader {
    public static void loadInitialData(MedicalRecord recordSystem) {
        // Add initial patients and doctors
        recordSystem.addPatient("P1", "John Doe", "Fever", 5);
        recordSystem.addPatient("P2", "Jane Smith", "Headache", 3);
        recordSystem.addPatient("P3", "Alice Johnson", "Back Pain", 7);
        recordSystem.addPatient("P4", "Bob Miller", "Allergies", 2);
        recordSystem.addPatient("P5", "Eva Davis", "Migraine", 6);
        recordSystem.addPatient("P6", "David Brown", "Stomachache", 4);
        recordSystem.addPatient("P7", "Sophia Wilson", "Sprained Ankle", 8);
        recordSystem.addPatient("P8", "Michael Jones", "Cough", 1);
        recordSystem.addPatient("P9", "Olivia Smith", "Fatigue", 9);
        recordSystem.addPatient("P10", "James White", "Sore Throat", 5);

        recordSystem.addDoctor("D1", "Dr. Johnson", "Neurology");
        recordSystem.addDoctor("D2", "Dr. Miller", "Cardiology");
        recordSystem.addDoctor("D3", "Dr. Davis", "Dermatology");

        // Schedule initial appointments with dates
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            recordSystem.scheduleAppointment("P1", "D1", dateFormat.parse("2023-01-15 10:00:00"));
            recordSystem.scheduleAppointment("P2", "D2", dateFormat.parse("2023-01-16 11:30:00"));
            recordSystem.scheduleAppointment("P3", "D3", dateFormat.parse("2023-01-17 13:45:00"));
            recordSystem.scheduleAppointment("P4", "D1", dateFormat.parse("2023-01-18 14:15:00"));
            recordSystem.scheduleAppointment("P5", "D2", dateFormat.parse("2023-01-19 15:30:00"));
            recordSystem.scheduleAppointment("P6", "D3", dateFormat.parse("2023-01-20 09:00:00"));
            recordSystem.scheduleAppointment("P7", "D1", dateFormat.parse("2023-01-21 10:45:00"));
            recordSystem.scheduleAppointment("P8", "D2", dateFormat.parse("2023-01-22 12:30:00"));
            recordSystem.scheduleAppointment("P9", "D3", dateFormat.parse("2023-01-23 16:00:00"));
            recordSystem.scheduleAppointment("P10", "D1", dateFormat.parse("2023-01-24 17:15:00"));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
