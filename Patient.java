public class Patient {
    private String id;
    private String name;
    private String medicalCondition;
    private int severityLevel;

    public Patient(String id, String name, String medicalCondition, int severityLevel) {
        this.id = id;
        this.name = name;
        this.medicalCondition = medicalCondition;
        this.severityLevel = severityLevel;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public int getSeverityLevel() {
        return severityLevel;
    }
}
