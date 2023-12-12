// Class to represent a doctor in the medical record system
public class Doctor {
    // Doctor attributes
    private String id;                   // Unique identifier for the doctor
    private String name;                 // Name of the doctor
    private String specialization;       // Specialization of the doctor

    // Constructor to initialize a new Doctor object
    public Doctor(String id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    // Getter method to retrieve the doctor's ID
    public String getId() {
        return id;
    }

    // Getter method to retrieve the doctor's name
    public String getName() {
        return name;
    }

    // Getter method to retrieve the doctor's specialization
    public String getSpecialization() {
        return specialization;
    }
}
