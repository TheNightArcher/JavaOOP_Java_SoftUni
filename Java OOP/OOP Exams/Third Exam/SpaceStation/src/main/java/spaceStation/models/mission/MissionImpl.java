package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.Collection;

public class MissionImpl implements Mission {
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {

        Collection<String> planets = planet.getItems();

        for (Astronaut astronaut : astronauts) {

            for (String items : planets) {

                if (astronaut.getOxygen() > 0) {

                    astronaut.getBag().getItems().add(items);
                    planet.getItems().remove(items);
                    astronaut.breath();
                } else {
                    break;
                }
            }
        }
    }
}
