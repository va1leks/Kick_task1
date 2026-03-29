package org.example.kick_task1.factory;

import org.example.kick_task1.entity.IntArray;
import org.example.kick_task1.exception.IntException;
import org.example.kick_task1.factory.impl.IntArrayFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IntArrayFactorImplTest {
    private IntArrayFactoryImpl factory;

    @BeforeEach
    void setUp() {
        factory = new IntArrayFactoryImpl();
    }

    @Test
    void createArrayWithSize() throws IntException {
        IntArray array = factory.createArray(5);
        assertNotNull(array);
        assertEquals(5, array.getLength());
    }

    @Test
    void createArrayWithSizeShouldThrowExceptionWhenInvalid() {
        assertThrows(IntException.class, () -> factory.createArray(-1));
    }

    @Test
    void createArrayWithData() throws IntException {
        int[] data = {1, 2, 3, 4, 5};
        IntArray array = factory.createArray(data);
        assertNotNull(array);
        assertArrayEquals(data, array.getArray());
    }

    @Test
    void createArrayWithDataShouldThrowExceptionWhenNull() {
        assertThrows(IntException.class, () -> factory.createArray((int[]) null));
    }
}
