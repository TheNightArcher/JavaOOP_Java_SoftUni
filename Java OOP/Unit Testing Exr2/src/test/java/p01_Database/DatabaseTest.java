package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private static final Integer[] NUMBERS = {1, 2, 3, 4, 5, 6};

    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorShouldCreateValidDatabase() throws OperationNotSupportedException {
        database = new Database(NUMBERS);

        Integer[] dbElements = database.getElements();

        Assert.assertEquals(NUMBERS.length, dbElements.length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowExceptionIfLengthIsMoreThen16Elements() throws OperationNotSupportedException {
        Integer[] elementsMoreThen16 = new Integer[17];
        new Database(elementsMoreThen16);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowExceptionIfLengthIsLessThen1Elements() throws OperationNotSupportedException {
        Integer[] elementsLessThen1 = new Integer[0];
        new Database(elementsLessThen1);
    }

    @Test
    public void testAddMethod() throws OperationNotSupportedException {
        Integer number = 7;
        database.add(number);
        Integer[] extendedDatabase = database.getElements();

        Assert.assertEquals(NUMBERS.length + 1, database.getElements().length);
        Assert.assertEquals(Integer.valueOf(7), extendedDatabase[extendedDatabase.length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddMethodShouldThrowExceptionIfYouAddNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testRemoveMethodShouldReturnLastElement() throws OperationNotSupportedException {
        Integer[] elements = database.getElements();
        Integer lastElementRemoved = elements.length -1;

        Assert.assertEquals(Integer.valueOf(5),lastElementRemoved);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveMethodShouldThrowExceptionIfDatabaseIsEmpty() throws OperationNotSupportedException {
        for (Integer number : NUMBERS) {
            database.remove();
        }
        database.remove();
    }
}