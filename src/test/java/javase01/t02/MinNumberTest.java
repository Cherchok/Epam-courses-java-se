package javase01.t02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinNumberTest {

    @Test
    void findMin1() {

        MinNumber nm = new MinNumber();

        int actual = nm.findMin(0.004);
        int expected = 15;

        assertEquals(expected,actual);
    }

    @Test
    void findMin2() {

        MinNumber nm = new MinNumber();

        int actual = nm.findMin(1);
        int expected = 0;

        assertEquals(expected,actual);
    }

    @Test
    void findMin3() {

        MinNumber nm = new MinNumber();

        int actual = nm.findMin(7);
        int expected = -1;

        assertEquals(expected,actual,"No such a number!!!");
    }
}