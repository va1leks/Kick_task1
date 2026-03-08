package org.example.kick_task1;

import org.example.kick_task1.entity.MyArray;
import org.example.kick_task1.exception.MyException;
import org.example.kick_task1.factory.MyArrayFactory;
import org.example.kick_task1.factory.impl.MyArrayFactoryImpl;
import org.example.kick_task1.parser.MyParser;
import org.example.kick_task1.parser.impl.MyParserImpl;
import org.example.kick_task1.reader.impl.MyFileReaderImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.matches;

@SpringBootApplication
public class KickTask1Application {

    public static void main(String[] args) {

        String regex;

        MyFileReaderImpl myFileReader = new MyFileReaderImpl();
        List<String> str = new ArrayList<>();
        try {
            str = myFileReader.readFile("data/data.txt");
        }
        catch (MyException e) {
            System.out.println(e.getMessage());
        }
        str.forEach(System.out::println);
        MyParser myParser = new MyParserImpl();
        MyArrayFactory myArrayFactory = new MyArrayFactoryImpl();
        MyArray s;
        try {
           s = myArrayFactory.createArray(myParser.parseIntArray(str.get(0)));
            System.out.println(s.toString());
        }
        catch (MyException e) {
            System.out.println(e.getMessage());
        }



    }

}
