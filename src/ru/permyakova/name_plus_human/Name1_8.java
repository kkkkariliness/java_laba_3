package ru.permyakova.name_plus_human;

public class Name1_8 {
    private String firstName, lastName, patronymic;

    public Name1_8(String firstName, String lastName, String patronymic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }
    Name1_8(String firstName, String lastName) {
        this(firstName, lastName, null);
    }
    public Name1_8(String firstName) {
        this(firstName, null, null);
    }

    String getName() {
        return this.firstName;
    }
    String getLastName() {
        return this.lastName;
    }
    String getPatronymic() {
        return this.patronymic;
    }

    String setName(String name) {
        this.firstName = name;
        return this.firstName;
    }
    String setLastName(String lastname) {
        this.lastName = lastname;
        return this.lastName;
    }
    String setPatronymic(String patronymic) {
        this.patronymic = patronymic;
        return this.patronymic;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        if (firstName != null && !firstName.isEmpty()) {
            result.append(firstName).append(" ");
        }

        if (patronymic != null && !patronymic.isEmpty()) {
            result.append(patronymic).append(" ");
        }

        if (lastName != null && !lastName.isEmpty()) {
            result.append(lastName).append(" ");
        }

        return result.toString().trim();
    }
}