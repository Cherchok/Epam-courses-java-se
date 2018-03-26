package javase03.t02;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

@SuppressWarnings("WeakerAccess")
public class QuizSettings {
    private ResourceBundle questionsResource;
    private ResourceBundle answersResources;


    QuizSettings() {
        System.out.print("Enter language ru / en: ");
        Scanner scanner = new Scanner(System.in);
        String lang = scanner.nextLine();
        if (lang.equals("ru")) {
            questionsResource = ResourceBundle.getBundle("questions", new Locale("ru"));
            answersResources = ResourceBundle.getBundle("answers", new Locale("ru"));
        }
        if (lang.equals("en")) {
            questionsResource = ResourceBundle.getBundle("questions", new Locale("en"));
            answersResources = ResourceBundle.getBundle("answers", new Locale("en"));
        }
    }

    public ResourceBundle getQuestionsResource() {
        return questionsResource;
    }

    public ResourceBundle getAnswersResources() {
        return answersResources;
    }
}

