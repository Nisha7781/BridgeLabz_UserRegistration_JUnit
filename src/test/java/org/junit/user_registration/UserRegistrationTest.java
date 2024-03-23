package org.junit.user_registration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserRegistrationTest {

    //Test for Firstname validity
    @Test
    void checkFirstname_returnHappy()
    {
        UserRegistration ur = new UserRegistration("Nisha","Mali","abc@gmail.com");
        String res = ur.isValidFirstName();
        Assertions.assertEquals("HAPPY", res);
    }

    @Test
    void checkFirstname_returnSad1()
    {
        UserRegistration ur = new UserRegistration("nisha", "Mali", "abc@gmail.com");
        String res = ur.isValidFirstName();
        Assertions.assertEquals("SAD", res);
    }

    @Test
    void checkFirstname_returnSad2()
    {
        UserRegistration ur = new UserRegistration("ni", "Mali", "abc@gmail.com");
        String res = ur.isValidFirstName();
        Assertions.assertEquals("SAD", res);
    }

    //Test for Lastname validity
    @Test
    void checkLastname_returnHappy()
    {
        UserRegistration ur = new UserRegistration("Nisha", "Mali", "abc@gmail.com");
        String res = ur.isValidLastName();
        Assertions.assertEquals("HAPPY", res);
    }

    @Test
    void checkLastname_returnSad1()
    {
        UserRegistration ur = new UserRegistration("Nisha", "mali", "abc@gmail.com");
        String res = ur.isValidLastName();
        Assertions.assertEquals("SAD", res);
    }

    @Test
    void checkLastname_returnSad2()
    {
        UserRegistration ur = new UserRegistration("Nisha", "Ma", "abc@gmail.com");
        String res = ur.isValidLastName();
        Assertions.assertEquals("SAD", res);
    }

    //Test for Email validity
    @Test
    void checkEmail_returnHappy()
    {
        UserRegistration ur = new UserRegistration("Nisha", "Mali", "abc@gmail.com");
        String res = ur.isValidEmail();
        Assertions.assertEquals("HAPPY", res);
    }

    @Test
    void checkEmail_returnSad()
    {
        UserRegistration ur = new UserRegistration("Nisha", "mali", "avx.gmail.com");
        String res = ur.isValidEmail();
        Assertions.assertEquals("SAD", res);
    }
    
}