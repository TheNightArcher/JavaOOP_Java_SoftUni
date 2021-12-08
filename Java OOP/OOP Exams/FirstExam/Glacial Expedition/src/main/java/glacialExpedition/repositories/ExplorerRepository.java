package glacialExpedition.repositories;

import glacialExpedition.models.explorers.Explorer;

import java.util.*;

public class ExplorerRepository implements Repository<Explorer> {

    private final List<Explorer> explorersStation;

    public ExplorerRepository() {
        this.explorersStation = new ArrayList<>();
    }

    @Override
    public Collection<Explorer> getCollection() {
        return explorersStation;
    }

    @Override
    public void add(Explorer entity) {
        explorersStation.add(entity);
    }

    @Override
    public boolean remove(Explorer entity) {
        if (explorersStation.contains(entity)) {
            explorersStation.remove(entity);
            return true;
        }
        return false;
    }

    @Override
    public Explorer byName(String name) {
        for (Explorer explorer : explorersStation) {
            if (explorer.getName().equals(name)) {
                return explorer;
            }
        }
        return null;
    }
}
