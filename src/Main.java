public class Main {
    public static void main(String[] args) {
        WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager();
        manager.loadFile();
        manager.loadConsultationDataFromFile();
        manager.menu();
    }
}
