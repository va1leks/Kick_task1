package org.example.kick_task1.entity;


import java.util.Objects;

public class MyArrayStatistics {
  private int max;
  private int min;
  private int sum;
  private double average;


  public MyArrayStatistics(int min, int max, int sum, double average) {
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
  }

  public int getMin() {
    return min;
  }

  public void setMin(int min) {
    this.min = min;
  }

  public int getSum() {
    return sum;
  }

  public void setSum(int sum) {
    this.sum = sum;
  }

  public double getAverage() {
    return average;
  }

  public void setAverage(double average) {
    this.average = average;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("MyArrayStatistics:");
    sb.append("max=").append(max);
    sb.append(", min=").append(min);
    sb.append(", sum=").append(sum);
    sb.append(", average=").append(average);

    return sb.toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(max, min, sum, average);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    MyArrayStatistics that = (MyArrayStatistics) o;

    if (max != that.max) return false;
    if (min != that.min) return false;
    if (sum != that.sum) return false;

    return Double.compare(that.average, average) == 0;
  }
}
