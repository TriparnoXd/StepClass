class Color {
    protected String name;

    public Color(String name) {
        this.name = name;
        System.out.println("Color constructor called.");
    }
}

class PrimaryColor extends Color {
    protected int intensity;

    public PrimaryColor(String name, int intensity) {
        super(name);
        this.intensity = intensity;
        System.out.println("PrimaryColor constructor called.");
    }
}

class RedColor extends PrimaryColor {
    protected String shade;

    public RedColor(String name, int intensity, String shade) {
        super(name, intensity);
        this.shade = shade;
        System.out.println("RedColor constructor called.");
    }

    public void displayProperties() {
        System.out.println("Color Name: " + this.name);
        System.out.println("Intensity: " + this.intensity);
        System.out.println("Shade: " + this.shade);
    }
}

public class Problem4 {
    public static void main(String[] args) {
        RedColor myRed = new RedColor("Red", 8, "Crimson");
        myRed.displayProperties();
    }
}