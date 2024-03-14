package org.example;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


class DisplayMenuTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testDisplayMainMenuForStudent() {
        // Arrange
        MainPage.currentUser = new UserInput("Student", "student@123", UserRole.STUDENT);

        // Act
        DisplayMenu.displayMainMenu();

        // Assert
        String expectedOutput = "\nMain Menu:" +
                "\n1. Take Exam" +
                "\n2. View Exam Results" +
                "\n3. Exit" +
                "\nChoose an option: ";
        assertEquals(expectedOutput, outContent.toString().replaceAll("\\r\\n", "\n"));
    }

    @Test
    void testDisplayMainMenuForLecturer() {
        // Arrange
        MainPage.currentUser = new UserInput("Lecturer", "lecturer@123", UserRole.LECTURE);

        // Act
        DisplayMenu.displayMainMenu();

        // Assert
        String expectedOutput = "\nMain Menu:" +
                "\n1. Create Exam" +
                "\n2. View Exam Results" +
                "\n3. Exit" +
                "\nChoose an option: ";
        assertEquals(expectedOutput, outContent.toString().replaceAll("\\r\\n", "\n"));
    }
}
