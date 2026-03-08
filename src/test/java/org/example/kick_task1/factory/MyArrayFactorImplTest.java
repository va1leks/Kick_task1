package org.example.kick_task1.factory;

import org.example.kick_task1.entity.MyArray;
import org.example.kick_task1.exception.MyException;
import org.example.kick_task1.factory.impl.MyArrayFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyArrayFactorImplTest {
    private MyArrayFactoryImpl factory;

    @BeforeEach
    void setUp() {
        factory = new MyArrayFactoryImpl();
    }

    @Test
    void createArrayWithSize() throws MyException {
        MyArray array = factory.createArray(5);
        assertNotNull(array);
        assertEquals(5, array.getLength());
    }

    @Test
    void createArrayWithSizeShouldThrowExceptionWhenInvalid() {
        assertThrows(MyException.class, () -> factory.createArray(-1));
    }

    @Test
    void createArrayWithData() throws MyException {
        int[] data = {1, 2, 3, 4, 5};
        MyArray array = factory.createArray(data);
        assertNotNull(array);
        assertArrayEquals(data, array.getArray());
    }

    @Test
    void createArrayWithDataShouldThrowExceptionWhenNull() {
        assertThrows(MyException.class, () -> factory.createArray((int[]) null));
    }
}
