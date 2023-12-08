public class MainApp {
    public static void main(String[] args) {
        MedicalRecordSystem recordSystem = new MedicalRecordSystem();

        // Load initial data
        InitialDataLoader.loadInitialData(recordSystem);

        // Launch the UI
        MedicalRecordUI.launchUI(recordSystem);
    }
}
