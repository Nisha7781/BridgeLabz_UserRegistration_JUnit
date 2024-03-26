package org.junit.user_registration;

import java.util.function.Predicate;

public class UserRegistration
{

    String FirstName;
    String LastName;
    String Email;
    String Number;
    String Password;

    UserRegistration(String FirstName, String LastName, String Email, String Number, String Password)
    {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.Number = Number;
        this.Password = Password;
    }

    interface Validator
    {
        boolean validate(String input);
    }

    public void validateEntry(String input, String fieldName, Validator validator) throws CustomValidationException
    {
        if (!validator.validate(input))
        {
            throw new CustomValidationException("Invalid " + fieldName);
        }
    }

    public void isValidFirstName() throws CustomValidationException
    {
        validateEntry(FirstName, "first name", str -> str.matches("^[A-Z][a-zA-Z]{2,}$"));
    }

    public void isValidLastName() throws CustomValidationException
    {
        validateEntry(LastName, "last name", str -> str.matches("^[A-Z][a-zA-Z]{2,}$"));
    }

    public void isValidEmail() throws CustomValidationException
    {
        validateEntry(Email, "email", str -> str.matches("^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[0-9a-zA-Z]+\\.[a-zA-Z]{2,4}+([.][a-zA-Z]{2,3})?$"));
    }

    public void isValidNumber() throws CustomValidationException
    {
        validateEntry(Number, "number", str -> str.matches("^([0-9]{2} [0-9]{10})$"));
    }

    public void isValidPassword() throws CustomValidationException
    {
        validateEntry(Password, "password", str -> str.matches("^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*?()'])([a-zA-Z0-9])(.{7,})$"));
    }

    public void isValidEntry() throws CustomValidationException {
        try {
            isValidFirstName();
            isValidLastName();
            isValidEmail();
            isValidNumber();
            isValidPassword();
        } catch (CustomValidationException e) {
            throw new CustomValidationException("Invalid entry");
        }
    }
}
