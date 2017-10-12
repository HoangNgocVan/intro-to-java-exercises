/*
  Write a program that prompts the user to enter a decimal integer and displays
  its corresponding binary value. Don't use Java's Integer.toBinaryString(int)
  in this program.
*/

import java.util.Scanner;

public class E5_37 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a decimal integer: ");
    int dec = input.nextInt();

    System.out.println(decToBin(dec));
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
}
