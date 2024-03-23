package org.junit.user_registration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserRegistrationTest {

    //Test for Firstname validity
    @Test
    void checkFirstname_returnHappy()
    {
        UserRegistration ur = new UserRegistration("Nisha","Mali","abc@gmail.com", "91 9182374657");
        String res = ur.isValidFirstName();
        Assertions.assertEquals("HAPPY", res);
    }

    @Test
    void checkFirstname_returnSad1()
    {
        UserRegistration ur = new UserRegistration("nisha", "mali", "abc@gmail.com","9182374657");
        String res = ur.isValidFirstName();
        Assertions.assertEquals("SAD", res);
    }

    @Test
    void checkFirstname_returnSad2()
    {
        UserRegistration ur = new UserRegistration("ni", "Mali", "abc@gmail.com", "9182374657");
        String res = ur.isValidFirstName();
        Assertions.assertEquals("SAD", res);
    }

    //Test for Lastname validity
    @Test
    void checkLastname_returnHappy()
    {
        UserRegistration ur = new UserRegistration("Nisha","Mali","abc@gmail.com", "91 9182374657");
        String res = ur.isValidLastName();
        Assertions.assertEquals("HAPPY", res);
    }

    @Test
    void checkLastname_returnSad1()
    {
        UserRegistration ur = new UserRegistration("Nisha", "mali", "abc@gmail.com","9182374657");
        String res = ur.isValidLastName();
        Assertions.assertEquals("SAD", res);
    }

    @Test
    void checkLastname_returnSad2()
    {
        UserRegistration ur = new UserRegistration("Nisha", "Ma", "abc@gmail.com","9182374657");
        String res = ur.isValidLastName();
        Assertions.assertEquals("SAD", res);
    }

    //Test for Email validity
    @Test
    void checkEmail_returnHappy()
    {
        UserRegistration ur = new UserRegistration("Nisha","Mali","abc@gmail.com", "91 9182374657");
        String res = ur.isValidEmail();
        Assertions.assertEquals("HAPPY", res);
    }

    @Test
    void checkEmail_returnSad()
    {
        UserRegistration ur = new UserRegistration("Nisha", "mali", "avx.gmail.com","9182374657");
        String res = ur.isValidEmail();
        Assertions.assertEquals("SAD", res);
    }

    //Test for Mobile Number validity
    @Test
    void checkNumber_returnHappy()
    {
        UserRegistration ur = new UserRegistration("Nisha","Mali","abc@gmail.com", "91 9182374657");
        String res = ur.isValidNumber();
        Assertions.assertEquals("HAPPY", res);
    }

    @Test
    void checkNumber_returnSad1()
    {
        UserRegistration ur = new UserRegistration("Nisha", "mali", "avx.gmail.com","9182374657");
        String res = ur.isValidNumber();
        Assertions.assertEquals("SAD", res);
    }

    @Test
    void checkNumber_returnSad2()
    {
        UserRegistration ur = new UserRegistration("Nisha", "mali", "avx.gmail.com","91 82374657");
        String res = ur.isValidNumber();
        Assertions.assertEquals("SAD", res);
    }
}