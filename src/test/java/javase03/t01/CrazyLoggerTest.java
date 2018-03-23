package javase03.t01;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class CrazyLoggerTest {

    @Test
    void addMessage() {
        CrazyLogger crazyLogger = new CrazyLogger();
        crazyLogger.addMessage("Java");

        Assert.assertTrue(crazyLogger.toString().contains("Java"));

    }

    @Test
    void getFirstMessage() {
        CrazyLogger crazyLogger = new CrazyLogger();
        crazyLogger.addMessage("Java 7");
        crazyLogger.addMessage("Java 2");
        crazyLogger.addMessage("Java 3");
        crazyLogger.addMessage("Java 4");
        crazyLogger.addMessage("Java 5");

        Assert.assertTrue(crazyLogger.getFirstMessage("Java").contains("Java 7"));
    }

    @Test
    void getLastMessage() {
        CrazyLogger crazyLogger = new CrazyLogger();
        crazyLogger.addMessage("Java 1");
        crazyLogger.addMessage("Java 2");
        crazyLogger.addMessage("Java 3");
        crazyLogger.addMessage("Java 4");
        crazyLogger.addMessage("Java 8");

        Assert.assertTrue(crazyLogger.getLastMessage("Java").contains("Java 8"));
    }

    @Test
    void getAllMessage() {
        CrazyLogger crazyLogger = new CrazyLogger();
        crazyLogger.addMessage("hello");
        crazyLogger.addMessage("Ruby");
        crazyLogger.addMessage("java");
        crazyLogger.addMessage("python");
        crazyLogger.addMessage("C++");
        crazyLogger.addMessage("C#");
        crazyLogger.addMessage("C");
        crazyLogger.addMessage("Kotlin");

        crazyLogger.getAllMessage();
    }
}