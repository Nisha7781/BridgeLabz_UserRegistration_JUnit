package org.junit.user_registration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {

    String FirstName;
    String LastName;
    String Email;
    String Number;
    String Password;

    UserRegistration(String FirstName, String LastName, String Email, String Number, String Password) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.Number = Number;
        this.Password = Password;
    }

    public void isValidFirstName() throws CustomValidationException {
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(FirstName);
        if (!matcher.matches()) {
            throw new CustomValidationException("Invalid first name");
        }
    }

    public void isValidLastName() throws CustomValidationException {
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(LastName);
        if (!matcher.matches()) {
            throw new CustomValidationException("Invalid last name");
        }
    }

    public void isValidEmail() throws CustomValidationException {
        String regex = "^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[0-9a-zA-Z]+\\.[a-zA-Z]{2,4}+([.][a-zA-Z]{2,3})?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Email);
        if (!matcher.matches()) {
            throw new CustomValidationException("Invalid email");
        }
    }


    public void isValidNumber() throws CustomValidationException {
        String regex = "^([0-9]{2} [0-9]{10})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Number);
        if (!matcher.matches()) {
            throw new CustomValidationException("Invalid number");
        }
    }

    public void isValidPassword() throws CustomValidationException {
        String regex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*?()'])([a-zA-Z0-9])(.{7,})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Password);
        if (!matcher.matches()) {
            throw new CustomValidationException("Invalid password");
        }
    }

    public String isValidEntry() throws CustomValidationException {
        try {
            isValidFirstName();
            isValidLastName();
            isValidEmail();
            isValidNumber();
            isValidPassword();
            return "HAPPY";
        } catch (Exception e) {
            throw new CustomValidationException("Invalid entry");
        }
    }

}
