package org.example.kick_task1.service;

import org.example.kick_task1.entity.IntArray;
import org.example.kick_task1.exception.IntException;
import org.example.kick_task1.service.impl.OperationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class OperationServiceImplTest {
    private OperationServiceImpl operationService;
    private IntArray intArray;

    @BeforeEach
    void setUp() throws IntException {
        operationService = new OperationServiceImpl();
        intArray = new IntArray(new int[]{5, 2, 8, 1, 9, 3});
    }

    @Test
    void getMinShouldReturnMinimum() {
        Optional<Integer> min = operationService.getMin(intArray);
        assertTrue(min.isPresent());
        assertEquals(1, min.get());
    }

    @Test
    void getMinShouldReturnEmptyForEmptyArray() throws IntException {
        IntArray emptyArray = new IntArray(0);
        Optional<Integer> min = operationService.getMin(emptyArray);
        assertTrue(min.isEmpty());
    }

    @Test
    void getMaxShouldReturnMaximum() {
        Optional<Integer> max = operationService.getMax(intArray);
        assertTrue(max.isPresent());
        assertEquals(9, max.get());
    }

    @Test
    void getMaxShouldReturnEmptyForEmptyArray() throws IntException {
        IntArray emptyArray = new IntArray(0);
        Optional<Integer> max = operationService.getMax(emptyArray);
        assertTrue(max.isEmpty());
    }

    @Test
    void getSumShouldReturnSum() {
        Optional<Integer> sum = operationService.getSum(intArray);
        assertTrue(sum.isPresent());
        assertEquals(28, sum.get()); // 5+2+8+1+9+3 = 28
    }

    @Test
    void getSumShouldReturnZeroForEmptyArray() throws IntException {
        IntArray emptyArray = new IntArray(0);
        Optional<Integer> sum = operationService.getSum(emptyArray);
        assertTrue(sum.isPresent());
        assertEquals(0, sum.get());
    }

    @Test
    void getSumShouldHandleNegativeNumbers() throws IntException {
        IntArray negativeArray = new IntArray(new int[]{-5, -2, -8, -1});
        Optional<Integer> sum = operationService.getSum(negativeArray);
        assertTrue(sum.isPresent());
        assertEquals(-16, sum.get());
    }
}