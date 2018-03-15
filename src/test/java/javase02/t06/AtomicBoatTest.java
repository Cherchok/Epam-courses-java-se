package javase02.t06;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class AtomicBoatTest {

    @Test
    void runIntoSwimming1() {
        AtomicBoat atomicBoat = new AtomicBoat();

        Assert.assertEquals(false, atomicBoat.runIntoSwimming());

        System.out.println();
        System.out.println("After checking and starting: ");
        System.out.println();

        atomicBoat.readyToGo();
        Assert.assertEquals(true, atomicBoat.runIntoSwimming());

    }
}