package org.example.kick_task1.entity;

import org.example.kick_task1.exception.MyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyArrayTest {
    private MyArray myArray;
    private int[] testData = {5, 2, 8, 1, 9};

    @BeforeEach
    void setUp() throws MyException {
        myArray = new MyArray(testData);
    }

    @Test
    void constructorWithArrayShouldCreateCopy() throws MyException {
        int[] original = {1, 2, 3};
        MyArray array = new MyArray(original);
        original[0] = 999; // Изменяем оригинал

        assertNotEquals(original[0], array.getArray()[0]);
        assertEquals(1, array.getArray()[0]);
    }

    @Test
    void constructorWithArrayShouldThrowExceptionWhenNull() {
        assertThrows(MyException.class, () -> new MyArray((int[]) null));
    }

    @Test
    void constructorWithLengthShouldCreateArray() throws MyException {
        MyArray array = new MyArray(5);
        assertEquals(5, array.getLength());
    }

    @Test
    void constructorWithLengthShouldThrowExceptionWhenInvalid() {
        assertThrows(MyException.class, () -> new MyArray(-1));
    }

    @Test
    void getAndSetId() {
        myArray.setId(10);
        assertEquals(10, myArray.getId());
    }

    @Test
    void getArrayShouldReturnCopy() {
        int[] returned = myArray.getArray();
        returned[0] = 999;

        assertNotEquals(returned[0], myArray.getArray()[0]);
    }

    @Test
    void getShouldReturnElement() throws MyException {
        assertEquals(5, myArray.get(0));
        assertEquals(9, myArray.get(4));
    }

    @Test
    void getShouldThrowExceptionWhenIndexOutOfBounds() {
        assertThrows(MyException.class, () -> myArray.get(-1));
        assertThrows(MyException.class, () -> myArray.get(5));
    }

    @Test
    void getLength() {
        assertEquals(5, myArray.getLength());
    }

    @Test
    void toStringShouldReturnSpaceSeparatedValues() {
        assertEquals("5 2 8 1 9 ", myArray.toString());
    }

    @Test
    void equalsShouldCompareArrays() throws MyException {
        MyArray sameArray = new MyArray(testData);
        MyArray differentArray = new MyArray(new int[]{1, 2, 3});

        assertEquals(myArray, sameArray);
        assertNotEquals(myArray, differentArray);
        assertNotEquals(myArray, null);
        assertNotEquals(myArray, new Object());
    }

    @Test
    void hashCodeShouldBeConsistentWithEquals() throws MyException {
        MyArray sameArray = new MyArray(testData);
        assertEquals(myArray.hashCode(), sameArray.hashCode());
    }
}
