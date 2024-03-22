package org.junit.user_registration;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {

    public static boolean isValidFirstName(String name)
    {
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String firstName = sc.nextLine();

        if (isValidFirstName(firstName))
        {
            System.out.println("Valid First Name");
        }
        else
        {
            System.out.println("Invalid First Name");
        }
    }
}