/*
  Write a program that prompts the user to enter a hex digit and displays its
  corresponding binary number.
*/

import java.util.Scanner;

public class E4_12 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a hex digit: ");
    String hex = input.nextLine().toLowerCase();

    if (!isValidEntry(hex)) {
      System.out.println("Invalid entry. Must be 0-9, A-F.");
      System.exit(1);
    }

    System.out.println(hexToBin(hex));
  }

  private static String hexToBin(String hex) {
    return decToBin(hexToDec(hex));
  }

  private static String decToBin(int dec) {
    StringBuilder s = new StringBuilder();
    int binPlace = highestBinaryPlace(dec);
    int bitLength = bitLength(binPlace);

    while (s.length() != bitLength) {
      // tying the loop to binPlace proved troublesome since 1 is a valid
      // value and binPlace will never be less than 1, so tying it to the
      // expected number of bits seemed the next best option
      if (dec >= binPlace) {
        s.append("1");
        dec -= binPlace;
      } else {
        s.append("0");
      }
      binPlace /= 2;
    }

    return s.toString();
  }

  private static int bitLength(int b) {
    // Obtain the appropriate length of the final string of bits
    int count = 0;
    while (true) {
      count++;
      if (b == 1) { break; }
      b /= 2;
    }
    return count;
  }

  private static int highestBinaryPlace(int n) {
    // Obtain the highest binary place for a given decimal input
    int binPlace = 1;
    while (true) {
      if (binPlace * 2 <= n) {
        binPlace *= 2;
      } else {
        break;
      }
    }
    return binPlace;
  }

  private static int hexToDec(String hex) {
    int dec = -1;
    char c = hex.charAt(0);
    if (Character.isDigit(c)) {
      dec = Integer.valueOf(hex);
    } else {
      switch (c) {
        case 'a': dec = 10; break;
        case 'b': dec = 11; break;
        case 'c': dec = 12; break;
        case 'd': dec = 13; break;
        case 'e': dec = 14; break;
        case 'f': dec = 15;
      }
    }
    return dec;
  }

  private static boolean isValidEntry(String s) {
    boolean valid = true;
    char c = s.charAt(0);
    boolean digit = Character.isDigit(c);
    boolean letter = Character.isLetter(c);

    if (s.length() != 1) {
      valid = false;
    } else if (digit && (c < '0' || c > '9')) {
      valid = false;
    } else if (letter && (c < 'a' || c > 'f')) {
      valid = false;
    }

    return valid;
  }
}
