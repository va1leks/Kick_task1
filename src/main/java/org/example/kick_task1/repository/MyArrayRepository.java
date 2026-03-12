package org.example.kick_task1.repository;

import org.example.kick_task1.entity.MyArray;
import org.example.kick_task1.specification.Specification;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public interface MyArrayRepository {


  MyArray findById(int id);

  void removeById(int id);

  void save(MyArray myArray);

  List<MyArray> findAll();

  Optional<MyArray> update(MyArray myArray);

  List<MyArray> query(Specification spec);

  List<MyArray> sort(Comparator<MyArray> comparator);
}
