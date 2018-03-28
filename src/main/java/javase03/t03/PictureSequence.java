package javase03.t03;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PictureSequence {
    private static final Pattern REGEX = Pattern.compile(
            "<img[^.]*src=\"./Новая фундаментальная физика \\(Статья А.Н. Ховалкина\\)_files/pic(\\d+).jpg\".*[^.]*>");

    private String textInFile;
    private ArrayList<Integer> pictureIndex = new ArrayList<>();


     PictureSequence() {
        readFile();
        takePicturesFromFile();

    }

    public boolean isOrdered() {
        if (pictureIndex.size() >= 1) {
            for (int i = 0; i < pictureIndex.size() - 1; i++) {
                if (pictureIndex.get(i) < pictureIndex.get(i + 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    private void readFile() {
        BufferedReader bufferedReader;
        try {
            Reader file = new InputStreamReader(new FileInputStream(
                    "Java.SE.03.Information handling_task_attachment.html"),
                    "Cp1251");
            bufferedReader = new BufferedReader(file);
            StringBuilder sb = new StringBuilder();
            bufferedReader.lines().forEach(s -> sb.append(s).append("\n"));
            textInFile = sb.toString();
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void takePicturesFromFile() {
        Matcher matcher = REGEX.matcher(textInFile);
        while (matcher.find()) {
            pictureIndex.add(Integer.parseInt(matcher.group(1)));
        }
        System.out.println("");
    }

}
