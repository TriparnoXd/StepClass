<<<<<<< HEAD
class Product {
    int productId;
    String productName;

    Product(int productId, String productName) {
        this.productId = productId;
        this.productName = productName; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product other = (Product) obj;
        return this.productId == other.productId;
    }}
public class Main {
    public static void main(String[] args) {
        Product p1 = new Product(1, "Laptop");
        Product p2 = new Product(1, "Laptop");
        Product p3 = p1;
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));
        System.out.println(p1 == p3);
        System.out.println(p1.equals(p3));
=======
class Product {
    int productId;
    String productName;

    Product(int productId, String productName) {
        this.productId = productId;
        this.productName = productName; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product other = (Product) obj;
        return this.productId == other.productId;
    }}
public class Main {
    public static void main(String[] args) {
        Product p1 = new Product(1, "Laptop");
        Product p2 = new Product(1, "Laptop");
        Product p3 = p1;
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));
        System.out.println(p1 == p3);
        System.out.println(p1.equals(p3));
>>>>>>> 6d63c2f52c06b2d053d3b67fb5bd230721991e48
    }}