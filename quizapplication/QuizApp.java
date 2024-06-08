package com.quizapplication;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApp {
    private static Question[] quizData;
    private static int score = 0;
    private static int currentQuestionIndex = 0;
    private static Timer timer;
    private static boolean timeUp = false;

    public static void main(String[] args) {

        quizData = new Question[]{
                new Question("Who wrote the play Romeo and Juliet?", new String[]{" William Wordsworth", "William Shakespeare", "Charles Dickens", " George Orwell"},1),
                new Question("What is the largest mammal in the world?", new String[]{"Elephant", "Blue Whale", "Great White Shark", "Giraffe"},1),
                new Question("Which element has the chemical symbol 'O'?", new String[]{" Oxygen", " Gold","Silver","Hydrogen"},0)
        };


        showQuestion();
    }

    private static void showQuestion() {
        if (currentQuestionIndex < quizData.length) {
            Question question = quizData[currentQuestionIndex];
            System.out.println("Question " + (currentQuestionIndex + 1) + ": " + question.getQuestionText());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }


            startTimer();

            // Get user's answer
            Scanner scanner = new Scanner(System.in);
            int answer = -1;
            while (answer < 1 || answer > options.length) {
                if (timeUp) {
                    System.out.println("Time's up!");
                    break;
                }
                System.out.print("Your answer (1-" + options.length + "): ");
                if (scanner.hasNextInt()) {
                    answer = scanner.nextInt();
                } else {
                    scanner.next();
                }
            }


            timer.cancel();


            if (answer - 1 == question.getCorrectAnswerIndex() && !timeUp) {
                score++;
            }

            currentQuestionIndex++;
            showQuestion();
        } else {
            showResults();
        }
    }

    private static void startTimer() {
        timer = new Timer();
        timeUp = false;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeUp = true;
            }
        }, 10000); // 10 seconds
    }

    private static void showResults() {
        System.out.println("Quiz Completed");
        System.out.println("Your score: " + score + "/" + quizData.length);
    }
}
