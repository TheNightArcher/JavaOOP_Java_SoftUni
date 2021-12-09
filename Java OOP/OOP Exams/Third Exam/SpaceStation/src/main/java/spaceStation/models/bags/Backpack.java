package spaceStation.models.bags;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Backpack implements Bag {

    private final List<String> bags;

    public Backpack() {
        this.bags = new ArrayList<>();
    }

    @Override
    public Collection<String> getItems() {
        return bags;
    }
}
