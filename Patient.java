// Class to represent a patient in the medical record system
public class Patient {
    // Patient attributes
    private String id;                // Unique identifier for the patient
    private String name;              // Name of the patient
    private String medicalCondition;  // Medical condition of the patient
    private int severityLevel;         // Severity level of the patient's condition

    // Constructor to initialize a new Patient object
    public Patient(String id, String name, String medicalCondition, int severityLevel) {
        this.id = id;
        this.name = name;
        this.medicalCondition = medicalCondition;
        this.severityLevel = severityLevel;
    }

    // Getter method to retrieve the patient's ID
    public String getId() {
        return id;
    }

    // Getter method to retrieve the patient's name
    public String getName() {
        return name;
    }

    // Getter method to retrieve the patient's medical condition
    public String getMedicalCondition() {
        return medicalCondition;
    }

    // Getter method to retrieve the severity level of the patient's condition
    public int getSeverityLevel() {
        return severityLevel;
    }
}
