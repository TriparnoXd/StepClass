class Fruit {
    protected String color;
    protected String taste;

    public Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }

    public String getColor() {
        return color;
    }

    public String getTaste() {
        return taste;
    }
}

class Apple extends Fruit {
    private final String variety;

    public Apple(String color, String taste, String variety) {
        super(color, taste);
        this.variety = variety;
    }

    public String getVariety() {
        return variety;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        Apple myApple = new Apple("red", "sweet", "Gala");
        System.out.println("My apple's color is: " + myApple.getColor());
        System.out.println("My apple's taste is: " + myApple.getTaste());
        System.out.println("My apple's variety is: " + myApple.getVariety());
    }
}