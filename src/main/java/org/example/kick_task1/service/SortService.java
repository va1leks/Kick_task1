package org.example.kick_task1.service;

import org.example.kick_task1.entity.MyArray;
import org.example.kick_task1.exception.MyException;

public interface SortService {

    MyArray bubbleSort(MyArray myArray) throws MyException;

    MyArray selectionSort(MyArray myArray) throws MyException;
}
