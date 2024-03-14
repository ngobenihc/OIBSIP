package org.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.example.AuthenticateUsers.authenticateUser;
import static org.example.CreatePaper.createExam;
import static org.example.DisplayMenu.displayMainMenu;
import static org.example.ExamView.viewExamResults;
import static org.example.WriteExam.takeExam;


public class MainPage {
    static Map<String, UserInput> users = new HashMap<>();
    static List<Examination> exams = new ArrayList<>();
    static UserInput currentUser;

    public static void main(String[] args) {
        // hard coded data
        users.put("lecture", new UserInput("lecture", "Lecture@123", UserRole.LECTURE));
        users.put("student", new UserInput("student", "Student@123", UserRole.STUDENT));

        exams.add(new Examination("Java Basics Exam", 60));
        exams.get(0).addQuestion(new AnswerForShortQuestion("What does JVM stand for?", "Java Virtual Machine"));
        exams.get(0).addQuestion(new MultipleChoiceQuestion("Number of primitive data types in Java are?", List.of("8", "15", "14"), 1));
        exams.get(0).addQuestion(new MultipleChoiceQuestion("What is the size of float and double in java?", List.of("64 and 32", "32 and 64", "64 and 64"), 2));
        exams.get(0).addQuestion(new MultipleChoiceQuestion("What is Java?", List.of("A programming language", "A type of coffee", "An island in Indonesia"), 1));
        exams.get(0).addQuestion(new MultipleChoiceQuestion("Automatic type conversion is possible in which of the possible cases?", List.of("int to long", "int to bytes", "long to int"), 1));

        exams.add(new Examination("Math", 60));
        exams.get(1).addQuestion(new MultipleChoiceQuestion("The decimal expansion of 22/7  is", List.of("Terminating","Non-terminating and repeating","Non-terminating and Non-repeating"), 2));
        exams.get(1).addQuestion(new MultipleChoiceQuestion("For some integer n, the odd integer is represented in the form of", List.of("n","1 + n","2n + 1"), 3));
        exams.get(1).addQuestion(new MultipleChoiceQuestion("HCF of 26 and 91 is:", List.of("13", "15", "14"), 1));
        exams.get(1).addQuestion(new MultipleChoiceQuestion("Which of the following is not irrational?", List.of("(3 + √7) (3 – √7)", "(3 – √7)", "(3 + √7) (3 – √9)"), 1));
        exams.get(1).addQuestion(new MultipleChoiceQuestion("The addition of a rational number and an irrational number is equal to:", List.of("rational number", "Irrational number", "Both"), 2));

        exams.add(new Examination("Science", 60));
        exams.get(2).addQuestion(new MultipleChoiceQuestion("Which among the following is responsible for depletion of Ozone?", List.of("Carbon monoxide", "Carbon dioxide", "Chlorofluoro carbon"), 3));
        exams.get(2).addQuestion(new MultipleChoiceQuestion("Chronic exposure to which among the following minerals/ salts in groundwater may cause Black-Foot Disease?", List.of(" Nitrates","Arsenic"," Lead"), 2));
        exams.get(2).addQuestion(new MultipleChoiceQuestion("Which among the following is the smallest Human Chromosome?", List.of("Chromosome 21","Chromosome 20","Chromosome 22"), 1));
        exams.get(2).addQuestion(new MultipleChoiceQuestion("What is the property of matter by which a body tends to regain its original configuration after the removal of deforming force known as?", List.of("Ductility","Elasticity","Malleability"), 2));
        exams.get(2).addQuestion(new MultipleChoiceQuestion("Which of the following statements represent Hooke’s law?", List.of("Stress is directly proportional to strain", "Stress is inversely proportional to strain","Stress is equal to strain"), 1));


        Scanner scanner = new Scanner(System.in);


        currentUser = authenticateUser(scanner);


        while (true) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (currentUser.CampusRole == UserRole.STUDENT) {
                        takeExam(scanner);
                    } else {
                        createExam(scanner);
                    }
                    break;
                case 2:
                    viewExamResults();
                    break;
                case 3:
                    System.out.println("logout the System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}
