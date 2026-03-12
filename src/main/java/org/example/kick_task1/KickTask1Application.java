package org.example.kick_task1;
import org.example.kick_task1.comparator.MyComparator;
import org.example.kick_task1.entity.MyArray;
import org.example.kick_task1.exception.MyException;
import org.example.kick_task1.factory.MyArrayFactory;
import org.example.kick_task1.factory.impl.MyArrayFactoryImpl;
import org.example.kick_task1.observer.Observer;
import org.example.kick_task1.parser.MyParser;
import org.example.kick_task1.parser.impl.MyParserImpl;
import org.example.kick_task1.reader.MyFileReader;
import org.example.kick_task1.reader.impl.MyFileReaderImpl;
import org.example.kick_task1.repository.MyArrayRepository;
import org.example.kick_task1.repository.impl.MyArrayRepositoryImpl;
import org.example.kick_task1.service.SortService;
import org.example.kick_task1.service.impl.SortServiceImpl;
import org.example.kick_task1.warehouse.Warehouse;
import org.example.kick_task1.warehouse.impl.WarehouseImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
@SpringBootApplication
public class KickTask1Application {


    public static void main(String[] args) {
        // 1. Инициализация инфраструктуры (Singleton)
        MyArrayRepository repository = MyArrayRepositoryImpl.getInstance();
        WarehouseImpl warehouse = WarehouseImpl.getInstance();

        MyArrayFactory factory = new MyArrayFactoryImpl();
        SortService sortService = new SortServiceImpl();

        try {
            System.out.println("=== ШАГ 1: Создание и регистрация ===");
            int[] data1 = {10, 5, 8, 20};
            MyArray array1 = factory.createArray(data1);
            array1.setId(100);

            // Регистрация обсервера ДО сохранения
            array1.addObserver(warehouse);
            repository.save(array1);

            // Принудительно уведомляем, чтобы Warehouse создал первую запись
            array1.notifyObservers();

            System.out.println("Статистика в Warehouse для ID 100: " + warehouse.get(100));

            System.out.println("\n=== ШАГ 2: Проверка Observer (Авто-обновление) ===");
            // Меняем данные в массиве. Warehouse должен обновиться САМ через notifyObservers в setArray
            array1.setArray(new int[]{1, 1, 1});

            System.out.println("Новая статистика после setArray: " + warehouse.get(100));

            System.out.println("\n=== ШАГ 3: Создание второго массива и Сортировка ===");
            int[] data2 = {50, 2, 30};
            MyArray array2 = factory.createArray(data2);
            array2.setId(50); // ID меньше, чем у первого
            array2.addObserver(warehouse);
            repository.save(array2);
            array2.notifyObservers();

            System.out.println("Все массивы в репозитории (без сортировки):");
            repository.findAll().forEach(a -> System.out.println("ID: " + a.getId() + " Data: " + a));

            System.out.println("\nСортировка по ID (через Repository):");
            List<MyArray> sortedById = repository.sort(MyComparator.BY_ID);
            sortedById.forEach(a -> System.out.println("ID: " + a.getId()));

            System.out.println("\n=== ШАГ 4: Проверка Спецификаций (Поиск) ===");
            // Пример использования спецификации (если она у тебя создана)
            // List<MyArray> found = repository.query(new IdSpecification(100));
            // System.out.println("Найдено по ID 100: " + found.size());

        } catch (MyException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}