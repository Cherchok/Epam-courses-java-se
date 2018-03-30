package javase04.t01;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JavaKeyWords {
    private static int comments;
    private static int quotes;
    private static final String[] WORDS_LIST = new String[]{
            "abstract", "continue", "for", "new", "switch", "assert", "default", "goto*package", "synchronized",
            "boolean", "do", "if", "private", "this", "break", "double", "implements", "protected", "throw", "byte",
            "else", "import", "public", "throws", "case", "enum", "instanceof", "return", "transient", "catch",
            "extends", "int", "short", "try", "char", "final", "interface", "static", "void", "class", "finally",
            "long", "strictfp", "volatile", "const", "float", "native", "super", "while"
    };
    private static Map<String, KeyWordsCounter> wordsInFile = new HashMap<>();

    public void wordSplitter(File fin, File out) throws IOException {

    }

    private static void parseWord(String[] word) {
        for (String aWord : word) {
            if (aWord.contains("\\")) {
                break;
            }
            if (aWord.length() > 0) {
                if (comments > 0 || quotes > 0) {
                    if (comments > 0) {
                        commentsCounter(aWord);
                    } else {
                        if (aWord.length() > 1) {
                            if (aWord.charAt(aWord.length() - 1) == '"' &&
                                    aWord.charAt(aWord.length() - 2) == '\\') {
                                quotes--;
                            } else if (aWord.charAt(aWord.length() - 1) == '"') {
                                quotes--;
                            }
                        }
                    }
                } else {
                    if (aWord.contains("*/")) {
                        commentsCounter(aWord);
                    } else {
                        if (aWord.charAt(0) == '"') {
                            quotes++;
                            if (aWord.length() > 1 && aWord.charAt(aWord.length() - 1) == '"') {
                                quotes--;
                            }
                        } else {
                            for (String keyword : WORDS_LIST) {
                                if (keyword.equals(aWord)) {
                                    if (wordsInFile.containsKey(keyword)) {
                                        wordsInFile.get(keyword).increment();
                                    } else {
                                        wordsInFile.put(keyword, new KeyWordsCounter());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    private static void commentsCounter(String string) {
        comments++;
        if (string.contains("/*")) {
            comments = 0;
        }

    }



}
