package org.example.kick_task1;

import org.example.kick_task1.entity.MyArray;
import org.example.kick_task1.exception.MyException;
import org.example.kick_task1.factory.MyArrayFactory;
import org.example.kick_task1.factory.impl.MyArrayFactoryImpl;
import org.example.kick_task1.parser.MyParser;
import org.example.kick_task1.parser.impl.MyParserImpl;
import org.example.kick_task1.reader.MyFileReader;
import org.example.kick_task1.reader.impl.MyFileReaderImpl;
import org.example.kick_task1.service.SortService;
import org.example.kick_task1.service.impl.SortServiceImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class KickTask1Application {

    public static void main(String[] args) {
        MyArrayFactory myArrayFactory = new MyArrayFactoryImpl();
        MyFileReader myFileReader = new MyFileReaderImpl();
        MyParser myParser = new MyParserImpl();
        SortService sortService = new SortServiceImpl();
        try {
            List<String> str = myFileReader.readFile("data/data.txt");
            MyArray arr = new MyArray();
            for (int strIndex = 0; strIndex < str.size(); strIndex++) {
                System.out.println(sortService.bubbleSort(myArrayFactory.createArray(myParser.parseIntArray(str.get(strIndex)))).toString());

            }


        }catch (MyException e)
        {
            e.printStackTrace();
        }


    }

}
