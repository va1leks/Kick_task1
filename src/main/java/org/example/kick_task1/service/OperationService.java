package org.example.kick_task1.service;

import org.example.kick_task1.entity.MyArray;
import java.util.Optional;

public interface OperationService {

    Optional<Integer> getMin(MyArray myArray);

    Optional<Integer> getMax(MyArray  myArray);

    Optional<Integer> getSum(MyArray myArray);
}
