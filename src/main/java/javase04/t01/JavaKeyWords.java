package javase04.t01;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JavaKeyWords {
    private int comments;
    private int quotes;
    private static final String[] WORDS_LIST = new String[]{
            "abstract", "continue", "for", "new", "switch", "assert", "default", "goto*package", "synchronized",
            "boolean", "do", "if", "private", "this", "break", "double", "implements", "protected", "throw", "byte",
            "else", "import", "public", "throws", "case", "enum", "instanceof", "return", "transient", "catch",
            "extends", "int", "short", "try", "char", "final", "interface", "static", "void", "class", "finally",
            "long", "strictfp", "volatile", "const", "float", "native", "super", "while"
    };
    private Map<String, KeyWordsCounter> wordsInFile = new HashMap<>();

    public void wordSplitter(File fin, File out) throws IOException {

    }

    private static void parseWord(String[] word) {
        if (word.length >= 0) {
            for (int i = 0; i < word.length; i++) {
                if (word[i].contains("\\")) {
                    break;
                }
                if (word[i].length() > 0) {

                }
            }
        }

    }


    private void commmentsCounter(String string) {
        comments++;
        if (string.contains("/*")) {
            comments = 0;
        }

    }

}
