package org.example.kick_task1.repository;

import org.example.kick_task1.entity.IntArray;
import org.example.kick_task1.specification.Specification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

public class IntArrayRepository {

  private static final Logger logger = LoggerFactory.getLogger(IntArrayRepository.class);
  private static IntArrayRepository instance;
  private final List<IntArray> intArrays = new ArrayList<>();

  public void add(int index, IntArray element) {
    intArrays.add(index, element);
  }

  public IntArray get(int index) {
    return intArrays.get(index);
  }

  public static IntArrayRepository getInstance() {
    if (instance == null) {
      instance = new IntArrayRepository();
    }
    return instance;
  }

  public void remove(int id) {
    if (intArrays.removeIf(array -> array.getId() == id)) {
      logger.info("Array with ID: {} removed from repository", id);
    } else {
      logger.warn("Attempt to remove non-existent array with ID: {}", id);
    }
  }

  public Optional<IntArray> update(IntArray intArray) {
    for (int i = 0; i < intArrays.size(); i++) {
      if (intArrays.get(i).getId() == intArray.getId()) {
        intArrays.set(i, intArray);
        return Optional.of(intArray);
      }
    }
    return Optional.empty();
  }


  public List<IntArray> query(Specification spec) {
    logger.info("Executing query with specification: {}", spec.getClass().getSimpleName());
    List<IntArray> result = new ArrayList<>();

    for (IntArray intArray : intArrays) {
      if (spec.isSatisfiedBy(intArray)) {
        result.add(intArray);
      }
    }
    logger.info("Query finished. Found {} matches", result.size());
    return result;
  }

  public List<IntArray> sort(Comparator<IntArray> comparator) {
    return intArrays
            .stream()
            .sorted(comparator)
            .collect(Collectors.toList());
  }
}
