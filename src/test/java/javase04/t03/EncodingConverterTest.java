package javase04.t03;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

class EncodingConverterTest {

    @Test
    void UTF8toUTF16() throws IOException {
        File in = new File("TextForEncodingConverter.txt");
        File out = new File("TextUTF16.txt");
        EncodingConverter converter = new EncodingConverter();
        converter.UTF8toUTF16(in, out);
    }
}