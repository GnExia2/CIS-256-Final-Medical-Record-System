import java.util.Date;

public class InitialDataLoader {

    public static void loadInitialData(MedicalRecordSystem recordSystem) {
        // Manually add 10 patients
        recordSystem.addPatient("P001", "John Doe", "Headache");
        recordSystem.addPatient("P002", "Jane Smith", "Fever");
        recordSystem.addPatient("P003", "Alice Johnson", "Cough");
        recordSystem.addPatient("P004", "Bob Brown", "Back Pain");
        recordSystem.addPatient("P005", "Eva White", "Fatigue");
        recordSystem.addPatient("P006", "Mike Davis", "Allergies");
        recordSystem.addPatient("P007", "Sophia Miller", "Stomachache");
        recordSystem.addPatient("P008", "Daniel Wilson", "Insomnia");
        recordSystem.addPatient("P009", "Olivia Moore", "Joint Pain");
        recordSystem.addPatient("P010", "William Harris", "Migraine");

        // Manually add 3 doctors
        recordSystem.addDoctor("D001", "Dr. Smith", "Cardiology");
        recordSystem.addDoctor("D002", "Dr. Johnson", "Dermatology");
        recordSystem.addDoctor("D003", "Dr. Brown", "Pediatrics");

        // Schedule some appointments with dates (you can modify this based on your requirements)
        Date currentDate = new Date();

        // Example: Scheduling appointments for the current date
        recordSystem.scheduleAppointment("P001", "D001", currentDate);
        recordSystem.scheduleAppointment("P001", "D002", currentDate);
        recordSystem.scheduleAppointment("P002", "D001", currentDate);
        recordSystem.scheduleAppointment("P003", "D002", currentDate);
        recordSystem.scheduleAppointment("P004", "D003", currentDate);
        recordSystem.scheduleAppointment("P005", "D001", currentDate);
        recordSystem.scheduleAppointment("P005", "D002", currentDate);
        recordSystem.scheduleAppointment("P006", "D003", currentDate);
        recordSystem.scheduleAppointment("P007", "D001", currentDate);
        recordSystem.scheduleAppointment("P008", "D002", currentDate);
    }
}
