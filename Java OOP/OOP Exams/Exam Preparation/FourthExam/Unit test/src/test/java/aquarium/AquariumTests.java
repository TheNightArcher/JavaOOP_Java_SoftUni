package aquarium;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AquariumTests {

    private Aquarium aquarium;

    private Fish fish;

    @Before
    public void setUp() {
        fish = new Fish("Nuga");
    }

    @Test
    public void testConstructorShouldReturnCorrectInput() {
        aquarium = new Aquarium("Zozo", 10);
    }

    @Test(expected = NullPointerException.class)
    public void testShouldThrowException() {
        aquarium = new Aquarium(" ", 10);

    }

    @Test
    public void testShouldReturnCorrectCapacity() {
        aquarium = new Aquarium("Zozo", 10);

        Assert.assertEquals(10, aquarium.getCapacity());
    }

    @Test
    public void testShouldReturnCorrectName() {
        aquarium = new Aquarium("Zozo", 10);

        Assert.assertEquals("Zozo", aquarium.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionIncorrectCapacity() {
        aquarium = new Aquarium("Zozo", -10);

    }

    @Test
    public void testShouldReturnCount() {
        aquarium = new Aquarium("Zozo", 10);
        aquarium.add(new Fish("Nuga"));

        Assert.assertEquals(1, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionIfCapacityIsFull() {
        aquarium = new Aquarium("Zozo", 1);

        aquarium.add(new Fish("Nuga"));
        aquarium.add(new Fish("Nuga"));
    }

    @Test
    public void testShouldRemoveFish() {
        aquarium = new Aquarium("Zozo", 10);
        aquarium.add(fish);
        aquarium.remove(fish.getName());

        Assert.assertEquals(0, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionIfFishNotExist() {
        aquarium = new Aquarium("Zozo", 1);

        aquarium.add(fish);
        aquarium.remove(fish.getName());
        aquarium.remove(fish.getName());
    }

    @Test
    public void testShouldSellFish() {
        aquarium = new Aquarium("Zozo", 10);
        aquarium.add(fish);
        aquarium.sellFish(fish.getName());


        Assert.assertEquals(fish,aquarium.sellFish(fish.getName()));
        Assert.assertFalse(fish.isAvailable());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionIfFishNotExistForSell() {
        aquarium = new Aquarium("Zozo", 1);

        aquarium.sellFish(fish.getName());
    }

    @Test
    public void testShouldReport() {
        aquarium = new Aquarium("Zozo", 10);
        aquarium.add(fish);

        String expected = "Fish available at Zozo: Nuga";

        Assert.assertEquals(expected,aquarium.report());
    }
}

