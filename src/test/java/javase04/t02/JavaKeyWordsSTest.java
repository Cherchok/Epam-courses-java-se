package javase04.t02;

import javase04.t01.JavaKeyWords;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JavaKeyWordsSTest {

    @Test
    void keyWordsResult() throws IOException {
        File fileIn = new File("codeForS.txt");
        File fileOut = new File("keyWordsResultS.txt");

        JavaKeyWords.keyWordsResult(fileIn, fileOut);

    }
}