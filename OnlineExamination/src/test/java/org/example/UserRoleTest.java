package org.example;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;


class UserInputTest {

    @Test
    void testUserInputInitialization() {
        // Arrange
        String userName = "ngobenihc";
        String passCode = "password123";
        UserRole userRole = UserRole.STUDENT;

        // Act
        UserInput userInput = new UserInput(userName, passCode, userRole);

        // Assert
        assertEquals(userName, userInput.userName);
        assertEquals(passCode, userInput.passCode);
        assertEquals(userRole, userInput.CampusRole);
    }

    @Test
    void testUserInputEquality() {
        // Arrange
        String userName1 = "hcngobeni";
        String passCode1 = "password123";
        UserRole userRole1 = UserRole.STUDENT;

        String userName2 = "clifton";
        String passCode2 = "password456";
        UserRole userRole2 = UserRole.LECTURE;

        // Act
        UserInput userInput1 = new UserInput(userName1, passCode1, userRole1);
        UserInput userInput2 = new UserInput(userName2, passCode2, userRole2);

        // Assert
        assertNotEquals(userInput1, userInput2);
    }

    @Test
    void testUserRoleEnum() {
        // Arrange
        UserRole studentRole = UserRole.STUDENT;
        UserRole lectureRole = UserRole.LECTURE;

        // Assert
        assertNotEquals(studentRole, lectureRole);
    }
}
