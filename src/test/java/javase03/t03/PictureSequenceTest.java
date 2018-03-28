package javase03.t03;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PictureSequenceTest {

    @Test
    void isOrdered() {

        PictureSequence pictureSequence = new PictureSequence();
        Assert.assertTrue(pictureSequence.isOrdered());
    }
}