import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;
import java.util.List;
import java.util.ArrayList;

public class ClosestPairPane extends Pane {
  private List<Circle> circles;
  private Line connection;

  public ClosestPairPane() {
    circles = new ArrayList<>();
    drawPane();
  }

  private void drawPane() {
    setPrefSize(500, 500);
    setOnMouseClicked(e -> placePoint(e));
  }

  private void placePoint(MouseEvent event) {
    if (!event.getButton().equals(MouseButton.PRIMARY)) { return; }
    Circle circle = new Circle(5);
    circle.setCenterX(event.getX());
    circle.setCenterY(event.getY());
    circle.setOnMouseClicked(e -> removePoint(e));
    circles.add(circle);
    getChildren().add(circle);
    connectClosestPoints();
  }

  private void removePoint(MouseEvent event) {
    if (!event.getButton().equals(MouseButton.SECONDARY)) { return; }
    Circle circle = (Circle)event.getSource();
    circles.remove(circle);
    getChildren().remove(circle);
    connectClosestPoints();
  }

  private void connectClosestPoints() {
    if (circles.size() >= 2) {
      Pair closest = Pair.getClosestPair(getPointsForCircles());
      Point p1 = closest.getP1();
      Point p2 = closest.getP2();
      getChildren().remove(connection);
      connection = new Line(p1.getX(), p1.getY(), p2.getX(), p2.getY());
      getChildren().add(connection);
    } else {
      getChildren().remove(connection);
    }
  }

  private double[][] getPointsForCircles() {
    double[][] points = new double[circles.size()][2];
    for (int i = 0; i < circles.size(); i++) {
      Circle c = circles.get(i);
      points[i][0] = c.getCenterX();
      points[i][1] = c.getCenterY();
    }
    return points;
  }
}
