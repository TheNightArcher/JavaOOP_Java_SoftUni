package catHouse.core;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private final ToyRepository toyRepository;
    public Collection<House> houses;

    public ControllerImpl() {
        this.toyRepository = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;

        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
            case "LongHouse":
                house = new LongHouse(name);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_HOUSE_TYPE);
        }

        houses.add(house);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;

        switch (type) {
            case "Ball":
                toy = new Ball();
                break;
            case "Mouse":
                toy = new Mouse();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_TOY_TYPE);
        }

        toyRepository.buyToy(toy);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {

        if (toyRepository.findFirst(toyType) == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_TOY_FOUND, toyType));
        }
        Toy desiredToy = toyRepository.findFirst(toyType);

        for (House house : houses) {
            if (house.getName().equals(houseName)) {
                house.buyToy(desiredToy);
                toyRepository.removeToy(desiredToy);
            }
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;

        switch (catType) {
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);

                for (House house : houses) {
                    if (house.getName().equals(houseName)) {
                        if (house.getClass().getSimpleName().equals("ShortHouse")) {

                            house.addCat(cat);
                            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
                        }
                    }
                }
                break;
            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);

                for (House house : houses) {
                    if (house.getName().equals(houseName)) {
                        if (house.getClass().getSimpleName().equals("LongHouse")) {

                            house.addCat(cat);
                            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
                        }
                    }
                }
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_CAT_TYPE);
        }

        return ConstantMessages.UNSUITABLE_HOUSE;
    }

    @Override
    public String feedingCat(String houseName) {

        for (House house : houses) {
            if (house.getName().equals(houseName)) {
                house.feeding();
                return String.format(ConstantMessages.FEEDING_CAT, house.getCats().size());
            }
        }
    //    houses.stream().filter(h -> h.getName().equals(houseName)).forEach(h -> h.getCats().forEach(Cat::eating));
        return "House is not found";
    }

    @Override
    public String sumOfAll(String houseName) {


        double catsBoughtPrice = 0;

        for (House house : houses) {
            if (house.getName().equals(houseName)) {

                catsBoughtPrice += house.getCats().stream().mapToDouble(Cat::getPrice).sum();
            }
        }

        double toysBoughtPrice = 0;

        for (House house : houses) {
            if (house.getName().equals(houseName)) {

                toysBoughtPrice += house.getToys().stream().mapToDouble(Toy::getPrice).sum();
            }
        }

        double sum = catsBoughtPrice + toysBoughtPrice;

        return String.format(ConstantMessages.VALUE_HOUSE, houseName, sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        int counter = 0;
        for (House house : houses) {
            if (counter == 0) {

                sb.append(house.getStatistics());
            } else {
                sb.append(System.lineSeparator()).append(house.getStatistics());
            }

            counter++;
        }

        return sb.toString();
    }
}
