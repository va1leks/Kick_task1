package org.example.kick_task1.service;

import org.example.kick_task1.entity.IntArray;
import org.example.kick_task1.exception.IntException;
import org.example.kick_task1.service.impl.SortServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SortServiceImplTest {
    private SortServiceImpl sortService;
    private IntArray unsortedArray;

    @BeforeEach
    void setUp() throws IntException {
        sortService = new SortServiceImpl();
        unsortedArray = new IntArray(new int[]{5, 2, 8, 1, 9, 3});
    }

    @Test
    void bubbleSortShouldSortArray() throws IntException {
        IntArray sorted = sortService.bubbleSort(unsortedArray);
        int[] expected = {1, 2, 3, 5, 8, 9};
        assertArrayEquals(expected, sorted.getArray());
    }

    @Test
    void bubbleSortShouldNotModifyOriginal() throws IntException {
        int[] original = unsortedArray.getArray().clone();
        sortService.bubbleSort(unsortedArray);
        assertArrayEquals(original, unsortedArray.getArray());
    }

    @Test
    void bubbleSortShouldHandleSingleElement() throws IntException {
        IntArray single = new IntArray(new int[]{42});
        IntArray sorted = sortService.bubbleSort(single);
        assertArrayEquals(new int[]{42}, sorted.getArray());
    }

    @Test
    void bubbleSortShouldHandleAlreadySorted() throws IntException {
        IntArray sorted = new IntArray(new int[]{1, 2, 3, 4, 5});
        IntArray result = sortService.bubbleSort(sorted);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result.getArray());
    }

    @Test
    void bubbleSortShouldHandleNegativeNumbers() throws IntException {
        IntArray mixed = new IntArray(new int[]{-5, 2, -8, 1, 0});
        IntArray sorted = sortService.bubbleSort(mixed);
        int[] expected = {-8, -5, 0, 1, 2};
        assertArrayEquals(expected, sorted.getArray());
    }

    @Test
    void selectionSortShouldSortArray() throws IntException {
        IntArray sorted = sortService.selectionSort(unsortedArray);
        int[] expected = {1, 2, 3, 5, 8, 9};
        assertArrayEquals(expected, sorted.getArray());
    }

    @Test
    void selectionSortShouldNotModifyOriginal() throws IntException {
        int[] original = unsortedArray.getArray().clone();
        sortService.selectionSort(unsortedArray);
        assertArrayEquals(original, unsortedArray.getArray());
    }
}