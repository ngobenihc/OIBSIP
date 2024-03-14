package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticateUsersTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @BeforeEach
    void setUp() {
        MainPage.users = new HashMap<>();
    }

    @Test
    void testAuthenticateUserSuccessful() {
        // Arrange
        UserInput validUser = new UserInput("ValidUser", "ValidPassword",null);
        MainPage.users.put("ValidUser", validUser);

        String input = "ValidUser\nValidPassword\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Act
        Scanner scanner = new Scanner(System.in);
        UserInput authenticatedUser = AuthenticateUsers.authenticateUser(scanner);

        // Assert
        assertNotNull(authenticatedUser);
        assertEquals(validUser, authenticatedUser);
    }

    @Test
    void testAuthenticateUserInvalidCredentials() {
        // Arrange
        UserInput validUser = new UserInput("ValidUser", "ValidPassword",null);
        MainPage.users.put("ValidUser", validUser);

        String input = "InvalidUser\nInvalidPassword\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Act
        Scanner scanner = new Scanner(System.in);
        //UserInput authenticatedUser = AuthenticateUsers.authenticateUser(scanner);

        // Assert
       // assertNull(authenticatedUser);
    }
}
