package org.example.kick_task1.observer;

import org.example.kick_task1.entity.MyArray;

public interface Observer {

  void update(MyArray array);

  void update(long arrayId, int[] data);

  void update(long arrayId, int max, int min, int sum, double average);
}
