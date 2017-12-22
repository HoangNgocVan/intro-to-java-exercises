public class Test {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
      18, 19, 20};
    int key = 5;
    LinearSearchState[] states = LinearSearchState.getSearchStates(arr, key);

    for (LinearSearchState s: states) {
      System.out.println(s);
    }
  }
}
