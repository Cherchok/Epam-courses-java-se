package javase02.t02;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ChancerySellerTest {


    @Test
    void countItemPrice() {
        ChancerySeller seller = new ChancerySeller("Oleg");

        seller.setItem("Pen");
        seller.setItem("Eraser");
        seller.setItem("Pencil");
        double expectedPrice = 49.60;
        double actualPrice = seller.countItemPrice();

        Assert.assertEquals(expectedPrice,actualPrice,0.0);
    }
}