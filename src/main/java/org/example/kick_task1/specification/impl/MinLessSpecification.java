package org.example.kick_task1.specification.impl;

import org.example.kick_task1.entity.IntArray;
import org.example.kick_task1.specification.Specification;
import org.example.kick_task1.warehouse.Warehouse;

public class MinLessSpecification implements Specification {

  private final int min;

  MinLessSpecification(int min) {
    this.min = min;
  }

  @Override
  public boolean isSatisfiedBy(IntArray item) {
    var state = Warehouse.getInstance().get(item.getId());
    if (state==null) {
      return false;
    }
    return state.getMin() < min;
  }

}
