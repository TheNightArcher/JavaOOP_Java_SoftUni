package homework;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {

    Axe axe;
    Dummy dummy;

    @Before
    public void setUp() {
        this.axe = new Axe(10, 0);
        this.dummy = new Dummy(100, 50);
    }

    @Test
    public void givenAxeLoseDurabilityAfterAttack() {

        //Arrange
        axe = new Axe(10, 10);

        //Act
        axe.attack(dummy);

        //Assert
        Assert.assertEquals(9, axe.getDurabilityPoints());

    }

    @Test(expected = IllegalStateException.class)
    public void brokenAxeHasZeroDurability() {

        axe.attack(dummy);

        Assert.assertEquals(0, axe.getDurabilityPoints());
    }
}