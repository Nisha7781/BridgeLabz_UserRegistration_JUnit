package org.junit.user_registration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {

    String FirstName;

    UserRegistration(String FirstName)
    {
        this.FirstName = FirstName;

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
}