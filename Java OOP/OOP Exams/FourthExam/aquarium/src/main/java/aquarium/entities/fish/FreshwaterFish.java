package aquarium.entities.fish;

public class FreshwaterFish extends BaseFish {
    private static final int SIZE = 3;

    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
    }

    @Override
    public void setSize(int size) {
        super.setSize(SIZE);
    }

    @Override
    public void eat() {
        super.setSize(super.getSize() + 3);
    }
}
