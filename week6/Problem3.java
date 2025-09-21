class Bird {
    public void fly() {
        System.out.println("The bird is flying.");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        System.out.println("Penguins cannot fly, they can only waddle and swim.");
    }
}

class Eagle extends Bird {
    @Override
    public void fly() {
        System.out.println("The eagle soars high in the sky.");
    }
}

public class Problem3 {
    public static void main(String[] args) {
        Bird[] birds = new Bird[3];
        birds[0] = new Bird();
        birds[1] = new Penguin();
        birds[2] = new Eagle();

        for (Bird bird : birds) {
            bird.fly();
        }
    }
}