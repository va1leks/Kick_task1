package org.example.kick_task1.factory.impl;

import org.example.kick_task1.entity.IntArray;
import org.example.kick_task1.exception.IntException;
import org.example.kick_task1.factory.IntArrayFactory;

public class IntArrayFactoryImpl implements IntArrayFactory {

  @Override
  public IntArray createArray(int size) throws IntException {
    return new IntArray(size);
  }

  @Override
  public IntArray createArray(int[] array) throws IntException {
    if (array == null) {
      throw new IntException("Array is null");
    }
    return new IntArray(array);
  }
}
