package org.example;

public class UserInput
{
    String userName;
    String passCode;
    UserRole CampusRole;

    UserInput(String userName, String passCode, UserRole CampusRole) {
        this.userName = userName;
        this.passCode = passCode;
        this.CampusRole = CampusRole;
    }
}

enum UserRole {
    STUDENT,
    LECTURE
}