package org.example.kick_task1.parser;

import org.example.kick_task1.exception.MyException;

import java.util.List;

public interface MyParser {

    int[] parseIntArray(String data) throws MyException;
}
