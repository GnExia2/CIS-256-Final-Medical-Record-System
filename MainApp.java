public class MainApp {
    public static void main(String[] args) {
        MedicalRecord recordSystem = new MedicalRecord();

        // Load initial data
        InitialDataLoader.loadInitialData(recordSystem);
        
        // Launch the UI
        MedicalRecordUI.launchUI(recordSystem);
    }
}
