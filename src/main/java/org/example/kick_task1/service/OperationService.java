package org.example.kick_task1.service;

import org.example.kick_task1.entity.IntArray;

import java.util.Optional;

public interface OperationService {

  Optional<Integer> getMin(IntArray intArray);

  Optional<Integer> getMax(IntArray intArray);

  Optional<Integer> getSum(IntArray intArray);

  Optional<Double> getAverage(IntArray intArray);
}
