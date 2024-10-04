package org.example.employtracker.util;

import java.util.regex.Pattern;

public class Validator {

    // Regular expressions for validation
    private static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final String PHONE_REGEX = "^[0-9]{10,15}$";
    private static final String NAME_REGEX = "^[a-zA-Z]+$";

    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    public static boolean isNotEmptySlr(Double value) {
        return value != null && value > 0;
    }

    public static boolean isValidEmail(String email) {
        return isNotEmpty(email) && Pattern.matches(EMAIL_REGEX, email);
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return isNotEmpty(phoneNumber) && Pattern.matches(PHONE_REGEX, phoneNumber);
    }

    public static boolean isValidSalary(Double salary) {
        if (!isNotEmptySlr(salary)) return false;
        return salary > 0;
    }

    public static boolean isValidName(String name) {
        return isNotEmpty(name) && Pattern.matches(NAME_REGEX, name);
    }

    public static String validateEmployeeInputs(String firstName, String lastName, String email,
                                                String phoneNumber, String department, Double salary) {
        StringBuilder errors = new StringBuilder();

        if (!isValidName(firstName)) {
            errors.append("First Name is required and must contain only letters.\n");
        }
        if (!isValidName(lastName)) {
            errors.append("Last Name is required and must contain only letters.\n");
        }
        if (!isValidEmail(email)) {
            errors.append("A valid Email is required.\n");
        }
        if (!isValidPhoneNumber(phoneNumber)) {
            errors.append("Phone Number is required and must be a valid number (10-15 digits).\n");
        }
        if (!isNotEmpty(department)) {
            errors.append("Department is required.\n");
        }
        if (!isValidSalary(salary)) {
            errors.append("Salary is required and must be a positive number.\n");
        }

        return errors.toString();
    }
}
