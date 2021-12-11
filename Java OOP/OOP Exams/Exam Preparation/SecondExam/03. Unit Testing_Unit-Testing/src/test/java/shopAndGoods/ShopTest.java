package shopAndGoods;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ShopTest {

    private Shop shop;
    private Goods items;

    @Before
    public void SetUp() {
        shop = new Shop();
        items = new Goods("Armor", "0313");
    }

    @Test
    public void testShouldAddGoods() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", items);
    }

    @Test
    public void testAddGoodsShouldReturnCorrectMessageOnAddition() throws OperationNotSupportedException {
        Goods goods = new Goods("test_good", "test_code");
        String expected = "Goods: test_code is placed successfully!";
        String actual = shop.addGoods("Shelves1", goods);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testShouldThrowIfGoodsExist() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowIfAddShelfIfDontExist() throws OperationNotSupportedException {
        shop.addGoods("invalid_Self", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowIfShelfTaken() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", items);
        shop.addGoods("Shelves1", items);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowIfRemoveShelfIfDontExist() throws OperationNotSupportedException {
        shop.removeGoods("Shelves13", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowIfRemovedGoodsExist() throws OperationNotSupportedException {
        shop.removeGoods("Shelves1", new Goods("Invalid_Goods", "2321321"));
    }

    @Test
    public void testRemoveGoodsShouldReturnCorrectMessage() throws OperationNotSupportedException {
        Goods goods = new Goods("test_good", "test_code");
        shop.addGoods("Shelves1", goods);
        String expected = "Goods: test_code is removed successfully!";
        String actual = shop.removeGoods("Shelves1", goods);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testShouldThrowIfWeTryToModifiedCollection() {
        shop.getShelves().clear();
    }

    @Test
    public void testRemoveGoodsShouldSetTheShelveValueToNull() throws OperationNotSupportedException {
        Goods goods = new Goods("test_good", "test_code");
        shop.addGoods("Shelves1", goods);
        shop.removeGoods("Shelves1", goods);

        Goods emptySlot = shop.getShelves().get("Shelves1");

        Assert.assertNull(emptySlot);
    }
}