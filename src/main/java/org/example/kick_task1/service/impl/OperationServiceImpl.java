package org.example.kick_task1.service.impl;

import org.example.kick_task1.entity.MyArray;
import org.example.kick_task1.exception.MyException;
import org.example.kick_task1.service.OperationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Optional;

public class OperationServiceImpl implements OperationService {

    private static final Logger logger = LoggerFactory.getLogger(OperationServiceImpl.class);

    @Override
    public Optional<Integer> getMin(MyArray myArray) {
        try {
            int min = myArray.get(0);
            for (int i = 0; i < myArray.getLength(); i++) {
                if (min > myArray.get(i)) {
                    min = myArray.get(i);
                }
            }
            logger.debug("min = {}", min);
            return Optional.of(min);
        } catch (MyException e) {
            return Optional.empty();
        }

    }

    @Override
    public Optional<Integer> getMax(MyArray myArray) {
        try {
            int max = myArray.get(0);
            for (int i = 0; i < myArray.getLength(); i++) {
                if (max < myArray.get(i)) {
                    max = myArray.get(i);
                }
            }
            logger.debug("max = {}", max);

            return Optional.of(max);
        } catch (MyException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Integer> getSum(MyArray myArray) {
        try {
            int sum = 0;
            for (int i = 0; i < myArray.getLength(); i++) {
                sum += myArray.get(i);
            }
            return Optional.of(sum);
        } catch (MyException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Double> getAverage(MyArray myArray) {
        if (myArray.getLength() == 0) {
            return Optional.empty();
        }

        Optional<Integer> sumOpt = getSum(myArray);

        if (sumOpt.isPresent()) {
            double average = (double) sumOpt.get() / myArray.getLength();
            return Optional.of(average);
        }

        return Optional.empty();
    }
}
