public class OOPDemo {
    String application = "SauceDemo";

    void openApplication() {
        System.out.println("Opening " + application);
    }

    public static void main(String[] args) {

        OOPDemo demo = new OOPDemo();

        demo.openApplication();
    }
}
