<<<<<<< HEAD
interface Notifier {
    void send(String message);
}

public class Service {
    public void triggerAlert() {
        Notifier notifier = new Notifier() {
            @Override
            public void send(String message) {
                System.out.println("Alert: " + message);
            }
        };

        notifier.send("Server CPU usage is high!");
    }

    public static void main(String[] args) {
        new Service().triggerAlert();
    }
=======
interface Notifier {
    void send(String message);
}

public class Service {
    public void triggerAlert() {
        Notifier notifier = new Notifier() {
            @Override
            public void send(String message) {
                System.out.println("Alert: " + message);
            }
        };

        notifier.send("Server CPU usage is high!");
    }

    public static void main(String[] args) {
        new Service().triggerAlert();
    }
>>>>>>> 6d63c2f52c06b2d053d3b67fb5bd230721991e48
}