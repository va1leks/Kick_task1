package org.example.kick_task1.entity;

import org.example.kick_task1.exception.IntException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IntArrayTest {
    private IntArray intArray;
    private int[] testData = {5, 2, 8, 1, 9};

    @BeforeEach
    void setUp() throws IntException {
        intArray = new IntArray(testData);
    }

    @Test
    void constructorWithArrayShouldCreateCopy() throws IntException {
        int[] original = {1, 2, 3};
        IntArray array = new IntArray(original);
        original[0] = 999; // Изменяем оригинал

        assertNotEquals(original[0], array.getArray()[0]);
        assertEquals(1, array.getArray()[0]);
    }

    @Test
    void constructorWithArrayShouldThrowExceptionWhenNull() {
        assertThrows(IntException.class, () -> new IntArray((int[]) null));
    }

    @Test
    void constructorWithLengthShouldCreateArray() throws IntException {
        IntArray array = new IntArray(5);
        assertEquals(5, array.getLength());
    }

    @Test
    void constructorWithLengthShouldThrowExceptionWhenInvalid() {
        assertThrows(IntException.class, () -> new IntArray(-1));
    }

    @Test
    void getAndSetId() {
        intArray.setId(10);
        assertEquals(10, intArray.getId());
    }

    @Test
    void getArrayShouldReturnCopy() {
        int[] returned = intArray.getArray();
        returned[0] = 999;

        assertNotEquals(returned[0], intArray.getArray()[0]);
    }

    @Test
    void getShouldReturnElement() throws IntException {
        assertEquals(5, intArray.get(0));
        assertEquals(9, intArray.get(4));
    }

    @Test
    void getShouldThrowExceptionWhenIndexOutOfBounds() {
        assertThrows(IntException.class, () -> intArray.get(-1));
        assertThrows(IntException.class, () -> intArray.get(5));
    }

    @Test
    void getLength() {
        assertEquals(5, intArray.getLength());
    }

    @Test
    void toStringShouldReturnSpaceSeparatedValues() {
        assertEquals("5 2 8 1 9 ", intArray.toString());
    }

    @Test
    void equalsShouldCompareArrays() throws IntException {
        IntArray sameArray = new IntArray(testData);
        IntArray differentArray = new IntArray(new int[]{1, 2, 3});

        assertEquals(intArray, sameArray);
        assertNotEquals(intArray, differentArray);
        assertNotEquals(intArray, null);
        assertNotEquals(intArray, new Object());
    }

    @Test
    void hashCodeShouldBeConsistentWithEquals() throws IntException {
        IntArray sameArray = new IntArray(testData);
        assertEquals(intArray.hashCode(), sameArray.hashCode());
    }
}
