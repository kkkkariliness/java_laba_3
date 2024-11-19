package ru.permyakova.name_plus_human;

public class Name1_7 {
    private final String firstName, lastName, patronymic;

    public Name1_7(String firstName, String lastName, String patronymic) {
        if ((firstName == null || firstName.isEmpty()) && (lastName == null || lastName.isEmpty()) && (patronymic == null || patronymic.isEmpty())) {
            throw new IllegalArgumentException("Хотя бы один параметр должен быть не null и не пустой строкой!");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }
    public Name1_7(String firstName, String lastName) {
        this(firstName, lastName, null);
    }
    public Name1_7(String firstName) {
        this(firstName, null, null);
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPatronymic() {
        return patronymic;
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
