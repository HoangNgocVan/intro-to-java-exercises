/*
  Write a program that enables the user to specify the location and size of
  the circles and displays whether two circles intersect. Enable the user to
  point the mouse inside the circle and drag it. As the circle is dragged, the
  circle's center coordinates in the text field are updated.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.geometry.Pos;

public class E16_08 extends Application {
  @Override
  public void start(Stage primaryStage) {
    Label lbIntersect = new Label();

    Pane circlePane = new Pane();
    Circle c1 = new Circle(52, 60, 30);
    Circle c2 = new Circle(180, 56, 40);
    c1.setFill(Color.TRANSPARENT);
    c1.setStroke(Color.BLACK);
    c2.setFill(Color.TRANSPARENT);
    c2.setStroke(Color.BLACK);
    circlePane.getChildren().addAll(c1, c2);

    VBox c1VBox = new VBox();
    GridPane c1GridPane = new GridPane();
    Label lbC1Info = new Label("Enter circle 1 info:");
    Label lbC1CenterX = new Label("Center x:");
    Label lbC1CenterY = new Label("Center y:");
    Label lbC1Radius = new Label("Radius:");
    TextField tfC1CenterX = new TextField();
    TextField tfC1CenterY = new TextField();
    TextField tfC1Radius = new TextField();
    c1GridPane.addColumn(0, lbC1CenterX, lbC1CenterY, lbC1Radius);
    c1GridPane.addColumn(1, tfC1CenterX, tfC1CenterY, tfC1Radius);
    c1VBox.getChildren().addAll(lbC1Info, c1GridPane);

    tfC1CenterX.setPrefWidth(60);
    tfC1CenterY.setPrefWidth(60);
    tfC1Radius.setPrefWidth(60);
    tfC1CenterX.setEditable(false);
    tfC1CenterY.setEditable(false);
    tfC1Radius.setEditable(false);
    tfC1CenterX.setText(String.valueOf(c1.getCenterX()));
    tfC1CenterY.setText(String.valueOf(c1.getCenterY()));
    tfC1Radius.setText(String.valueOf(c1.getRadius()));

    VBox c2VBox = new VBox();
    GridPane c2GridPane = new GridPane();
    Label lbC2Info = new Label("Enter circle 2 info:");
    Label lbC2CenterX = new Label("Center x:");
    Label lbC2CenterY = new Label("Center y:");
    Label lbC2Radius = new Label("Radius:");
    TextField tfC2CenterX = new TextField();
    TextField tfC2CenterY = new TextField();
    TextField tfC2Radius = new TextField();
    c2GridPane.addColumn(0, lbC2CenterX, lbC2CenterY, lbC2Radius);
    c2GridPane.addColumn(1, tfC2CenterX, tfC2CenterY, tfC2Radius);
    c2VBox.getChildren().addAll(lbC2Info, c2GridPane);

    tfC2CenterX.setPrefWidth(60);
    tfC2CenterY.setPrefWidth(60);
    tfC2Radius.setPrefWidth(60);
    tfC2CenterX.setEditable(false);
    tfC2CenterY.setEditable(false);
    tfC2Radius.setEditable(false);
    tfC2CenterX.setText(String.valueOf(c2.getCenterX()));
    tfC2CenterY.setText(String.valueOf(c2.getCenterY()));
    tfC2Radius.setText(String.valueOf(c2.getRadius()));

    c1.centerXProperty().addListener(ov -> {
      tfC1CenterX.setText(String.valueOf(c1.getCenterX()));
      tfC1Radius.setText(String.valueOf(c1.getRadius()));
    });

    c1.centerYProperty().addListener(ov -> {
      tfC1CenterY.setText(String.valueOf(c1.getCenterY()));
      tfC1Radius.setText(String.valueOf(c1.getRadius()));
    });

    c2.centerXProperty().addListener(ov -> {
      tfC2CenterX.setText(String.valueOf(c2.getCenterX()));
      tfC2Radius.setText(String.valueOf(c2.getRadius()));
    });

    c2.centerYProperty().addListener(ov -> {
      tfC2CenterY.setText(String.valueOf(c2.getCenterY()));
      tfC2Radius.setText(String.valueOf(c2.getRadius()));
    });

    c1.setOnMouseDragged(e -> {
      c1.setCenterX(e.getX());
      c1.setCenterY(e.getY());
      if (doIntersect(c1, c2)) {
        lbIntersect.setText("Two circles intersect? Yes");
      } else {
        lbIntersect.setText("Two circles intersect? No");
      }
    });

    c2.setOnMouseDragged(e -> {
      c2.setCenterX(e.getX());
      c2.setCenterY(e.getY());
      if (doIntersect(c1, c2)) {
        lbIntersect.setText("Two circles intersect? Yes");
      } else {
        lbIntersect.setText("Two circles intersect? No");
      }
    });

    HBox infoPane = new HBox(10);
    infoPane.getChildren().addAll(c1VBox, c2VBox);

    Button btRedraw = new Button("Redraw Circles");

    btRedraw.setOnAction(e -> {
      c1.setCenterX(52);
      c1.setCenterY(60);
      c2.setCenterX(180);
      c2.setCenterY(56);
    });

    VBox pane = new VBox();
    pane.getChildren().addAll(lbIntersect, circlePane, infoPane, btRedraw);
    pane.setAlignment(Pos.CENTER);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E16_08");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static boolean doIntersect(Circle c1, Circle c2) {
    double x1 = c1.getCenterX();
    double y1 = c1.getCenterY();
    double x2 = c2.getCenterX();
    double y2 = c2.getCenterY();
    double distance = distance(x1, y1, x2, y2);

    if (distance < c1.getRadius() + c2.getRadius()) {
      return true;
    }

    return false;
  }

  public static double distance(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
  }

  public static void main(String[] args) {
    launch(args);
  }
}
