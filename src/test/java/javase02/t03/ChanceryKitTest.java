package javase02.t03;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceryKitTest {

    @Test
    void kitPrice() {
        ChanceryKit chanceryKit = new ChanceryKit();
        double actual = chanceryKit.kitPrice();
        double expected = 315.4;
        Assert.assertEquals(expected,actual, 0);

    }

    @Test
    void showItems() {
        ChanceryKit chanceryKit = new ChanceryKit();
        chanceryKit.showItems();
    }
}