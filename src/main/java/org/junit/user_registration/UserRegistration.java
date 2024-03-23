package org.junit.user_registration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {

    String FirstName;
    String LastName;
    String Email;


    UserRegistration(String FirstName, String LastName, String Email)
    {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;

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

    public String isValidEmail() {
        String regex = "^([a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})$";
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
}