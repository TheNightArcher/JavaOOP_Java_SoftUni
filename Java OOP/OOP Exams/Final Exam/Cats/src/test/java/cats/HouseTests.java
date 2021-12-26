package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTests {

    private House house;
    private Cat cat;

    @Before
    public void setUp() {
        this.cat = new Cat("Zozo");
    }

    @Test
    public void testShouldReturnConstructorCorrectly() {
        house = new House("Koko", 10);
    }

    @Test
    public void testShouldGetName() {
        house = new House("Koko", 10);

        Assert.assertEquals("Koko", house.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testShouldThrowExceptionIfNameIsBlank() {
        house = new House(" ", 10);
        house = new House(null, 10);

    }

    @Test
    public void testShouldReturnCapacity() {
        house = new House("Koko", 10);

        Assert.assertEquals(10, house.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowIfWeSetNegativeNumberForCapacity() {
        house = new House(" ", -10);

    }

    @Test
    public void testShouldReturnCatCount() {
        house = new House("Koko", 10);

        Assert.assertEquals(0, house.getCount());

        house.addCat(cat);
        Assert.assertEquals(1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowIfWeTryToAddCatInFullCapacity(){
        house = new House("Koko", 1);
        house.addCat(cat);
        house.addCat(cat);
    }

    @Test
    public void testShouldRemoveCat() {
        house = new House("Koko", 10);

        house.addCat(cat);
        house.removeCat(cat.getName());

        Assert.assertEquals(0, house.getCount());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowIfRemoveCatNotExist() {
        house = new House("Koko", 10);

        house.addCat(cat);
        house.removeCat(cat.getName());
        house.removeCat(cat.getName());
    }

    @Test
    public void testShouldSellCat() {
        house = new House("Koko", 10);

        house.addCat(cat);
        Assert.assertEquals(cat, house.catForSale(cat.getName()));
    }

    @Test
    public void testShouldSellCatAndSetItFalse() {
        house = new House("Koko", 10);

        house.addCat(cat);
        house.catForSale(cat.getName());

        Assert.assertFalse(cat.isHungry());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowIfSellCatNotExist() {
        house = new House("Koko", 10);

        house.catForSale("Nana");

    }

    @Test
    public void testShouldReturnStatistic() {
        house = new House("Koko", 10);

        house.addCat(cat);

        String expected = String.format("The cat %s is in the house %s!", cat.getName(), house.getName());
        Assert.assertEquals(expected, house.statistics());
    }

}
