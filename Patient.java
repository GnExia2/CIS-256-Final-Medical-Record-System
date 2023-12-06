// Patient.java
public class Patient {
    private String patientID;
    private String name;
    private int age;
    private String medicalCondition;
    private String medicalHistory;
    private int severityOfIllness;


    public Patient(String patientID, String name, int age, String medicalCondition, int severityOfIllness) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.medicalCondition = medicalCondition;
        this.severityOfIllness = severityOfIllness;
    }
    
    // Getters and setters for all fields
    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public void setMedicalCondition(String medicalCondition) {
        this.medicalCondition = medicalCondition;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    // Method to get severity of illness
    public int getSeverityOfIllness() {
        return severityOfIllness;
    }
    
    // Method to set severity of illness
    public void setSeverityOfIllness(int severityOfIllness) {
        this.severityOfIllness = severityOfIllness;
    }

}
