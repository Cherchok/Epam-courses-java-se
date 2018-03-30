package javase04.t01;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;


class JavaKeyWordsTest {

    @Test
    void keyWordsResult() throws IOException {

        File fileIn = new File("codeIn.txt");
        File fileOut = new File("keyWordsResult.txt");
        JavaKeyWords.keyWordsResult(fileIn, fileOut);
    }
}