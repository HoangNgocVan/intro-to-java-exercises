/*
  Write a program that enables the user to specify the location and size of
  the rectangles and displays whether two rectangles intersect. Enable the user
  to point the mouse inside a rectangle and drag it. As the rectangle is being
  dragged, the rectangle's center coordinates in the text field are updated.
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
import javafx.scene.shape.Rectangle;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;

public class E16_09 extends Application {
  @Override
  public void start(Stage primaryStage) {
    Label lbIntersect = new Label();

    Pane rectPane = new Pane();
    rectPane.setMinWidth(300);
    rectPane.setMinHeight(300);
    rectPane.setStyle("-fx-border-color: black");
    Rectangle r1 = new Rectangle(79, 20, 40, 50);
    Rectangle r2 = new Rectangle(150, 33, 50, 20);
    r1.setFill(Color.TRANSPARENT);
    r1.setStroke(Color.BLACK);
    r2.setFill(Color.TRANSPARENT);
    r2.setStroke(Color.BLACK);
    rectPane.getChildren().addAll(r1, r2);

    VBox r1VBox = new VBox();
    GridPane r1GridPane = new GridPane();
    Label lbR1Info = new Label("Enter rectangle 1 info:");
    Label lbR1CenterX = new Label("X:");
    Label lbR1CenterY = new Label("Y:");
    Label lbR1Width = new Label("Width:");
    Label lbR1Height = new Label("Height:");
    TextField tfR1CenterX = new TextField();
    TextField tfR1CenterY = new TextField();
    TextField tfR1Width = new TextField();
    TextField tfR1Height = new TextField();
    r1GridPane.addColumn(0, lbR1CenterX, lbR1CenterY, lbR1Width, lbR1Height);
    r1GridPane.addColumn(1, tfR1CenterX, tfR1CenterY, tfR1Width, tfR1Height);
    r1VBox.getChildren().addAll(lbR1Info, r1GridPane);
    r1VBox.setStyle("-fx-border-color: black");

    tfR1CenterX.setPrefWidth(60);
    tfR1CenterY.setPrefWidth(60);
    tfR1Width.setPrefWidth(60);
    tfR1Height.setPrefWidth(60);
    tfR1CenterX.setEditable(false);
    tfR1CenterY.setEditable(false);
    tfR1Width.setEditable(false);
    tfR1Height.setEditable(false);
    tfR1CenterX.setText(String.valueOf(getCenterX(r1)));
    tfR1CenterY.setText(String.valueOf(getCenterY(r1)));
    tfR1Width.setText(String.valueOf(r1.getWidth()));
    tfR1Height.setText(String.valueOf(r1.getHeight()));

    VBox r2VBox = new VBox();
    GridPane r2GridPane = new GridPane();
    Label lbR2Info = new Label("Enter rectangle 2 info:");
    Label lbR2CenterX = new Label("X:");
    Label lbR2CenterY = new Label("Y:");
    Label lbR2Width = new Label("Width:");
    Label lbR2Height = new Label("Height:");
    TextField tfR2CenterX = new TextField();
    TextField tfR2CenterY = new TextField();
    TextField tfR2Width = new TextField();
    TextField tfR2Height = new TextField();
    r2GridPane.addColumn(0, lbR2CenterX, lbR2CenterY, lbR2Width, lbR2Height);
    r2GridPane.addColumn(1, tfR2CenterX, tfR2CenterY, tfR2Width, tfR2Height);
    r2VBox.getChildren().addAll(lbR2Info, r2GridPane);
    r2VBox.setStyle("-fx-border-color: black");

    tfR2CenterX.setPrefWidth(60);
    tfR2CenterY.setPrefWidth(60);
    tfR2Width.setPrefWidth(60);
    tfR2Height.setPrefWidth(60);
    tfR2CenterX.setEditable(false);
    tfR2CenterY.setEditable(false);
    tfR2Width.setEditable(false);
    tfR2Height.setEditable(false);
    tfR2CenterX.setText(String.valueOf(getCenterX(r2)));
    tfR2CenterY.setText(String.valueOf(getCenterY(r2)));
    tfR2Width.setText(String.valueOf(r2.getWidth()));
    tfR2Height.setText(String.valueOf(r2.getHeight()));

    r1.xProperty().addListener(ov -> {
      tfR1CenterX.setText(String.valueOf(getCenterX(r1)));
      tfR1Width.setText(String.valueOf(r1.getHeight()));
    });

    r1.yProperty().addListener(ov -> {
      tfR1CenterY.setText(String.valueOf(getCenterY(r1)));
      tfR1Height.setText(String.valueOf(r1.getHeight()));
    });

    r2.xProperty().addListener(ov -> {
      tfR2CenterX.setText(String.valueOf(getCenterX(r2)));
      tfR2Width.setText(String.valueOf(r2.getWidth()));
    });

    r2.yProperty().addListener(ov -> {
      tfR2CenterY.setText(String.valueOf(getCenterY(r2)));
      tfR2Height.setText(String.valueOf(r2.getHeight()));
    });

    r1.setOnMouseDragged(e -> {
      r1.setX(e.getX());
      r1.setY(e.getY());
      if (doIntersect(r1, r2)) {
        lbIntersect.setText("Two rectangles intersect? Yes");
      } else {
        lbIntersect.setText("Two rectangles intersect? No");
      }
    });

    r2.setOnMouseDragged(e -> {
      r2.setX(e.getX());
      r2.setY(e.getY());
      if (doIntersect(r1, r2)) {
        lbIntersect.setText("Two rectangles intersect? Yes");
      } else {
        lbIntersect.setText("Two rectangles intersect? No");
      }
    });

    HBox infoPane = new HBox(10);
    infoPane.getChildren().addAll(r1VBox, r2VBox);
    infoPane.setAlignment(Pos.CENTER);

    Button btRedraw = new Button("Redraw Rectangles");

    btRedraw.setOnAction(e -> {
      r1.setX(79);
      r1.setY(20);
      r2.setX(150);
      r2.setY(33);

      lbIntersect.setText("Two rectangles intersect? " +
        (doIntersect(r1, r2) ? "Yes" : "No"));
    });

    lbIntersect.setText("Two rectangles intersect? " +
      (doIntersect(r1, r2) ? "Yes" : "No"));

    VBox pane = new VBox();
    pane.getChildren().addAll(lbIntersect, rectPane, infoPane, btRedraw);
    pane.setAlignment(Pos.CENTER);
    pane.setMargin(btRedraw, new Insets(20));
    pane.setMargin(rectPane, new Insets(20));

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E16_08");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static boolean doIntersect(Rectangle r1, Rectangle r2) {
    Point2D[] r1Points = getCornerPoints(r1);
    Point2D[] r2Points = getCornerPoints(r2);

    for (int i = 0; i < r1Points.length; i++) {
      if (r2.contains(r1Points[i]) || r1.contains(r2Points[i])) {
        return true;
      }
    }

    return false;
  }

  public static double getCenterX(Rectangle r) {
    return r.getX() + (r.getWidth() / 2);
  }

  public static double getCenterY(Rectangle r) {
    return r.getY() + (r.getHeight() / 2);
  }

  public static Point2D[] getCornerPoints(Rectangle r) {
    Point2D[] points = new Point2D[4];
    points[0] = new Point2D(r.getX(), r.getY());
    points[1] = new Point2D(r.getX() + r.getWidth(), r.getY());
    points[2] = new Point2D(r.getX() + r.getWidth(), r.getY() + r.getHeight());
    points[3] = new Point2D(r.getX(), r.getY() + r.getHeight());
    return points;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
