public class E1_04 {
  public static void main(String[] args) {
    System.out.println("a       a^2     a^3");
    for (int i = 1; i <= 4; i++) {
      System.out.printf("%-3d     %-3d     %-3d\n", i, i * i, i * i * i);
    }
  }
}
