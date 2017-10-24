/*
  Design a class named LinearEquation for a 2 x 2 system of linear equations.
  The class contains:

  - Private data fields a, b, c, d, e, and f.
  - A constructor with the arguments for a, b, c, d, e, and f.
  - Six getter methods for a, b, c, d, e, and f.
  - A method named isSolvable() that returns true if ad - bc is not 0.
  - Methods getX() and getY() that return the solution for the equation.

  Write a test program that prompts the user to enter a, b, c, d, e, and f and
  displays the result. If ad - bc is 0, report that "The equation has no
  solution."
*/

import java.util.Scanner;

public class E9_11 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a, b, c, d, e, f: ");
    LinearEquation lin = new LinearEquation(input.nextDouble(),
      input.nextDouble(), input.nextDouble(), input.nextDouble(),
      input.nextDouble(), input.nextDouble());

    if (!lin.isSolvable()) {
      System.out.println("The equation has no solution.");
    } else {
      System.out.println("x: " + lin.getX() + " y: " + lin.getY());
    }
  }

  private static class LinearEquation {
    private double a, b, c, d, e, f;

    LinearEquation(double a, double b, double c, double d, double e, double f) {
      this.a = a;
      this.b = b;
      this.c = c;
      this.d = d;
      this.e = e;
      this.f = f;
    }

    // getters
    double getA() {
      return a;
    }

    double getB() {
      return b;
    }

    double getC() {
      return c;
    }

    double getD() {
      return d;
    }

    double getE() {
      return e;
    }

    double getF() {
      return f;
    }

    // instance methods
    boolean isSolvable() {
      return getA() * getD() - getB() * getC() != 0;
    }

    double getX() {
      return (getE() * getD() - getB() * getF()) /
             (getA() * getD() - getB() * getC());
    }

    double getY() {
      return (getA() * getF() - getE() * getC()) /
             (getA() * getD() - getB() * getC());
    }
  }
}
