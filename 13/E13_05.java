/*
  Modify the GeometricObject class to implement the Comparable interface, and
  define a static max method in the GeometricObject class for finding the
  larger of two GeometricObject objects. Write a test program that uses the
  max method to find the larger of two circles and the larger of two
  rectangles.
*/

public class E13_05 {
  public static void main(String[] args) {
    Circle c1 = new Circle(10);
    Circle c2 = new Circle(5);

    Circle largerCircle = (Circle)GeometricObject.max(c1, c2);
    System.out.println(largerCircle.getRadius());

    Rectangle r1 = new Rectangle(10, 5);
    Rectangle r2 = new Rectangle(10, 10);

    Rectangle largerRectangle = (Rectangle)GeometricObject.max(r1, r2);
    System.out.println(largerRectangle.getArea());
  }
}
