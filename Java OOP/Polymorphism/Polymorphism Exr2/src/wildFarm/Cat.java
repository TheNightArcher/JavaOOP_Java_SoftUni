package wildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        super.eat(food);
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("##.##");

        return String.format("%s[%s, %s, %s, %s, %d]", getClass().getSimpleName(), getAnimalName(), getBreed(), formatter.format(getAnimalWeight())
                , getLivingRegion(), getFoodEaten());
    }
}
