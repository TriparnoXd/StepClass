<<<<<<< HEAD
class Car {
    String brand;
    String model;
    double price;

    Car(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", model=" + model + ", price=" + price + "]";
    }}

public class car {
    public static void main(String[] args) {
        Car c1 = new Car("Toyota", "Corolla", 20000);
        Car c2 = new Car("Honda", "Civic", 22000);
        System.out.println(c1);
        System.out.println(c1.getClass().getName());
        System.out.println(c2);
        System.out.println(c2.getClass().getName());
=======
class Car {
    String brand;
    String model;
    double price;

    Car(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", model=" + model + ", price=" + price + "]";
    }}

public class car {
    public static void main(String[] args) {
        Car c1 = new Car("Toyota", "Corolla", 20000);
        Car c2 = new Car("Honda", "Civic", 22000);
        System.out.println(c1);
        System.out.println(c1.getClass().getName());
        System.out.println(c2);
        System.out.println(c2.getClass().getName());
>>>>>>> 6d63c2f52c06b2d053d3b67fb5bd230721991e48
    }}