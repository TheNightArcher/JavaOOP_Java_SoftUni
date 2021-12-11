package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlanetRepository implements Repository<Planet> {
    private final List<Planet> planetsRepo;

    public PlanetRepository() {
        this.planetsRepo = new ArrayList<>();
    }

    @Override

    public Collection<Planet> getModels() {
        return planetsRepo;
    }

    @Override
    public void add(Planet model) {
        planetsRepo.add(model);
    }

    @Override
    public boolean remove(Planet model) {
        for (Planet planet : planetsRepo) {
            if (planet == model) {
                planetsRepo.remove(model);
                return true;
            }
        }
        return false;
    }

    @Override
    public Planet findByName(String name) {
        for (Planet planet : planetsRepo) {
            if (planet.getName().equals(name)) {
                return planet;
            }
        }
        return null;
    }
}
