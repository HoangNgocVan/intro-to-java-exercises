/*
  Write the following method that shuffles an ArrayList of numbers:

  public static void shuffle(ArrayList<Number> list)
*/

import java.util.ArrayList;

public class E13_02 {
  public static void main(String[] args) {
    // generate list of Number from 0 to 9
    ArrayList<Number> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      list.add(i);
    }

    // display list
    for (Number n: list) {
      System.out.print(n + " ");
    }
    System.out.println();

    // shuffle the list
    shuffle(list);

    // display shuffled list
    for (Number n: list) {
      System.out.print(n + " ");
    }
    System.out.println();
  }

  public static void shuffle(ArrayList<Number> list) {
    for (int i = 0; i < list.size(); i++) {
      int randomIndex = (int)(Math.random() * list.size());
      Number temp = list.get(i);
      list.set(i, list.get(randomIndex));
      list.set(randomIndex, temp);
    }
  }
}
