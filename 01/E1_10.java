public class E1_10 {
  public static void main(String[] args) {
    System.out.println("mph: " + kphToMph(kilometersPerHour(14, 45.5)));
  }

  private static double kilometersPerHour(double kilometers, double minutes) {
    return 60.0 * (kilometers / minutes);
  }

  private static double kphToMph(double kph) {
    return kph / 1.6;
  }
}
