package org.example.kick_task1.service;

import org.example.kick_task1.entity.MyArray;
import org.example.kick_task1.exception.MyException;
import org.example.kick_task1.service.impl.SortServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SortServiceImplTest {
    private SortServiceImpl sortService;
    private MyArray unsortedArray;

    @BeforeEach
    void setUp() throws MyException {
        sortService = new SortServiceImpl();
        unsortedArray = new MyArray(new int[]{5, 2, 8, 1, 9, 3});
    }

    @Test
    void bubbleSortShouldSortArray() throws MyException {
        MyArray sorted = sortService.bubbleSort(unsortedArray);
        int[] expected = {1, 2, 3, 5, 8, 9};
        assertArrayEquals(expected, sorted.getArray());
    }

    @Test
    void bubbleSortShouldNotModifyOriginal() throws MyException {
        int[] original = unsortedArray.getArray().clone();
        sortService.bubbleSort(unsortedArray);
        assertArrayEquals(original, unsortedArray.getArray());
    }

    @Test
    void bubbleSortShouldHandleSingleElement() throws MyException {
        MyArray single = new MyArray(new int[]{42});
        MyArray sorted = sortService.bubbleSort(single);
        assertArrayEquals(new int[]{42}, sorted.getArray());
    }

    @Test
    void bubbleSortShouldHandleAlreadySorted() throws MyException {
        MyArray sorted = new MyArray(new int[]{1, 2, 3, 4, 5});
        MyArray result = sortService.bubbleSort(sorted);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result.getArray());
    }

    @Test
    void bubbleSortShouldHandleNegativeNumbers() throws MyException {
        MyArray mixed = new MyArray(new int[]{-5, 2, -8, 1, 0});
        MyArray sorted = sortService.bubbleSort(mixed);
        int[] expected = {-8, -5, 0, 1, 2};
        assertArrayEquals(expected, sorted.getArray());
    }

    @Test
    void selectionSortShouldSortArray() throws MyException {
        MyArray sorted = sortService.selectionSort(unsortedArray);
        int[] expected = {1, 2, 3, 5, 8, 9};
        assertArrayEquals(expected, sorted.getArray());
    }

    @Test
    void selectionSortShouldNotModifyOriginal() throws MyException {
        int[] original = unsortedArray.getArray().clone();
        sortService.selectionSort(unsortedArray);
        assertArrayEquals(original, unsortedArray.getArray());
    }
}