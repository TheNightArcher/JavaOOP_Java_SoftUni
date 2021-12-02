package wildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] tokens = input.split("\\s+");
            Animal animal = findAnimal(tokens);

            String inputFood = scanner.nextLine();
            Food food = getFood(inputFood.split("\\s+"));

            animal.makeSound();

            try {
                animal.eat(food);
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }

            animals.add(animal);

            input = scanner.nextLine();
        }
        animals.forEach(System.out::println);
    }

    private static Food getFood(String[] tokens) {
        String type = tokens[0];
        int quantity = Integer.parseInt(tokens[1]);

        if (type.equals("Meat")){
            return new Met(quantity);
        }else {
            return new Vegetable(quantity);
        }
    }

    public static Animal findAnimal(String[] tokens) {
        String type = tokens[0];
        String name = tokens[1];
        double weight = Double.parseDouble(tokens[2]);
        String livingRegion = tokens[3];

        switch (type) {
            case "Mouse":
                return new Mouse(name, type, weight, livingRegion);
            case "Cat":
                String breed = tokens[4];
                return new Cat(name, type, weight, livingRegion, breed);
            case "Tiger":
                return new Tiger(name, type, weight, livingRegion);
            case "Zebra":
                return new Zebra(name, type, weight, livingRegion);
            default:
                throw new IllegalArgumentException("No such animal");
        }
    }
}
