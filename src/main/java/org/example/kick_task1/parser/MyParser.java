package org.example.kick_task1.parser;

import org.example.kick_task1.exception.MyException;

public interface MyParser {

  String LINE_REGEX = "-?\\d+";

  int[] parseIntArray(String data) throws MyException;
}
