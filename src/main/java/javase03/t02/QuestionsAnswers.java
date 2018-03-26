package javase03.t02;

import java.util.Scanner;

public class QuestionsAnswers extends QuizSettings {
    private String question;
    private String correctAnswer;

    QuestionsAnswers() {
        System.out.print("Enter question number: ");
        Scanner scanner = new Scanner(System.in);
        String questionNumber = scanner.nextLine();
        question = super.getQuestionsResource().getString(questionNumber);
        correctAnswer = super.getAnswersResources().getString(questionNumber);
    }

    public void getQuestion() {
        System.out.println();
        if (super.getAnswersResources().getLocale().toString().equals("ru")) {
            System.out.println("Вопрос: " + question);
        } else {
            System.out.println("Question: " + question);
        }
    }

    public void setAnswer() {
        System.out.println();
        if (super.getAnswersResources().getLocale().toString().equals("ru")) {
            System.out.println("Запишите ответ прописными буквами");
        } else {
            System.out.println("Write the answer by the small letters");
        }

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        System.out.println(answer.equals(correctAnswer));

        if (!answer.equals(correctAnswer)) {
            if (super.getAnswersResources().getLocale().toString().equals("ru")) {
                System.out.println("Правильный ответ: " + correctAnswer);
            } else {
                System.out.println("Correct answer is : " + correctAnswer);
            }
        }
    }

}
