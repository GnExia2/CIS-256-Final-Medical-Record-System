import java.util.*;


public class MedicalRecordSystem {
    private Graph graph;
    private Set<String> medicalConditionsSet;
    private PriorityQueue<Appointment> appointmentQueue;
    private BTree medicalRecordsBTree;
    private PatientManager patientManager;

    // Constructor
    public MedicalRecordSystem() {
        this.graph = new Graph();
        this.medicalConditionsSet = new HashSet<>();
        this.appointmentQueue = new PriorityQueue<>();
        this.medicalRecordsBTree = new BTree();
        this.patientManager = new PatientManager(graph);    }

    // Method to add a patient to the system
    public void addPatient(Patient newPatient) {
        patientManager.addPatient(newPatient);
    }

    public PatientManager getPatientManager() {
        return patientManager;
    }

    // Method to add a relationship between two patients
    public void addRelationship(Patient patient1, Patient patient2) {
        graph.addEdge(patient1, patient2);
    }

    // Method to prioritize patients based on medical history length
    public void prioritizePatients() {
        Queue<Patient> priorityQueue = new PriorityQueue<>((p1, p2) ->
                Integer.compare(p2.getMedicalHistory().length(), p1.getMedicalHistory().length()));

        for (Patient patient : graph.getAllPatients()) {
            priorityQueue.add(patient);
        }

        // Display prioritized patients
        System.out.println("Prioritized Patients:");
        while (!priorityQueue.isEmpty()) {
            displayPatientInformation(priorityQueue.poll());
        }
    }

    // Method to optimize treatment plans for all patients
    public void optimizeTreatmentPlans() {
        for (Patient patient : graph.getAllPatients()) {
            int newAge = patient.getAge() + 1;
            patient.setMedicalHistory(patient.getMedicalHistory() + " Updated treatment plan for age " + newAge);
        }
    }

    // Method to integrate data structures (medical conditions set, appointment queue, B-tree)
    public void integrateDataStructures() {
        for (Patient patient : graph.getAllPatients()) {
            medicalConditionsSet.add(patient.getMedicalHistory());
            appointmentQueue.add(new Appointment(patient, "Next appointment"));
            medicalRecordsBTree.insert(patient);
        }
    }

    // Method to perform Dijkstra's algorithm
    public void dijkstraAlgorithm(Patient sourcePatient) {
        // Step 3: Initialize distances and previous nodes
        Map<Patient, Integer> distanceMap = new HashMap<>();
        Map<Patient, Patient> previousNodeMap = new HashMap<>();
        Set<Patient> visited = new HashSet<>();

        // Initialize distances to infinity (or a very large number)
        for (Patient patient : graph.getAllPatients()) {
            distanceMap.put(patient, Integer.MAX_VALUE);
            previousNodeMap.put(patient, null);
        }

        // Set distance to the source patient as 0
        distanceMap.put(sourcePatient, 0);

        // Step 4: Main Dijkstra's Algorithm Loop
        PriorityQueue<Patient> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(distanceMap::get));
        priorityQueue.add(sourcePatient);

        while (!priorityQueue.isEmpty()) {
            Patient currentPatient = priorityQueue.poll();
            visited.add(currentPatient);

            for (Patient neighbor : graph.getNeighbors(currentPatient)) {
                if (visited.contains(neighbor)) {
                    continue;  // Skip already visited neighbors
                }

                int newDistance = distanceMap.get(currentPatient) + getEdgeWeight(currentPatient, neighbor);

                if (newDistance < distanceMap.get(neighbor)) {
                    distanceMap.put(neighbor, newDistance);
                    previousNodeMap.put(neighbor, currentPatient);
                    priorityQueue.add(neighbor);
                }
            }
        }

        // Step 5: Retrieve Shortest Paths (optional)
        for (Patient destinationPatient : graph.getAllPatients()) {
            List<Patient> path = new ArrayList<>();
            Patient currentPatient = destinationPatient;

            while (currentPatient != null) {
                path.add(currentPatient);
                currentPatient = previousNodeMap.get(currentPatient);
            }

            Collections.reverse(path);
            // Now, 'path' contains the shortest path from source to destinationPatient
            System.out.println("Shortest path to " + destinationPatient.getName() + ": " + path);
        }
    }

    // Helper method to get edge weight between two patients based on severity of illness
    private int getEdgeWeight(Patient patient1, Patient patient2) {
        // Replace this with your actual implementation to get the weight of the edge
        // between patient1 and patient2 in the graph, considering severity of illness.
        // For example, you might use the absolute difference in severity as the weight.
        return Math.abs(patient1.getSeverityOfIllness() - patient2.getSeverityOfIllness());
    }

    // Getter methods for data structures
    public Set<String> getMedicalConditionsSet() {
        return medicalConditionsSet;
    }

    public PriorityQueue<Appointment> getAppointmentQueue() {
        return appointmentQueue;
    }

    public BTree getMedicalRecordsBTree() {
        return medicalRecordsBTree;
    }

    public Graph getGraph() {
        return graph;
    }

    // Helper method to display patient information
    private void displayPatientInformation(Patient patient) {
        System.out.println("Patient ID: " + patient.getPatientID());
        System.out.println("Name: " + patient.getName());
        System.out.println("Age: " + patient.getAge());
        System.out.println("Medical History: " + patient.getMedicalHistory());
        System.out.println("-------------");
    }

}
