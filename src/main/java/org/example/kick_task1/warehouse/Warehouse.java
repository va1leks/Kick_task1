package org.example.kick_task1.warehouse;

import org.example.kick_task1.entity.MyArray;
import org.example.kick_task1.entity.MyArrayStatistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {

  private static final Logger logger = LoggerFactory.getLogger(Warehouse.class);
  private static Warehouse instance;
  private final Map<Long, MyArrayStatistics> myArrays = new HashMap<>();

  private Warehouse() {}

  public static Warehouse getInstance() {
    if (instance == null) {
      instance = new Warehouse();
    }
    return instance;
  }

  public void put(long id, MyArrayStatistics array) {
    myArrays.put(id, array);
  }

  public MyArrayStatistics get(long id) {
    return myArrays.get(id);
  }

  public boolean remove(long id) {
    return myArrays.remove(id) != null;
  }

}
