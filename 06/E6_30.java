/*
  Craps is a popular dice game played in casinos. Write a program to play a
  variation of the game, as follows:

  Roll two dice. Each die has six faces representing values 1, 2, ..., and 6,
  respectively. Check the sum of the two dice. If the sum is 2, 3, or 12
  (called craps), you lose; if the sum is 7 or 11 (called natural), you win;
  if the sum is another value (ie 4, 5, 6, 8, 9, or 10), a point is
  established. Continue to roll the dice until either a 7 or the same point
  value is rolled. If 7 is rolled, you lose. Otherwise, you win.
*/

public class E6_30 {
  public static void main(String[] args) {
    playCraps();
  }

  public static void playCraps() {
    int d1 = rollDice();
    int d2 = rollDice();

    int sum = d1 + d2;
    System.out.println("You rolled " + d1 + " + " + d2 + " = " + sum);

    if (sum == 2 || sum == 3 || sum == 12) {
      System.out.println("You lose");
    } else if (sum == 7 || sum == 11) {
      System.out.println("You win");
    } else {
      int point = sum;
      int sum2;
      do {
        int r1 = rollDice();
        int r2 = rollDice();
        sum2 = r1 + r2;
        System.out.println("You rolled " + r1 + " + " + r2 + " = " + sum2);
      } while (sum2 != 7 && sum2 != point);
      if (sum2 == 7) {
        System.out.println("You lose");
      } else {
        System.out.println("You win");
      }
    }
  }

  public static int rollDice() {
    return (int)(Math.random() * 6) + 1;
  }
}
