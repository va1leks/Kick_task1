package org.example.kick_task1.repository;

import org.example.kick_task1.entity.MyArray;
import org.example.kick_task1.observer.impl.ObserverImpl;
import org.example.kick_task1.specification.Specification;
import org.example.kick_task1.warehouse.Warehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

public class MyArrayRepository {

  private static final Logger logger = LoggerFactory.getLogger(MyArrayRepository.class);
  private static MyArrayRepository instance;
  private final List<MyArray> myArrays = new ArrayList<>();

  public void add(int index, MyArray element) {
    myArrays.add(index, element);
  }

  public MyArray get(int index) {
    return myArrays.get(index);
  }

  public static MyArrayRepository getInstance() {
    if (instance == null) {
      instance = new MyArrayRepository();
    }
    return instance;
  }

  public void remove(int id) {
    if (myArrays.removeIf(array -> array.getId() == id)) {
      logger.info("Array with ID: {} removed from repository", id);
    } else {
      logger.warn("Attempt to remove non-existent array with ID: {}", id);
    }
  }

  public MyArrayRepository() {
  }

  public Optional<MyArray> update(MyArray myArray) {
    for (int i = 0; i < myArrays.size(); i++) {
      if (myArrays.get(i).getId() == myArray.getId()) {
        myArrays.set(i, myArray);
        return Optional.of(myArray);
      }
    }
    return Optional.empty();
  }


  public List<MyArray> query(Specification spec) {
    logger.info("Executing query with specification: {}", spec.getClass().getSimpleName());
    List<MyArray> result = new ArrayList<>();

    for (MyArray myArray : myArrays) {
      if (spec.isSatisfiedBy(myArray)) {
        result.add(myArray);
      }
    }
    logger.info("Query finished. Found {} matches", result.size());
    return result;
  }

  public List<MyArray> sort(Comparator<MyArray> comparator) {
    return myArrays
            .stream()
            .sorted(comparator)
            .collect(Collectors.toList());
  }
}
