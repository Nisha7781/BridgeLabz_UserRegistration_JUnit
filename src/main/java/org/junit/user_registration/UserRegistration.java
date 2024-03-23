package org.junit.user_registration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {

    String FirstName;
    String LastName;



    UserRegistration(String FirstName, String LastName)
    {
        this.FirstName = FirstName;
        this.LastName = LastName;

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
}