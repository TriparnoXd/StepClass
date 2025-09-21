class Instrument {
    protected String name;
    protected String material;

    public Instrument(String name, String material) {
        this.name = name;
        this.material = material;
    }

    public void play() {
        System.out.println("The " + name + " made of " + material + " is being played.");
    }
}

class Piano extends Instrument {
    private final int numberOfKeys;

    public Piano(String name, String material, int numberOfKeys) {
        super(name, material);
        this.numberOfKeys = numberOfKeys;
    }

    @Override
    public void play() {
        System.out.println("The " + name + " with " + numberOfKeys + " keys is playing a melody.");
    }
}

class Guitar extends Instrument {
    private final int numberOfStrings;

    public Guitar(String name, String material, int numberOfStrings) {
        super(name, material);
        this.numberOfStrings = numberOfStrings;
    }

    @Override
    public void play() {
        System.out.println("The " + name + " with " + numberOfStrings + " strings is strumming a chord.");
    }
}

class Drum extends Instrument {
    private final String drumType;

    public Drum(String name, String material, String drumType) {
        super(name, material);
        this.drumType = drumType;
    }

    @Override
    public void play() {
        System.out.println("The " + name + " of type " + drumType + " is being hit.");
    }
}

public class Problem5 {
    public static void main(String[] args) {
        Instrument[] band = new Instrument[3];
        band[0] = new Piano("Grand Piano", "Wood", 88);
        band[1] = new Guitar("Acoustic Guitar", "Mahogany", 6);
        band[2] = new Drum("Snare Drum", "Steel", "Percussion");

        for (Instrument instrument : band) {
            instrument.play();
        }
    }
}