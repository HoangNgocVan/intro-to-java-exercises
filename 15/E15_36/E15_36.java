public class E15_36 {
  public static void main(String[] args) {
    int attempts = 10_000;
    for (int i = 10; i <= 80; i++) {
      int deadEnd = 0;
      for (int j = 0; j < attempts; j++) {
        SelfAvoidingWalk saw = new SelfAvoidingWalk(i);
        int result = saw.walk();
        if (result == -1) { deadEnd++; }
      }
      double percent = ((double)deadEnd / attempts) * 100;
      System.out.printf("For a lattice of size %d, the probability of " +
        "dead-end paths is %.1f%%\n", i, percent);
    }
  }
}
