package org.example.kick_task1.service.impl;

import org.example.kick_task1.entity.MyArray;
import org.example.kick_task1.exception.MyException;
import org.example.kick_task1.service.SortService;

public class SortServiceImpl implements SortService {

  @Override
  public MyArray bubbleSort(MyArray myArray) throws MyException {
    int[] tempData = myArray.getArray();
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
    return new MyArray(tempData);
  }

  @Override
  public MyArray selectionSort(MyArray myArray) throws MyException {
    int[] tempData = myArray.getArray();

    for (int i = 0; i < tempData.length - 1; i++) {
      for (int j = i + 1; j < tempData.length; j++) {
        if (tempData[i] > tempData[j]) {
          int temp = tempData[i];
          tempData[i] = tempData[j];
          tempData[j] = temp;
        }
      }
    }
    return new MyArray(tempData);
  }
}
