package org.example.kick_task1.observer.impl;

import org.example.kick_task1.entity.MyArray;
import org.example.kick_task1.entity.MyArrayStatistics;
import org.example.kick_task1.observer.Observer;
import org.example.kick_task1.service.OperationService;
import org.example.kick_task1.service.impl.OperationServiceImpl;
import org.example.kick_task1.warehouse.Warehouse;

public class ObserverImpl implements Observer {

  @Override
  public void update(MyArray array) {
    OperationService operationService = new OperationServiceImpl();
    MyArrayStatistics statistics = new MyArrayStatistics(
            operationService.getMin(array).orElse(0),
            operationService.getMax(array).orElse(0),
            operationService.getSum(array).orElse(0),
            operationService.getAverage(array).orElse((double)0)
    );
    Warehouse.getInstance().put(array.getId(), statistics);
  }
}
