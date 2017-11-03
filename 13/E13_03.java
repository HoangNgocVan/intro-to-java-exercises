/*
  Write the following method that sorts an ArrayList of numbers.

  public static void sort(ArrayList<Number> list)
*/

import java.util.ArrayList;

public class E13_03 {
  public static void main(String[] args) {
    // create a list of random numbers
    ArrayList<Number> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      int random = (int)(Math.random() * 100);
      list.add(random);
    }

    // display the list
    for (Number n: list) {
      System.out.print(n + " ");
    }
    System.out.println();

    // sort the list
    sort(list);

    // display the sorted list
    for (Number n: list) {
      System.out.print(n + " ");
    }
    System.out.println();
  }

  public static void sort(ArrayList<Number> list) {
    boolean changed;
    do {
      changed = false;
      for (int i = 0; i < list.size() - 1; i++) {
        if (list.get(i).doubleValue() > list.get(i + 1).doubleValue()) {
          Number temp = list.get(i);
          list.set(i, list.get(i + 1));
          list.set(i + 1, temp);
          changed = true;
        }
      }
    } while (changed);
  }
}
