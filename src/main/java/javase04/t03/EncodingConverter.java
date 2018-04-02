package javase04.t03;

import java.io.*;

public class EncodingConverter {

    public void UTF8toUTF16(File fin, File fout) throws IOException {
        BufferedReader brIn = new BufferedReader(new InputStreamReader(
                new FileInputStream(fin), "UTF-8"));

        BufferedWriter bwOut = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fout), "UTF-16"));
        while (brIn.ready()) {
            bwOut.write(brIn.readLine());
        }
        bwOut.close();
    }
}
