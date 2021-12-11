package aquarium.core;

import aquarium.common.ConstantMessages;
import aquarium.common.ExceptionMessages;
import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;


public class ControllerImpl implements Controller {

    private DecorationRepository decorationRepository;
    private Collection<Aquarium> aquarium;

    public ControllerImpl() {
        this.decorationRepository = new DecorationRepository();
        this.aquarium = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;

        switch (aquariumType) {
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                break;
            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_AQUARIUM_TYPE);
        }

        this.aquarium.add(aquarium);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;
        switch (type) {
            case "Ornament":
                decoration = new Ornament();
                break;
            case "Plant":
                decoration = new Plant();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_DECORATION_TYPE);
        }
        decorationRepository.add(decoration);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {

        Aquarium foundAquarium = this.aquarium.stream()
                .filter(aquarium -> aquarium.getName().equals(aquariumName))
                .findFirst()
                .orElse(null);
        Decoration foundDecoration = this.decorationRepository.findByType(decorationType);
        if (foundDecoration == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_DECORATION_FOUND, decorationType));
        }
        assert foundAquarium != null;
        foundAquarium.addDecoration(foundDecoration);
        this.decorationRepository.remove(foundDecoration);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;
        switch (fishType) {
            case "FreshwaterFish":
                fish = new FreshwaterFish(fishName, fishSpecies, price);

                for (Aquarium aquarium1 : aquarium) {
                    if (aquarium1.getName().equals(aquariumName)) {
                        if (aquarium1.getClass().getSimpleName().startsWith("Fresh")) {
                            aquarium1.addFish(fish);
                            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
                        }
                    }
                }
                break;
            case "SaltwaterFish":
                fish = new SaltwaterFish(fishName, fishSpecies, price);

                for (Aquarium aquarium1 : aquarium) {
                    if (aquarium1.getName().equals(aquariumName)) {
                        if (aquarium1.getClass().getSimpleName().startsWith("Salt")) {
                            aquarium1.addFish(fish);
                            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
                        }
                    }
                }
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_FISH_TYPE);
        }
        return "Water not suitable.";
    }

    @Override
    public String feedFish(String aquariumName) {

        for (Aquarium aquarium1 : aquarium) {
            if (aquarium1.getName().equals(aquariumName)) {
                aquarium1.feed();

                return String.format(ConstantMessages.FISH_FED, aquarium1.getFish().size());
            }
        }
        return null;
    }

    @Override
    public String calculateValue(String aquariumName) {

        double sumForDecoration = 0;
        for (Aquarium currentAqua : aquarium) {
            if (currentAqua.getName().equals(aquariumName)) {

                sumForDecoration += currentAqua.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
            }
        }

        double sumForFish = 0;
        for (Aquarium currentAqua : aquarium) {
            if (currentAqua.getName().equals(aquariumName)) {

                sumForFish += currentAqua.getFish().stream().mapToDouble(Fish::getPrice).sum();
            }
        }

        double totalSum = sumForDecoration + sumForFish;

        return String.format(ConstantMessages.VALUE_AQUARIUM, aquariumName, totalSum);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        for (Aquarium aquarium1 : aquarium) {
            sb.append(aquarium1.getInfo());
        }
        return sb.toString();
    }
}
