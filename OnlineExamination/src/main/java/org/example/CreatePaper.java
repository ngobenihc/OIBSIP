package org.example;


import java.util.List;
import java.util.Scanner;
import static org.example.MainPage.exams;

public class CreatePaper {

    static void createExam(Scanner scanner) {
        System.out.print("Enter the moduleCode of the new exam: ");
        String moduleCode = scanner.nextLine();
        System.out.print("Enter the duration of the new exam (in minutes): ");
        int duration = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Examination newExam = new Examination(moduleCode, duration);

        while (true) {
            System.out.println("\nAdd Questions to the Exam:");
            System.out.println("1. Multiple Choice Question");
            System.out.println("2. Short Question");
            System.out.println("3. Finish Exam Creation");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the question of your papers for multiple questions: ");
                    String mcqText = scanner.nextLine();
                    System.out.println("Enter the options(answers) (comma-separated): ");
                    List<String> mcqOptions = List.of(scanner.nextLine().split(","));
                    System.out.print("Enter the correct option number: ");
                    int correctOption = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    newExam.addQuestion(new MultipleChoiceQuestion(mcqText, mcqOptions, correctOption));
                    break;
                case 2:
                    System.out.print("Enter the question for short questions: ");
                    String saqText = scanner.nextLine();
                    System.out.print("Enter the correct answer: ");
                    String correctAnswer = scanner.nextLine();

                    newExam.addQuestion(new AnswerForShortQuestion(saqText, correctAnswer));
                    break;
                case 3:
                    exams.add(newExam);
                    System.out.println("Exam creation completed.");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}
