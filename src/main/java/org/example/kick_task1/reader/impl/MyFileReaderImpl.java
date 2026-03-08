package org.example.kick_task1.reader.impl;

import org.example.kick_task1.exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.example.kick_task1.reader.MyFileReader;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class MyFileReaderImpl implements MyFileReader {

    private final static Logger logger = LoggerFactory.getLogger(MyFileReaderImpl.class);

    public MyFileReaderImpl() {
    }

    @Override
    public List<String> readFile(String fileName) throws MyException {
        logger.info("Reading file {}", fileName);
        try {
            List<String> list = Files.readAllLines(Paths.get(fileName));
            return list;
        }
        catch (IOException e) {
            logger.error("Error reading file: {}",fileName);
            throw new MyException("File read error", e);
        }
    }
}
