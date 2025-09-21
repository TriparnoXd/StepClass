class Box {
    public void pack() {
        System.out.println("Packing the box.");
    }

    public void unpack() {
        System.out.println("Unpacking the box.");
    }
}

class GiftBox extends Box {
    @Override
    public void pack() {
        super.pack();
        System.out.println("Adding a ribbon and a card to the gift box.");
    }

    @Override
    public void unpack() {
        super.unpack();
        System.out.println("Opening the ribbon and revealing the gift.");
    }
}

public class Problem6 {
    public static void main(String[] args) {
        GiftBox myGiftBox = new GiftBox();
        myGiftBox.pack();
        System.out.println();
        myGiftBox.unpack();
    }
}