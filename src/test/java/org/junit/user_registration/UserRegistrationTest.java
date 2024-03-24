package org.junit.user_registration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UserRegistrationTest {

    //Test for Firstname validity
    @Test
    void checkFirstname_returnHappy()
    {
        UserRegistration ur = new UserRegistration("Nisha","Mali","abc@gmail.com", "91 9182374657","abcdefgh");
        String res = ur.isValidFirstName();
        Assertions.assertEquals("HAPPY", res);
    }

    @Test
    void checkFirstname_returnSad1()
    {
        UserRegistration ur = new UserRegistration("nisha", "mali", "abc@gmail.com","9182374657", "abcdefgh");
        String res = ur.isValidFirstName();
        Assertions.assertEquals("SAD", res);
    }

    @Test
    void checkFirstname_returnSad2()
    {
        UserRegistration ur = new UserRegistration("ni", "Mali", "abc@gmail.com", "9182374657", "abcdefgh");
        String res = ur.isValidFirstName();
        Assertions.assertEquals("SAD", res);
    }

    //Test for Lastname validity
    @Test
    void checkLastname_returnHappy()
    {
        UserRegistration ur = new UserRegistration("Nisha","Mali","abc@gmail.com", "91 9182374657","abcdefgh");
        String res = ur.isValidLastName();
        Assertions.assertEquals("HAPPY", res);
    }

    @Test
    void checkLastname_returnSad1()
    {
        UserRegistration ur = new UserRegistration("Nisha", "mali", "abc@gmail.com","9182374657","abcdefgh");
        String res = ur.isValidLastName();
        Assertions.assertEquals("SAD", res);
    }

    @Test
    void checkLastname_returnSad2()
    {
        UserRegistration ur = new UserRegistration("Nisha", "Ma", "abc@gmail.com","9182374657","abcdefgh");
        String res = ur.isValidLastName();
        Assertions.assertEquals("SAD", res);
    }

    //Test for Mobile Number validity
    @Test
    void checkNumber_returnHappy()
    {
        UserRegistration ur = new UserRegistration("Nisha","Mali","abc@gmail.com", "91 9182374657", "abcdefgh");
        String res = ur.isValidNumber();
        Assertions.assertEquals("HAPPY", res);
    }

    @Test
    void checkNumber_returnSad1()
    {
        UserRegistration ur = new UserRegistration("Nisha", "mali", "avx.gmail.com","9182374657", "abcdefgh");
        String res = ur.isValidNumber();
        Assertions.assertEquals("SAD", res);
    }

    @Test
    void checkNumber_returnSad2()
    {
        UserRegistration ur = new UserRegistration("Nisha", "mali", "avx.gmail.com","91 82374657", "abcdefgh");
        String res = ur.isValidNumber();
        Assertions.assertEquals("SAD", res);
    }

    //Test to check Password Validity
    @Test
    void checkPassword_returnHappy()
    {
        UserRegistration ur = new UserRegistration("Nisha", "mali", "avx.gmail.com","91 82374657", "aBc@efgh1");
        String res = ur.isValidPassword();
        Assertions.assertEquals("HAPPY", res);
    }

    @Test
    void checkPassword_returnSad1()
    {
        UserRegistration ur = new UserRegistration("Nisha", "mali", "avx.gmail.com","91 82374657", "Ab1defgh");
        String res = ur.isValidPassword();
        Assertions.assertEquals("SAD", res);
    }

    @Test
    void checkPassword_returnSad2()
    {
        UserRegistration ur = new UserRegistration("Nisha", "mali", "avx.gmail.com","91 82374657", "Kab1cde");
        String res = ur.isValidPassword();
        Assertions.assertEquals("SAD", res);
    }

    @Test
    void checkPassword_returnSad3()
    {
        UserRegistration ur = new UserRegistration("Nisha", "mali", "avx.gmail.com","91 82374657", "Kab@1de");
        String res = ur.isValidPassword();
        Assertions.assertEquals("SAD", res);
    }

    // Test for Email validity
    @Test
    void checkEmail_returnHappy()
    {
        UserRegistration ur = new UserRegistration("Nisha", "Mali", "abc@gmail.com", "91 9182374657", "abcdefgh");
        String res = ur.isValidEmail();
        Assertions.assertEquals("HAPPY", res);
    }

    @Test
    void checkEmail_returnSad()
    {
        UserRegistration ur = new UserRegistration("Nisha", "Mali", "abcgmail.com", "91 9182374657", "abcdefgh");
        String res = ur.isValidEmail();
        Assertions.assertEquals("SAD", res);
    }

    @Test
    void checkValidEmails() {
        String[] validEmails = {"abc@yahoo.com", "abc-100@yahoo.com", "abc.100@yahoo.com",
                "abc111@abc.com", "abc-100@abc.net", "abc.100@abc.com.au",
                "abc@1.com", "abc@gmail.com.com", "abc+100@gmail.com"};

        for (String email : validEmails) {
            UserRegistration ur = new UserRegistration("Nisha", "Mali", email, "91 9182374657", "abcdefgh");
            String res = ur.isValidEmail();
            Assertions.assertEquals("HAPPY", res);
        }
    }

    @Test
    void checkInvalidEmails() {
        String[] invalidEmails = {"abc", "abc@.com.my", "abc123@gmail.a", "abc123@.com",
                "abc123@.com.com", ".abc@abc.com", "abc()*@gmail.com",
                "abc@%*.com", "abc..2002@gmail.com", "abc.@gmail.com",
                "abc@abc@gmail.com", "abc@gmail.com.1a", "abc@gmail.com.aa.au"};

        for (String email : invalidEmails) {
            UserRegistration ur = new UserRegistration("Nisha", "Mali", email, "91 9182374657", "abcdefgh");
            String res = ur.isValidEmail();
            Assertions.assertEquals("SAD", res);
        }
    }

    //Test For Valid Entry
    @Test
    void checkValidEntry() {
        UserRegistration ur = new UserRegistration("Nisha", "Mali", "abc@gmail.com", "91 9182374657", "aBc@efgh1");
        String res = ur.isValidEntry();
        Assertions.assertEquals("HAPPY", res);
    }

    @Test
    void checkInvalidEntry() {
        UserRegistration ur = new UserRegistration("Nisha", "Mali", "abc@gmail.com", "91 9182374657", "abcdefgh");
        String res = ur.isValidEntry();
        Assertions.assertEquals("SAD", res);
    }

    // Test for Email validity using Parameterized Test
    @ParameterizedTest
    @CsvSource({
            "abc@yahoo.com, HAPPY",
            "abc-100@yahoo.com, HAPPY",
            "abc.100@yahoo.com, HAPPY",
            "abc111@abc.com, HAPPY",
            "abc-100@abc.net, HAPPY",
            "abc.100@abc.com.au, HAPPY",
            "abc@1.com, HAPPY",
            "abc@gmail.com.com, HAPPY",
            "abc+100@gmail.com, HAPPY",
            "abc, SAD",
            "abc@.com.my, SAD",
            "abc123@gmail.a, SAD",
            "abc123@.com, SAD",
            "abc123@.com.com, SAD",
            ".abc@abc.com, SAD",
            "abc()*@gmail.com, SAD",
            "abc@%*.com, SAD",
            "abc..2002@gmail.com, SAD",
            "abc.@gmail.com, SAD",
            "abc@abc@gmail.com, SAD",
            "abc@gmail.com.1a, SAD",
            "abc@gmail.com.aa.au, SAD"
    })
    void checkEmailValidity(String email, String expected) {
        UserRegistration ur = new UserRegistration("Nisha", "Mali", email, "91 9182374657", "abcdefgh");
        String res = ur.isValidEmail();
        Assertions.assertEquals(expected, res);
    }
}

