package org.example.kick_task1.specification.impl;

import org.example.kick_task1.entity.MyArray;
import org.example.kick_task1.specification.Specification;

public class IdSpecification implements Specification {

  private final long id;

  IdSpecification(long id) {
    this.id = id;
  }

  @Override
  public boolean isSatisfiedBy(MyArray item) {
    return id==item.getId();
  }
}
