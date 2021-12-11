package farmville;

import org.junit.Assert;
import org.junit.Test;

public class FarmvilleTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Farm

    private Farm farm;
    private final Animal cow = new Animal("Zozo", 2.0);
    private final Animal horse = new Animal("Enzo", 2.0);
    private Animal rabbit;

    @Test
    public void testConstructorShouldCreateFarm() {
        String name = "Cow Farm";
        int capacity = 5;

        Farm farm = new Farm(name, capacity);

        Assert.assertEquals(name, farm.getName());
        Assert.assertEquals(capacity, farm.getCapacity());
    }

    @Test(expected = NullPointerException.class)
    public void testShouldThrowIfNameIsNull() {

        farm = new Farm(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void testShouldThrowIfNameIsBlank() {

        farm = new Farm(" ", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowIfCapacityIsLessThenZero() {

        farm = new Farm("Bull Farm", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowIfCapacityMoreThenFull() {

        farm = new Farm("Bull Farm", 1);
        farm.add(cow);
        farm.add(horse);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowIfAnimalExist() {

        farm = new Farm("Bull Farm", 2);
        farm.add(cow);
        farm.add(cow);
    }

    @Test
    public void testShouldGetCountOfAnimals() {
        farm = new Farm("Cow", 5);
        farm.add(cow);

        Assert.assertEquals(1, farm.getCount());
    }

    @Test
    public void testShouldRemoveAnimal() {
        farm = new Farm("Cow", 5);
        farm.add(horse);
        String type = "Enzo";

        Assert.assertTrue(farm.remove(type));
    }

    @Test
    public void testShouldThrowFalseIfAnimalDoseNotExits() {
        farm = new Farm("Cow", 5);
        String type = "Enzo";

        Assert.assertFalse(farm.remove(type));
    }


}
