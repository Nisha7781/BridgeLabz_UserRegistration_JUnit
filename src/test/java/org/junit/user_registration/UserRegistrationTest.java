package org.junit.user_registration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UserRegistrationTest {

    // Test for Firstname validity
    @Test
    void checkFirstname_returnHappy() {
        UserRegistration ur = new UserRegistration("Nisha","Mali","abc@gmail.com", "91 9182374657","abcdefgh");
        try {
            ur.isValidFirstName();
        } catch (CustomValidationException e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    void checkFirstname_returnSad1() {
        UserRegistration ur = new UserRegistration("nisha", "mali", "abc@gmail.com","9182374657", "abcdefgh");
        try {
            ur.isValidFirstName();
            Assertions.fail("Expected CustomValidationException was not thrown");
        } catch (CustomValidationException e) {
            Assertions.assertEquals("Invalid first name", e.getMessage());
        }
    }

    @Test
    void checkFirstname_returnSad2() {
        UserRegistration ur = new UserRegistration("ni", "Mali", "abc@gmail.com", "9182374657", "abcdefgh");
        try {
            ur.isValidFirstName();
            Assertions.fail("Expected CustomValidationException was not thrown");
        } catch (CustomValidationException e) {
            Assertions.assertEquals("Invalid first name", e.getMessage());
        }
    }

    // Test for Lastname validity
    @Test
    void checkLastname_returnHappy() {
        UserRegistration ur = new UserRegistration("Nisha","Mali","abc@gmail.com", "91 9182374657","abcdefgh");
        try {
            ur.isValidLastName();
        } catch (CustomValidationException e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    void checkLastname_returnSad1() {
        UserRegistration ur = new UserRegistration("Nisha", "mali", "abc@gmail.com","9182374657","abcdefgh");
        try {
            ur.isValidLastName();
            Assertions.fail("Expected CustomValidationException was not thrown");
        } catch (CustomValidationException e) {
            Assertions.assertEquals("Invalid last name", e.getMessage());
        }
    }

    @Test
    void checkLastname_returnSad2() {
        UserRegistration ur = new UserRegistration("Nisha", "Ma", "abc@gmail.com","9182374657","abcdefgh");
        try {
            ur.isValidLastName();
            Assertions.fail("Expected CustomValidationException was not thrown");
        } catch (CustomValidationException e) {
            Assertions.assertEquals("Invalid last name", e.getMessage());
        }
    }

    // Test for Mobile Number validity
    @Test
    void checkNumber_returnHappy() {
        UserRegistration ur = new UserRegistration("Nisha","Mali","abc@gmail.com", "91 9182374657","abcdefgh");
        try {
            ur.isValidNumber();
        } catch (CustomValidationException e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    void checkNumber_returnSad1() {
        UserRegistration ur = new UserRegistration("Nisha", "mali", "avx.gmail.com","9182374657", "abcdefgh");
        try {
            ur.isValidNumber();
            Assertions.fail("Expected CustomValidationException was not thrown");
        } catch (CustomValidationException e) {
            Assertions.assertEquals("Invalid number", e.getMessage());
        }
    }

    @Test
    void checkNumber_returnSad2() {
        UserRegistration ur = new UserRegistration("Nisha", "mali", "avx.gmail.com","91 82374657", "abcdefgh");
        try {
            ur.isValidNumber();
            Assertions.fail("Expected CustomValidationException was not thrown");
        } catch (CustomValidationException e) {
            Assertions.assertEquals("Invalid number", e.getMessage());
        }
    }

    // Test to check Password Validity
    @Test
    void checkPassword_returnHappy() {
        UserRegistration ur = new UserRegistration("Nisha", "mali", "avx.gmail.com","91 82374657", "aBc@efgh1");
        try {
            ur.isValidPassword();
        } catch (CustomValidationException e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    void checkPassword_returnSad1() {
        UserRegistration ur = new UserRegistration("Nisha", "mali", "avx.gmail.com","91 82374657", "Ab1defgh");
        try {
            ur.isValidPassword();
            Assertions.fail("Expected CustomValidationException was not thrown");
        } catch (CustomValidationException e) {
            Assertions.assertEquals("Invalid password", e.getMessage());
        }
    }

    @Test
    void checkPassword_returnSad2() {
        UserRegistration ur = new UserRegistration("Nisha", "mali", "avx.gmail.com","91 82374657", "Kab1cde");
        try {
            ur.isValidPassword();
            Assertions.fail("Expected CustomValidationException was not thrown");
        } catch (CustomValidationException e) {
            Assertions.assertEquals("Invalid password", e.getMessage());
        }
    }

    @Test
    void checkPassword_returnSad3() {
        UserRegistration ur = new UserRegistration("Nisha", "mali", "avx.gmail.com","91 82374657", "Kab@1de");
        try {
            ur.isValidPassword();
            Assertions.fail("Expected CustomValidationException was not thrown");
        } catch (CustomValidationException e) {
            Assertions.assertEquals("Invalid password", e.getMessage());
        }
    }

    // Test for Email validity
    @Test
    void checkEmail_returnHappy() {
        UserRegistration ur = new UserRegistration("Nisha", "Mali", "abc@gmail.com", "91 9182374657", "abcdefgh");
        try {
            ur.isValidEmail();
        } catch (CustomValidationException e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    void checkEmail_returnSad() {
        UserRegistration ur = new UserRegistration("Nisha", "Mali", "abcgmail.com", "91 9182374657", "abcdefgh");
        try {
            ur.isValidEmail();
            Assertions.fail("Expected CustomValidationException was not thrown");
        } catch (CustomValidationException e) {
            Assertions.assertEquals("Invalid email", e.getMessage());
        }
    }

    @Test
    void checkValidEmails() {
        String[] validEmails = {"abc@yahoo.com", "abc-100@yahoo.com", "abc.100@yahoo.com",
                "abc111@abc.com", "abc-100@abc.net", "abc.100@abc.com.au",
                "abc@1.com", "abc@gmail.com.com", "abc+100@gmail.com"};

        for (String email : validEmails) {
            UserRegistration ur = new UserRegistration("Nisha", "Mali", email, "91 9182374657", "abcdefgh");
            try {
                ur.isValidEmail();
            } catch (CustomValidationException e) {
                Assertions.fail(e.getMessage());
            }
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
            try {
                ur.isValidEmail();
                Assertions.fail("Expected CustomValidationException was not thrown");
            } catch (CustomValidationException e) {
                Assertions.assertEquals("Invalid email", e.getMessage());
            }
        }
    }

    // Test For Valid Entry
    @Test
    void checkValidEntry() {
        UserRegistration ur = new UserRegistration("Nisha", "Mali", "abc@gmail.com", "91 9182374657", "aBc@efgh1");
        try {
            ur.isValidEntry();
        } catch (CustomValidationException e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    void checkInvalidEntry() {
        UserRegistration ur = new UserRegistration("Nisha", "Mali", "abc@gmail.com", "91 9182374657", "abcdefgh");
        try {
            ur.isValidEntry();
            Assertions.fail("Expected CustomValidationException was not thrown");
        } catch (CustomValidationException e) {
            Assertions.assertEquals("Invalid entry", e.getMessage());
        }
    }

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
        try {
            ur.isValidEmail();
            Assertions.assertEquals("HAPPY", expected);
        }
        catch (CustomValidationException e) {
            Assertions.assertEquals("Invalid email", e.getMessage());
            Assertions.assertEquals("SAD", expected);
        }
    }

}