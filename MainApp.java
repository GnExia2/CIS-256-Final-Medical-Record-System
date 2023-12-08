public class MainApp {
    public static void main(String[] args) {
        MedicalRecord recordSystem = new MedicalRecord();

        // Load initial data
        InitialDataLoader.loadInitialData(recordSystem);

        // Apply Dijkstra's algorithm from a specific patient
        DijkstraAlgorithm.findShortestPaths(recordSystem, "P1");

        // Launch the UI
        MedicalRecordUI.launchUI(recordSystem);
    }
}
