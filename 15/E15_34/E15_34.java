/*
  A self-avoiding walk in a lattice is a path from one point to another that
  does not visit the same point twice. Self-voiding walks have applications
  in physics, chemistry, and mathematics. They can be used to model chain-like
  entities such as solvents and polymers. Write a program that displays a
  random path that starts from the center and ends at a point on the boundary,
  or ends at a dead-end point (i.e. surrounded by four points that have
  already been visited). Assume the size of the lattice is 16 by 16.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.control.Button;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class E15_34 extends Application {
  @Override
  public void start(Stage primaryStage) {
    LatticePane latticePane = new LatticePane(16, 20);
    SelfAvoidingWalk walk = new SelfAvoidingWalk(16);
    walk.walk();
    latticePane.drawWalk(walk);

    HBox controlPane = new HBox();
    controlPane.setAlignment(Pos.CENTER);

    Button btStart = new Button("Start");
    btStart.setOnAction(e -> {
      latticePane.resetGrid();
      walk.walk();
      latticePane.drawWalk(walk);
    });

    controlPane.getChildren().add(btStart);

    BorderPane pane = new BorderPane();
    pane.setCenter(latticePane);
    pane.setBottom(controlPane);
    pane.setMargin(latticePane, new Insets(20));
    pane.setMargin(controlPane, new Insets(0, 0, 20, 0));

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E15_34");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  class LatticePane extends Pane {
    private int squares;
    private double scaleFactor;

    LatticePane(int squares, double scaleFactor) {
      this.squares = squares;
      this.scaleFactor = scaleFactor;

      drawGrid();
    }

    public void drawWalk(SelfAvoidingWalk walk) {
      Polyline poly = new Polyline();
      poly.setStrokeWidth(4);
      for (Point2D p: walk.getPath()) {
        double x = p.getX() * scaleFactor;
        double y = p.getY() * scaleFactor;
        poly.getPoints().addAll(x, y);
      }
      getChildren().add(poly);
    }

    public void drawGrid() {
      double width = getSize();
      double height = width;

      // Draw vertical and horizontal grid lines
      for (int i = 0; i <= squares; i++) {
        Line vert = new Line();
        vert.setStartX(i * scaleFactor);
        vert.setStartY(0);
        vert.setEndX(i * scaleFactor);
        vert.setEndY(height);

        Line hori = new Line();
        hori.setStartX(0);
        hori.setStartY(i * scaleFactor);
        hori.setEndX(width);
        hori.setEndY(i * scaleFactor);

        getChildren().addAll(vert, hori);
      }
    }

    public void resetGrid() {
      getChildren().clear();
      drawGrid();
    }

    public double getSize() {
      return squares * scaleFactor;
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
