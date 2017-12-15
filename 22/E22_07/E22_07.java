/*
  Section 22.8 introduced an algorithm for finding the closest pair of points
  using a divide-and-conquer approach. Implement the algorithm to meet the
  following requirements.

  - Define the classes Point and CompareY in the same way as in Programming
    Exercise 20.4.
  - Define a class named Pair with the data fields p1 and p2 to represent two
    points, and a method named getDistance() that returns the distance between
    the two points.
  - Implement the following methods

    public static Pair getClosestPair(double[][] points)

    public static Pair getClosestPair(Point[] points)

    public static Pair distance(Point[] pointsOrderedOnX, int low, int high,
      Point[] pointsOrderedOnY)

    public static double distance(Point p1, Point p2)

    public static double distance(double x1, double y1, double x2, double y2)
*/

import java.util.Arrays;

public class E22_07 {
  public static void main(String[] args) {
    Point[] points = new Point[9];
    for (int i = 0; i < points.length; i++) {
      double r1 = (int)(Math.random() * 20);
      double r2 = (int)(Math.random() * 20);
      Point p = new Point(r1, r2);
      points[i] = p;
    }

    Arrays.sort(points);

    for (Point p: points){
      System.out.println(p);
    }

    Pair minDistance = Pair.getClosestPair(points);
    System.out.println(minDistance);
  }
}
