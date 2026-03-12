package org.example.kick_task1.repository.impl;

import org.example.kick_task1.entity.MyArray;
import org.example.kick_task1.repository.MyArrayRepository;
import org.example.kick_task1.specification.Specification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MyArrayRepositoryImpl implements MyArrayRepository {

  private static final Logger logger = LoggerFactory.getLogger(MyArrayRepositoryImpl.class);
  private static MyArrayRepositoryImpl instance;
  private final List<MyArray> myArrays = new ArrayList<>();

  public static MyArrayRepository getInstance() {
    if (instance == null) {
      instance = new MyArrayRepositoryImpl();
    }
    return instance;
  }

  public MyArrayRepositoryImpl() {
  }

  @Override
  public MyArray findById(int id) {
    return myArrays.get(id);
  }

  @Override
  public void removeById(int id) {
    if (myArrays.removeIf(array -> array.getId() == id)) {
      logger.info("Array with ID: {} removed from repository", id);
    } else {
      logger.warn("Attempt to remove non-existent array with ID: {}", id);
    }
  }

  @Override
  public void save(MyArray myArray) {
    myArrays.add(myArray);
    logger.info("Saved new array to repository. ID: {}, Current size: {}", myArray.getId(), myArrays.size());
  }

  @Override
  public List<MyArray> findAll() {
    return new ArrayList<>(this.myArrays);
  }

  @Override
  public Optional<MyArray> update(MyArray myArray) {
    for (int i = 0; i < myArrays.size(); i++) {
      if (myArrays.get(i).getId() == myArray.getId()) {
        myArrays.set(i, myArray);
        return Optional.of(myArray);
      }
    }
    return Optional.empty();
  }

  @Override
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

  @Override
  public List<MyArray> sort(Comparator<MyArray> comparator) {
    return myArrays
            .stream()
            .sorted(comparator)
            .collect(Collectors.toList());
  }
}
