package org.example.kick_task1.reader.impl;

import org.example.kick_task1.exception.IntException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.example.kick_task1.reader.CustomFileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class CustomFileReaderImpl implements CustomFileReader {

  private static final Logger logger = LoggerFactory.getLogger(CustomFileReaderImpl.class);

  @Override
  public List<String> readFile(String fileName) throws IntException {
    logger.info("Reading file {}", fileName);
    try {
      return Files.readAllLines(Paths.get(fileName));
    } catch (IOException e) {
      logger.error("Error reading file: {}", fileName);
      throw new IntException("File read error", e);
    }
  }
}
