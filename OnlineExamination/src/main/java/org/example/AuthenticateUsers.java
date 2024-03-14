package org.example;

import java.util.Scanner;
import static org.example.MainPage.users;

public class AuthenticateUsers {
    static UserInput authenticateUser(Scanner scanner) {
        while (true) {
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            UserInput user = users.get(username);
            if (user != null && user.passCode.equals(password)) {
                System.out.println("Authentication successful. Welcome, " + user.userName + "!");
                return user;
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }
    }
}
