package org.example.kick_task1.comparator;

import org.example.kick_task1.entity.MyArray;

import java.util.Comparator;

public enum MyComparator implements Comparator<MyArray> {
  BY_ID {
    @Override
    public int compare(MyArray item1, MyArray item2) {
      return Long.compare(item1.getId(), item2.getId());
    }
  },
  BY_FIRST_ELEMENT {
    @Override
    public int compare(MyArray item1, MyArray item2) {
      int val1 = item1.getLength() > 0 ? item1.getArray()[0] : 0;
      int val2 = item2.getLength() > 0 ? item2.getArray()[0] : 0;

      return Integer.compare(val1, val2);
    }
  },
  BY_LENGTH {
    @Override
    public int compare(MyArray item1, MyArray item2) {
      return Integer.compare(item1.getLength(), item2.getLength());
    }
  }
}
