/*
  Write the following overloaded methods that check whether an array is ordered
  in ascending order or descending order. By default, the method checks
  ascending order. To check descending order, pass false to the ascending
  argument in the method.

  public static boolean ordered(int[] list)
  public static boolean ordered(int[] list, boolean ascending)
  public static boolean ordered(double[] list)
  public static boolean ordered(double[] list, boolean ascending)
  public static <E extends Comparable<E>> boolean ordered(E[] list)
  public static <E extends Comparable<E>> boolean ordered(E[] list,
    boolean ascending)
  public static <E> boolean ordered(E[] list, Comparator<? super E> comparator)
  public static <E> boolean ordered(E[] list, Comparator<? super E> comparator,
    boolean ascending)
*/

import java.util.Comparator;

public class E23_06 {
  public static void main(String[] args) {
    double[] list1 = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0};
    int[] list2 = {1, 2, 3, 4, -21, 6, 7};
    System.out.println(ordered(list1));
    System.out.println(ordered(list2));
  }

  public static boolean ordered(int[] list) {
    return ordered(list, true);
  }

  public static boolean ordered(int[] list, boolean ascending) {
    Integer[] intList = new Integer[list.length];
    for (int i = 0; i < list.length; i++) {
      intList[i] = list[i];
    }
    return ordered(intList, ascending);
  }

  public static boolean ordered(double[] list) {
    return ordered(list, true);
  }

  public static boolean ordered(double[] list, boolean ascending) {
    Double[] doubList = new Double[list.length];
    for (int i = 0; i < list.length; i++) {
      doubList[i] = list[i];
    }
    return ordered(doubList, ascending);
  }

  public static <E extends Comparable<E>> boolean ordered(E[] list) {
    return ordered(list, true);
  }

  public static <E extends Comparable<E>> boolean ordered(E[] list,
    boolean ascending) {
    return ordered(list, new AscendingComparator<E>(), ascending);
  }

  public static <E> boolean ordered(E[] list,
    Comparator<? super E> comparator) {
    return ordered(list, comparator, true);
  }

  public static <E> boolean ordered(E[] list, Comparator<? super E> comparator,
    boolean ascending) {
    E current = list[0];
    boolean correctOrder = true;
    for (int i = 1; i < list.length; i++) {
      if (ascending) {
        if (comparator.compare(list[i], current) > 0) { current = list[i]; }
        else { correctOrder = false; }
      } else {
        if (comparator.compare(list[i], current) < 0) { current = list[i]; }
        else { correctOrder = false; }
      }
      if (!correctOrder) { return false; }
    }
    return true;
  }

  private static class AscendingComparator<E extends Comparable<E>>
    implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
      if (o1.compareTo(o2) < 0) {
        return -1;
      } else if (o1.compareTo(o2) > 0) {
        return 1;
      }
      return 0;
    }
  }
}
