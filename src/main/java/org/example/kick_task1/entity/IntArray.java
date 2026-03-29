package org.example.kick_task1.entity;

import org.example.kick_task1.exception.IntException;
import org.example.kick_task1.observer.Observable;
import org.example.kick_task1.observer.Observer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntArray implements Observable {

  private static final Logger logger = LoggerFactory.getLogger(IntArray.class);
  private long id;
  private int[] array;
  List<Observer> observers = new ArrayList<>();

  public IntArray() {
  }

  public IntArray(int[] array) throws IntException {
    if (array == null) {
      throw new IntException("array is null");
    }
    this.array = array.clone();
    logger.info("Array created and initialized: {}", this);
  }

  public IntArray(int length) throws IntException {
    if (length < 0) {
      logger.error("Invalid array length: {}", length);
      throw new IntException("Invalid array length");
    }
    array = new int[length];
    logger.info("Array created: {}", array.length);
  }

  public long getId() {
    logger.info("getId: {}", id);
    return id;
  }

  public void setId(long id) {
    this.id = id;
    notifyObservers();
    logger.info("Set new id: {}", id);
  }

  public int[] getArray() {
    logger.info("getArray: {}", this);
    return array.clone();
  }

  public void setArray(int[] array) {
    this.array = array.clone();
    notifyObservers();
    logger.info("Set new array: {}", this);
  }

  public int getLength() {
    logger.debug("getLength: {}", array.length);
    return array.length;
  }

  public int get(int index) throws IntException {
    if (index < 0 || index >= array.length) {
      logger.error("Index out of bounds: {}", index);
      throw new IntException("Index out of bounds");
    }
    return array[index];
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    for (int j : array) {
      str.append(j);
      str.append(" ");
    }
    return str.toString();
  }

  @Override
  public void addObserver(Observer observer) {
    logger.info("addObserver: {}", observer);
    observers.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    logger.info("removeObserver: {}", observer);
    observers.remove(observer);
  }

  @Override
  public void notifyObservers() {
    logger.info("notifyObservers: {}", this);
    for (Observer observer : observers) {
      observer.update(this);
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    return Arrays.equals(((IntArray) obj).getArray(), this.getArray());

  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(array);
  }
}
