package org.example.kick_task1.validator;

import org.example.kick_task1.validator.impl.IntValidatorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IntValidatorImplTest {
    private IntValidatorImpl validator;

    @BeforeEach
    void setUp() {
        validator = new IntValidatorImpl();
    }

    @Test
    void isLineValidShouldAcceptNumbersAndSpaces() {
        assertTrue(validator.isLineValid("1 2 3 4 5"));
        assertTrue(validator.isLineValid("-1 -2 -3"));
        assertTrue(validator.isLineValid("1  2   3"));
    }

    @Test
    void isLineValidShouldRejectLetters() {
        assertFalse(validator.isLineValid("1 2 a 4"));
        assertFalse(validator.isLineValid("abc"));
    }

    @Test
    void isLineValidShouldRejectSpecialCharacters() {
        assertFalse(validator.isLineValid("1,2,3"));
        assertFalse(validator.isLineValid("1!2@3"));
    }


    @Test
    void isLineValidShouldRejectEmptyOrNull() {
        assertFalse(validator.isLineValid(""));
        assertFalse(validator.isLineValid(null));
    }
}