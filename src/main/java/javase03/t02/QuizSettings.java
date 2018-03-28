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
        switch (lang) {
            case "ru":
                questionsResource = ResourceBundle.getBundle("questions", new Locale("ru"));
                answersResources = ResourceBundle.getBundle("answers", new Locale("ru"));
                break;
            case "en":
                questionsResource = ResourceBundle.getBundle("questions", new Locale("en"));
                answersResources = ResourceBundle.getBundle("answers", new Locale("en"));
                break;
            default:
                throw new UnsupportedLanguageException("Enter ru / en only");
        }
    }

    public ResourceBundle getQuestionsResource() {
        return questionsResource;
    }

    public ResourceBundle getAnswersResources() {
        return answersResources;
    }
}

