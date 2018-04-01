package javase04.t02;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class JavaKeyWordsS {
    private static int comments;
    private static int quotes;
    private static final String[] WORDS_LIST = new String[]{
            "abstract", "continue", "for", "new", "switch", "assert", "default", "goto*package", "synchronized",
            "boolean", "do", "if", "private", "this", "break", "double", "implements", "protected", "throw", "byte",
            "else", "import", "public", "throws", "case", "enum", "instanceof", "return", "transient", "catch",
            "extends", "int", "short", "try", "char", "final", "interface", "static", "void", "class", "finally",
            "long", "strictfp", "volatile", "const", "float", "native", "super", "while"
    };
    private static Map<String, KeyWordsCounterS> wordsInFile = new HashMap<>();

    @SuppressWarnings("Duplicates")
    public static void keyWordsResult(File fin, File out) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fin));
        while (bufferedReader.ready()) {
            String string = bufferedReader.readLine();
            String[] wordS = string.replaceAll("\\/\\/", " // ").
                    replaceAll("\\/\\*", " /* ").
                    replaceAll("\\*\\/", " */ ").split("[\\s|\\(|=|,|\\)|;]");
            for (String word : wordS) {
                if (word.contains("\\")) {
                    break;
                }
                if (word.length() > 0) {
                    if (comments > 0 || quotes > 0) {
                        if (comments > 0) {
                            commentsCounter(word);
                        } else {
                            if (word.length() > 1) {
                                if (word.charAt(word.length() - 1) == '"' &&
                                        word.charAt(word.length() - 2) == '\\') {
                                    quotes--;
                                } else if (word.charAt(word.length() - 1) == '"') {
                                    quotes--;
                                }
                            }
                        }
                    } else {
                        if (word.contains("*/")) {
                            commentsCounter(word);
                        } else {
                            if (word.charAt(0) == '"') {
                                quotes++;
                                if (word.length() > 1 && word.charAt(word.length() - 1) == '"') {
                                    quotes--;
                                }
                            } else {
                                for (String keyword : WORDS_LIST) {
                                    if (keyword.equals(word)) {
                                        if (wordsInFile.containsKey(keyword)) {
                                            wordsInFile.get(keyword).increment();
                                        } else {
                                            wordsInFile.put(keyword, new KeyWordsCounterS());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            FileWriter fileWriter = new FileWriter(out);
            for (String key : wordsInFile.keySet()) {
                fileWriter.write(key + " = " + wordsInFile.get(key).getCount() + "\n");
            }
            fileWriter.close();

        }

    }

    private static void commentsCounter(String string) {
        comments++;
        if (string.contains("/*")) {
            comments = 0;
        }
    }
}