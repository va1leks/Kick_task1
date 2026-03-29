package org.example.kick_task1.factory;

import org.example.kick_task1.entity.IntArray;
import org.example.kick_task1.exception.IntException;

public interface IntArrayFactory {

  IntArray createArray(int size) throws IntException;

  IntArray createArray(int[] array) throws IntException;
}
