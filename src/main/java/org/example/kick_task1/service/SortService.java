package org.example.kick_task1.service;

import org.example.kick_task1.entity.IntArray;
import org.example.kick_task1.exception.IntException;

public interface SortService {

  IntArray bubbleSort(IntArray intArray) throws IntException;

  IntArray selectionSort(IntArray intArray) throws IntException;
}
