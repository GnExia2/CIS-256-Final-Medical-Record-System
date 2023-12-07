// Patient.java

// Class representing a patient in the medical record system
public class Patient {
    // Unique identifier for the patient
    private String patientID;
    // Name of the patient
    private String name;
    // Age of the patient
    private int age;
    // Medical history of the patient
    private String medicalHistory;
    // Severity of illness for the patient
    private int severityOfIllness;

    // Constructor to initialize a patient with basic information
    public Patient(String patientID, String name, int age, String medicalHistory, int severityOfIllness) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.medicalHistory = medicalHistory;
        this.severityOfIllness = severityOfIllness;
    }

    // Getter method for retrieving the patient's unique identifier
    public String getPatientID() {
        return patientID;
    }

    // Getter method for retrieving the patient's name
    public String getName() {
        return name;
    }

    // Getter method for retrieving the patient's age
    public int getAge() {
        return age;
    }

    // Getter method for retrieving the patient's medical history
    public String getMedicalHistory() {
        return medicalHistory;
    }

    // Setter method for updating the patient's medical history
    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    // Getter method for retrieving the severity of illness for the patient
    public int getSeverityOfIllness() {
        return severityOfIllness;
    }
}
