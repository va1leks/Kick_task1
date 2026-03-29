package org.example.kick_task1.service.impl;

import org.example.kick_task1.entity.IntArray;
import org.example.kick_task1.exception.IntException;
import org.example.kick_task1.service.OperationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class OperationServiceImpl implements OperationService {

  private static final Logger logger = LoggerFactory.getLogger(OperationServiceImpl.class);

  @Override
  public Optional<Integer> getMin(IntArray intArray) {
    try {
      int min = intArray.get(0);
      for (int i = 0; i < intArray.getLength(); i++) {
        if (min > intArray.get(i)) {
          min = intArray.get(i);
        }
      }
      logger.debug("min = {}", min);
      return Optional.of(min);
    } catch (IntException e) {
      return Optional.empty();
    }

  }

  @Override
  public Optional<Integer> getMax(IntArray intArray) {
    try {
      int max = intArray.get(0);
      for (int i = 0; i < intArray.getLength(); i++) {
        if (max < intArray.get(i)) {
          max = intArray.get(i);
        }
      }
      logger.debug("max = {}", max);

      return Optional.of(max);
    } catch (IntException e) {
      return Optional.empty();
    }
  }

  @Override
  public Optional<Integer> getSum(IntArray intArray) {
    try {
      int sum = 0;
      for (int i = 0; i < intArray.getLength(); i++) {
        sum += intArray.get(i);
      }
      return Optional.of(sum);
    } catch (IntException e) {
      return Optional.empty();
    }
  }

  @Override
  public Optional<Double> getAverage(IntArray intArray) {
    if (intArray.getLength() == 0) {
      return Optional.empty();
    }

    Optional<Integer> sumOpt = getSum(intArray);

    if (sumOpt.isPresent()) {
      double average = (double) sumOpt.get() / intArray.getLength();
      return Optional.of(average);
    }

    return Optional.empty();
  }
}
