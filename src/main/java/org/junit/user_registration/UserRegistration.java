package org.junit.user_registration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {

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


    public String isValidFirstName()
    {
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(FirstName);
        if (matcher.matches())
        {
            return "HAPPY";
        }
        else
        {
            return "SAD";
        }
    }

    public String isValidLastName()
    {
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(LastName);
        if (matcher.matches())
        {
            return "HAPPY";
        }
        else
        {
            return "SAD";
        }
    }

    public String isValidEmail()
    {
        String regex = "^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[0-9a-zA-Z]+.[a-zA-Z]{2,4}+([.][a-zA-Z]{2,3})?$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Email);
        if (matcher.matches())
        {
            return "HAPPY";
        }
        else
        {
            return "SAD";
        }
    }

    public String isValidNumber()
    {
        String regex = "^([0-9]{2} [0-9]{10})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Number);
        if (matcher.matches())
        {
            return "HAPPY";
        }
        else
        {
            return "SAD";
        }
    }

    public String isValidPassword()
    {
        String regex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*?()'])([a-zA-Z0-9])(.{7,})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Password);
        if (matcher.matches())
        {
            return "HAPPY";
        }
        else
        {
            return "SAD";
        }
    }

    public String isValidEntry()
    {
        if (isValidFirstName().equals("HAPPY") && isValidLastName().equals("HAPPY") && isValidEmail().equals("HAPPY")
                && isValidNumber().equals("HAPPY") && isValidPassword().equals("HAPPY"))
        {
            return "HAPPY";
        }
        else
        {
            return "SAD";
        }
    }

}