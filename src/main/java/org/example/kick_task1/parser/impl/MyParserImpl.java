package org.example.kick_task1.parser.impl;

import org.example.kick_task1.parser.MyParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyParserImpl implements MyParser {

  private static final Logger logger = LoggerFactory.getLogger(MyParserImpl.class);

  private static final String LINE_REGEX = "-?\\d+";

  public MyParserImpl() {
  }

  @Override
  public int[] parseIntArray(String data) {

    Pattern pattern = Pattern.compile(LINE_REGEX);
    Matcher matcher = pattern.matcher(data);

    List<Integer> result = new ArrayList<>();
    while (matcher.find()) {
      result.add(Integer.parseInt(matcher.group()));
    }
    int[] resultArray = new int[result.size()];

    for (int i = 0; i < resultArray.length; i++) {
      resultArray[i] = result.get(i);
    }
    logger.debug("resultArray = {}", resultArray);

    return resultArray;

  }
}
