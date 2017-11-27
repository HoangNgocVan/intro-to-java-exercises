/*
  Write a recursive method that finds the number of occurrences of a specified
  letter in a string using the following method header:

  public static int count(String str, char a)

  For example, count("Welcome", 'e') returns 2. Write a test program that
  prompts the user to enter a string and a character, and displays the number
  of occurrences for the character in the string.
*/

import java.util.Scanner;

public class E18_10 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String s = input.nextLine();
    System.out.print("Enter a character: ");
    char c = input.nextLine().charAt(0);

    System.out.println(count(s, c));
  }

  public static int count(String str, char a) {
    if (str.length() > 0) {
      int match =
        str.toLowerCase().charAt(0) == Character.toLowerCase(a) ? 1 : 0;
      return match + count(str.substring(1, str.length()), a);
    } else {
      return 0;
    }
  }
}
