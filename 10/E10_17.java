/*
  Find the first ten square numbers that are greater than Long.MAX_VALUE. A
  square number is a number in the form of n^2. For example, 4, 9, and 16 are
  square numbers. Find an efficient approach to run your program fast.
*/

import java.math.BigInteger;

public class E10_17 {
  public static void main(String[] args) {
    // Create a BigInteger for Long's maximum value, and another for its sqrt
    BigInteger longMax = new BigInteger(String.valueOf(Long.MAX_VALUE));
    BigInteger n = sqrt(longMax);

    // Starting at n, find the next 10 squares of n, ensuring that they exceed
    // longMax
    int count = 0;
    while (count < 10) {
      BigInteger square = n.multiply(n);
      if (square.compareTo(longMax) == 1) {
        System.out.println(square);
        count++;
      }
      n = n.add(BigInteger.ONE);
    }
  }

  // BigInteger sqrt function found on StackOverflow
  public static BigInteger sqrt(BigInteger x) {
    BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
    BigInteger div2 = div;
    // Loop until we hit the same value twice in a row, or wind
    // up alternating.
    for(;;) {
      BigInteger y = div.add(x.divide(div)).shiftRight(1);
      if (y.equals(div) || y.equals(div2))
        return y;
      div2 = div;
      div = y;
    }
  }
}
