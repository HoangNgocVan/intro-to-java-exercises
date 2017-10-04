public class E1_13 {
  public static void main(String[] args) {
    cramer(3.4, 50.2, 2.1, 0.55, 44.5, 5.9);
  }

  private static void cramer(double a, double b, double c, double d, double e, double f) {
    double x = (e * d - b * f) / (a * d - b * c);
    double y = (a * f - e * c) / (a * d - b * c);
    System.out.println("x: " + x + " y: " + y);
  }
}
