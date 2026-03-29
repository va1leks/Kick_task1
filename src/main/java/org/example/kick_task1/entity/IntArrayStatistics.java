package org.example.kick_task1.entity;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class IntArrayStatistics {
  private static final Logger logger = LoggerFactory.getLogger(IntArrayStatistics.class);
  private int max;
  private int min;
  private int sum;
  private double average;


  public IntArrayStatistics(int min, int max, int sum, double average) {
    this.min = min;
    this.max = max;
    this.sum = sum;
    this.average = average;
  }

  public int getMax() {
    return max;
  }

  public void setMax(int max) {
    this.max = max;
    logger.info("set max: {}", max);
  }

  public int getMin() {
    return min;
  }

  public void setMin(int min) {
    this.min = min;
    logger.info("set min: {}", max);
  }

  public int getSum() {
    return sum;
  }

  public void setSum(int sum) {
    this.sum = sum;
    logger.info("set sum: {}", max);
  }

  public double getAverage() {
    return average;
  }

  public void setAverage(double average) {
    this.average = average;
    logger.info("set average: {}", max);
  }

  @Override
  public String toString() {
    return "IntArrayStatistics:" + "max=" + max +
            ", min=" + min +
            ", sum=" + sum +
            ", average=" + average;
  }

  @Override
  public int hashCode() {
    return Objects.hash(max, min, sum, average);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    IntArrayStatistics that = (IntArrayStatistics) o;

    if (max != that.max) return false;
    if (min != that.min) return false;
    if (sum != that.sum) return false;

    return Double.compare(that.average, average) == 0;
  }
}
