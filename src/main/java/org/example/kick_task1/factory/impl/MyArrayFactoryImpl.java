package org.example.kick_task1.factory.impl;

import org.example.kick_task1.entity.MyArray;
import org.example.kick_task1.exception.MyException;
import org.example.kick_task1.factory.MyArrayFactory;

public class MyArrayFactoryImpl implements MyArrayFactory {

    @Override
    public MyArray createArray(int size) throws MyException {
        return new MyArray(size);
    }

    @Override
    public MyArray createArray(int[] array) throws MyException {
        if (array == null) {
            throw new MyException("Array is null");
        }
        return new MyArray(array);
    }
}
