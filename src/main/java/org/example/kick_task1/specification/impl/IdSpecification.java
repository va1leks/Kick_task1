package org.example.kick_task1.specification.impl;

import org.example.kick_task1.entity.IntArray;
import org.example.kick_task1.specification.Specification;

public class IdSpecification implements Specification {

  private final long id;

  IdSpecification(long id) {
    this.id = id;
  }

  @Override
  public boolean isSatisfiedBy(IntArray item) {
    return id==item.getId();
  }
}
