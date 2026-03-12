package org.example.kick_task1.reader;

import org.example.kick_task1.exception.MyException;

import java.util.List;

public interface MyFileReader {

  List<String> readFile(String fileName) throws MyException;
}
