public class E1_07 {
  public static void main(String[] args) {
    System.out.println(approximatePi(11));
    System.out.println(approximatePi(13));
  }

  private static double approximatePi(int index) {
    boolean positive = true;
    double sum = 0.0;
    for (int i = 1; i <= index; i += 2) {
      if (positive) {
        sum += (1.0 / i);
        positive = false;
      } else {
        sum -= (1.0 / i);
        positive = true;
      }
    }

    return 4.0 * sum;
  }
}
