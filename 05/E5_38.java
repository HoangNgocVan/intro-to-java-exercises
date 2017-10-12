/*
  Write a program that prompts the user to enter a decimal integer and displays
  its corresponding octal value. Don't use Java's Integer.toOctalString(int)
  in this program.
*/

import java.util.Scanner;

public class E5_38 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a decimal integer: ");
    int dec = input.nextInt();

    System.out.println(decToOctal(dec));
  }

  private static String decToOctal(int dec) {
    StringBuilder oct = new StringBuilder();
    while (dec != 0) {
      oct.insert(0, dec % 8);
      dec /= 8;
    }
    return oct.toString();
  }
}
