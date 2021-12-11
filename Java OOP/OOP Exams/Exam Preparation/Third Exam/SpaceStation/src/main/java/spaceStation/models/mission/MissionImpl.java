package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.Collection;

public class MissionImpl implements Mission {
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {

        Collection<String> planets = planet.getItems();

        for (Astronaut astronaut : astronauts) {

            while (astronaut.canBreath() && planets.iterator().hasNext()){

                astronaut.breath();
                String currentItem = planets.iterator().next();
                astronaut.getBag().getItems().add(currentItem);
                planets.remove(currentItem);
            }
        }
    }
}
