package org.example.kick_task1.service.impl;

import org.example.kick_task1.entity.IntArray;
import org.example.kick_task1.exception.IntException;
import org.example.kick_task1.service.SortService;

public class SortServiceImpl implements SortService {

  @Override
  public IntArray bubbleSort(IntArray intArray) throws IntException {
    int[] tempData = intArray.getArray();
    boolean swapped;
    for (int i = 0; i < tempData.length - 1; i++) {
      swapped = false;
      for (int j = 0; j < tempData.length - 1 - i; j++) {
        if (tempData[j] > tempData[j + 1]) {
          int temp = tempData[j];
          tempData[j] = tempData[j + 1];
          tempData[j + 1] = temp;
          swapped = true;
        }
      }
      if (!swapped) {
        break;
      }
    }
    return new IntArray(tempData);
  }

  @Override
  public IntArray selectionSort(IntArray intArray) throws IntException {
    int[] tempData = intArray.getArray();

    for (int i = 0; i < tempData.length - 1; i++) {
      for (int j = i + 1; j < tempData.length; j++) {
        if (tempData[i] > tempData[j]) {
          int temp = tempData[i];
          tempData[i] = tempData[j];
          tempData[j] = temp;
        }
      }
    }
    return new IntArray(tempData);
  }
}
