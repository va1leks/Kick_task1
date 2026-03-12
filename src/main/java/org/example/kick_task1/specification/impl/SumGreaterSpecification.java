package org.example.kick_task1.specification.impl;

import org.example.kick_task1.entity.MyArray;
import org.example.kick_task1.specification.Specification;
import org.example.kick_task1.warehouse.impl.WarehouseImpl;

public class SumGreaterSpecification implements Specification {

  private final int sum;

  SumGreaterSpecification(int sum) {
    this.sum = sum;
  }

  @Override
  public boolean isSatisfiedBy(MyArray item) {
    var state = WarehouseImpl.getInstance().get(item.getId());

    if (state==null) {
      return false;
    }

    return state.getSum()>sum;
  }
}
