package javase07.t02;

import javase07.t02.SyncPropReader;
import org.junit.jupiter.api.Test;

import java.io.File;

class SyncPropReaderTest {

    @Test
    void runTest() {
        File file = new File("/Users/cherchok/IdeaProjects/se01/src/main/resources/m5t2/file.properties");
        Thread thread1 = new Thread(new SyncPropReader(file));
        Thread thread2 = new Thread(new SyncPropReader(file));
        Thread thread3 = new Thread(new SyncPropReader(file));
        thread1.start();
        thread2.start();
        thread3.start();
    }
}