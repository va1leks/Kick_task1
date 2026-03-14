package org.example.kick_task1.specification.impl;

import org.example.kick_task1.entity.MyArray;
import org.example.kick_task1.specification.Specification;
import org.example.kick_task1.warehouse.Warehouse;

public class MaxBetweenSpecification implements Specification {

  private final int firstMax;
  private final int secondMax;

  MaxBetweenSpecification(int firstMax, int secondMax) {
    this.firstMax = firstMax;
    this.secondMax = secondMax;
  }

  @Override
  public boolean isSatisfiedBy(MyArray item) {
    var state = Warehouse.getInstance().get(item.getId());
    if (state==null) {
      return false;
    }
    return firstMax < state.getMax() && secondMax > state.getMin();
  }

}
