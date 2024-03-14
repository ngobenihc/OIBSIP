package org.example;
import static org.example.MainPage.currentUser;

public class DisplayMenu {

    static void displayMainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. " + (currentUser.CampusRole == UserRole.STUDENT ? "Take Exam" : "Create Exam"));
        System.out.println("2. View Exam Results");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }
}
