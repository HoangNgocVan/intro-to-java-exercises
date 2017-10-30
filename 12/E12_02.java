/*
  Write a program that prompts the user to read two integers and displays their
  sum. Your program should prompt the user to read the number again if the
  input is incorrect.
*/

import java.util.Scanner;

public class E12_02 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String a, b;
    do {
      System.out.print("Enter two integers: ");
      a = input.next();
      b = input.next();
    } while (!isNumber(a) || !isNumber(b));

    System.out.println("The sum is " +
      (Integer.parseInt(a) + Integer.parseInt(b)));
  }

  public static boolean isNumber(String s) {
    for (int i = 0; i < s.length(); i++) {
      if (!Character.isDigit(s.charAt(i))) { return false; }
    }
    return true;
  }
}
