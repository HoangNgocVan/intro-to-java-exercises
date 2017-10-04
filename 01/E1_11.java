public class E1_11 {
  public static void main(String[] args) {
    int currentPopulation = 312_032_486;
    int secondsPerYear = 365 * 24 * 60 * 60;

    for (int i = 1; i <= 5; i++) {
      currentPopulation += (secondsPerYear / 7);
      currentPopulation += (secondsPerYear / 45);
      currentPopulation -= (secondsPerYear / 13);
      System.out.println("Year " + i + ": " + currentPopulation);
    }
  }
}
