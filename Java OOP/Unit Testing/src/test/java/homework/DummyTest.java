package homework;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {
    private Dummy dummy;
    private Dummy deadDummy;

    @Before
    public void initializationObject() {
        this.dummy = new Dummy(100, 100);
        this.deadDummy = new Dummy(0, 100);

    }


    @Test
    public void dummyLoseHealthAfterAttack() {

        int givenAttack = 10;
        dummy.takeAttack(givenAttack);

        Assert.assertEquals(90, dummy.getHealth());
    }

    @Test
    public void deadDummyGiveExp() {
        this.dummy = new Dummy(0, 100);

        Assert.assertEquals(100, dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsWhenAttacked() {

        deadDummy.takeAttack(10);

    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyThrowsNoExp() {

        dummy.giveExperience();
    }

}