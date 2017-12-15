import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Pair {
  private Point p1;
  private Point p2;

  public Pair(Point p1, Point p2) {
    this.p1 = p1;
    this.p2 = p2;
  }

  public Point getP1() {
    return p1;
  }

  public Point getP2() {
    return p2;
  }

  public double getDistance() {
    return distance(p1, p2);
  }

  public static Pair getClosestPair(double[][] points) {
    Point[] pts = new Point[points.length];
    for (int i = 0; i < points.length; i++) {
      Point p = new Point(points[i][0], points[i][1]);
      pts[i] = p;
    }
    return getClosestPair(pts);
  }

  public static Pair getClosestPair(Point[] points) {
    Arrays.sort(points);
    Point[] pointsOrderedOnX = points.clone();
    Arrays.sort(points, new CompareY());
    Point[] pointsOrderedOnY = points.clone();
    return distance(
      pointsOrderedOnX, 0, pointsOrderedOnX.length - 1, pointsOrderedOnY);
  }

  public static Pair distance(Point[] pointsOrderedOnX, int low, int high,
    Point[] pointsOrderedOnY) {
    if (low >= high) {
      return null;
    } else if (low + 1 == high) {
      return new Pair(pointsOrderedOnX[low], pointsOrderedOnX[high]);
    }

    int mid = (low + high) / 2;
    Pair p1 = distance(pointsOrderedOnX, low, mid, pointsOrderedOnY);
    Pair p2 = distance(pointsOrderedOnX, mid + 1, high, pointsOrderedOnY);

    double distance = 0;
    Pair p = null;

    if (p1 == null && p2 == null) {
      distance = Double.MAX_VALUE;
    } else if (p1 == null) {
      distance = p2.getDistance();
      p = p2;
    } else if (p2 == null) {
      distance = p1.getDistance();
      p = p1;
    } else {
      distance = Math.min(p1.getDistance(), p2.getDistance());
      p = ((p1.getDistance() <= p2.getDistance())? p1 : p2);
    }

    List<Point> stripL = new ArrayList<Point>();
    List<Point> stripR = new ArrayList<Point>();
    List<Point> s1 = new ArrayList<>(Arrays.asList(
    Arrays.copyOfRange(pointsOrderedOnX, low, mid)));
    List<Point> s2 = new ArrayList<>(
    Arrays.asList(Arrays.copyOfRange(pointsOrderedOnX, mid + 1, high)));
    for (Point point: pointsOrderedOnY) {
      if (s1.contains(point) &&
      pointsOrderedOnX[mid].getX() - point.getX() <= distance) {
        stripL.add(point);
      } else if (point.getX() - pointsOrderedOnX[mid].getX() <= distance){
        stripR.add(point);
      }
    }

    double d3 = distance;
    int r = 0;
    for (Point point: stripL) {
      while (r < stripR.size() &&
        point.getY() > stripR.get(r).getY() + distance) {
        r++;
      }

      int r1 = r;
      while (r1 < stripR.size() &&
        stripR.get(r1).getY() <= point.getY() + distance) {
        if (d3 > distance(point, stripR.get(r1))) {
          d3 = distance(point, stripR.get(r1));
          p.p1 = point;
          p.p2 = stripR.get(r1);
        }
        r1++;
      }
    }

    return p;
  }

  public static double distance(Point p1, Point p2) {
    double x1 = p1.getX();
    double y1 = p1.getY();
    double x2 = p2.getX();
    double y2 = p2.getY();
    return distance(x1, y1, x2, y2);
  }

  public static double distance(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
  }

  @Override
  public String toString() {
    return p1 + ", " + p2;
  }
}
