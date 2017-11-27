/*
  Write a recursive method that converts a decimal number into a binary
  number as a string. The method header is:

  public static String dec2Bin(int value)

  Write a test program that prompts the user to enter a decimal number and
  displays its binary equivalent.
*/

import java.util.Scanner;

public class E18_21 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an integer: ");
    int value = input.nextInt();

    System.out.println(dec2Bin(value));
  }

  public static String dec2Bin(int value) {
    return dec2Bin(value, "");
  }

  public static String dec2Bin(int value, String binString) {
    if (value == 0) { return binString; }
    binString = (value % 2 == 0 ? "0" : "1") + binString;
    return dec2Bin(value / 2, binString);
  }
}
