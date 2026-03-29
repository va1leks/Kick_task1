package org.example.kick_task1.reader;

import org.example.kick_task1.exception.IntException;

import java.util.List;

public interface CustomFileReader {

  List<String> readFile(String fileName) throws IntException;
}
