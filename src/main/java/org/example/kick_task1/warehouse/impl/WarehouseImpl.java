package org.example.kick_task1.warehouse.impl;

import org.example.kick_task1.entity.MyArray;
import org.example.kick_task1.entity.MyArrayStatistics;
import org.example.kick_task1.observer.Observer;
import org.example.kick_task1.service.OperationService;
import org.example.kick_task1.service.impl.OperationServiceImpl;
import org.example.kick_task1.warehouse.Warehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class WarehouseImpl implements Warehouse, Observer {

    private static final Logger logger = LoggerFactory.getLogger(WarehouseImpl.class);

    private static WarehouseImpl instance;
    private final Map<Long, MyArrayStatistics> myArrays = new HashMap<>();
    private final OperationService service = new OperationServiceImpl();

    private WarehouseImpl() {}



    public static WarehouseImpl getInstance() {
        if (instance == null) {
            instance = new WarehouseImpl();
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

    @Override
    public void update(MyArray array) {
        logger.info("Observer notification received for Array ID: {}", array.getId());
        int max = service.getMax(array).orElse(0);
        int min = service.getMin(array).orElse(0);
        int sum = service.getSum(array).orElse(0);
        double avg = service.getAverage(array).orElse(0.0);

        MyArrayStatistics stats = new MyArrayStatistics(min, max, sum, avg);
        logger.info(stats.toString());
        myArrays.put(array.getId(), stats);
        logger.info("Statistics updated in Warehouse for ID {}: {}", array.getId(), stats);
    }

    @Override
    public void update(long arrayId, int[] data) {
        try {
            MyArray array = new MyArray(data);

            int max = service.getMax(array).orElse(0);
            int min = service.getMin(array).orElse(0);
            int sum = service.getSum(array).orElse(0);
            double avg = service.getAverage(array).orElse(0.0);
            MyArrayStatistics stats = new MyArrayStatistics(min, max, sum, avg);

            myArrays.put(arrayId, stats);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
