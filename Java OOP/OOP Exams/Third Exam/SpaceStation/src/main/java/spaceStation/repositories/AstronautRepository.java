package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AstronautRepository implements Repository<Astronaut> {

   private final List<Astronaut> astronautsRepo;

    public AstronautRepository() {
        this.astronautsRepo = new ArrayList<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
        return astronautsRepo;
    }

    @Override
    public void add(Astronaut model) {
        astronautsRepo.add(model);
    }

    @Override
    public boolean remove(Astronaut model) {
        for (Astronaut astronaut : astronautsRepo) {
            if (astronaut == model) {
                astronautsRepo.remove(model);
                return true;
            }
        }
        return false;
    }

    @Override
    public Astronaut findByName(String name) {
        for (Astronaut astronaut : astronautsRepo) {
            if (astronaut.getName().equals(name)) {
                return astronaut;
            }
        }
        return null;
    }
}
