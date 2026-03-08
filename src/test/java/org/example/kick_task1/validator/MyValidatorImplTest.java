package org.example.kick_task1.validator;

import org.example.kick_task1.validator.impl.MyValidatorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyValidatorImplTest {
    private MyValidatorImpl validator;

    @BeforeEach
    void setUp() {
        validator = new MyValidatorImpl();
    }

    @Test
    void isValidShouldAcceptNumbersAndSpaces() {
        assertTrue(validator.isValid("1 2 3 4 5"));
        assertTrue(validator.isValid("-1 -2 -3"));
        assertTrue(validator.isValid("1  2   3"));
    }

    @Test
    void isValidShouldRejectLetters() {
        assertFalse(validator.isValid("1 2 a 4"));
        assertFalse(validator.isValid("abc"));
    }

    @Test
    void isValidShouldRejectSpecialCharacters() {
        assertFalse(validator.isValid("1,2,3"));
        assertFalse(validator.isValid("1!2@3"));
    }


    @Test
    void isValidShouldRejectEmptyOrNull() {
        assertFalse(validator.isValid(""));
        assertFalse(validator.isValid(null));
    }
}