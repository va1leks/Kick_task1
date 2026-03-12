package org.example.kick_task1.factory;

import org.example.kick_task1.entity.MyArray;
import org.example.kick_task1.exception.MyException;

public interface MyArrayFactory {

  MyArray createArray(int size) throws MyException;

  MyArray createArray(int[] array) throws MyException;
}
