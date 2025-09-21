class Phone {
    protected String brand;
    protected String model;

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
        System.out.println("Phone constructor called.");
    }
}

class SmartPhone extends Phone {
    private final String operatingSystem;

    public SmartPhone(String brand, String model, String operatingSystem) {
        super(brand, model);
        this.operatingSystem = operatingSystem;
        System.out.println("SmartPhone constructor called.");
    }

    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Operating System: " + operatingSystem);
    }
}

public class Problem2 {
    public static void main(String[] args) {
        SmartPhone mySmartPhone = new SmartPhone("Samsung", "Galaxy S21", "Android");
        mySmartPhone.displayDetails();
    }
}