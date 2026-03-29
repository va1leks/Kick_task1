package org.example.kick_task1.parser;

import org.example.kick_task1.parser.impl.IntParserImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IntParserImplTest {
    private IntParserImpl parser;

    @BeforeEach
    void setUp() {
        parser = new IntParserImpl();
    }

    @Test
    void parseIntArrayShouldParseSimpleNumbers() {
        String input = "1 2 3 4 5";
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, parser.parseIntArray(input));
    }

    @Test
    void parseIntArrayShouldParseNegativeNumbers() {
        String input = "-1 -2 -3 4 5";
        int[] expected = {-1, -2, -3, 4, 5};
        assertArrayEquals(expected, parser.parseIntArray(input));
    }

    @Test
    void parseIntArrayShouldHandleMultipleSpaces() {
        String input = "1   2    3   4   5";
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, parser.parseIntArray(input));
    }

    @Test
    void parseIntArrayShouldHandleCommas() {
        String input = "1,2,3,4,5";
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, parser.parseIntArray(input));
    }

    @Test
    void parseIntArrayShouldHandleMixedDelimiters() {
        String input = "1,2 3,4 5";
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, parser.parseIntArray(input));
    }

    @Test
    void parseIntArrayShouldReturnEmptyArrayForEmptyString() {
        String input = "";
        int[] expected = {};
        assertArrayEquals(expected, parser.parseIntArray(input));
    }

    @Test
    void parseIntArrayShouldHandleStringWithNoNumbers() {
        String input = "abc def";
        int[] expected = {};
        assertArrayEquals(expected, parser.parseIntArray(input));
    }
}