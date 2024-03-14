package org.example;

import static org.example.MainPage.currentUser;
import static org.example.MainPage.exams;

public class ExamView {

    static void viewExamResults() {
        if (currentUser.CampusRole == UserRole.STUDENT) {
            System.out.println("\nYour Exam Results:");
            // In a real system, you would fetch and display the results of the current user.
        } else {
            System.out.println("\nTeacher View: Exam Results");
            for (Examination exam : exams) {
                System.out.println("\nExam: " + exam.title);
                // In a real system, you would fetch and display results for each student.
            }
        }
    }
}
