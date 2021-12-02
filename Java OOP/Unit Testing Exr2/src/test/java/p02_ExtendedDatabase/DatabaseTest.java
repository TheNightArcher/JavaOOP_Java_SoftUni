package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private static final Person[] PERSON_INFO = new Person[]{
            new Person(0, "Galin")
            , new Person(3, "Kaloqn")
            , new Person(4, "Lilya")
    };
    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(PERSON_INFO);

    }

    @Test
    public void testConstructorShouldCreateValidData() throws OperationNotSupportedException {
        database = new Database(PERSON_INFO);

        Person[] peoples = database.getElements();

        Assert.assertArrayEquals(PERSON_INFO, peoples);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowExceptionIfLengthIsMoreThen16Elements() throws OperationNotSupportedException {
        Person[] elementsMoreThen16 = new Person[17];

        new Database(elementsMoreThen16);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddMethodShouldThrowExceptionIfSameIDIsPresent() throws OperationNotSupportedException {
        Person fakeID = new Person(0, "Galin");

        database.add(fakeID);
    }

}