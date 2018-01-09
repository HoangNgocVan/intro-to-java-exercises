import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

public class SortVisualizer extends BorderPane {

  public SortVisualizer() {
    drawGUI();
  }

  private void drawGUI() {
    SortPane sPane = new SortPane();
    sPane.setStyle("-fx-border-color: black");

    Button btStep = new Button("Step");
    Button btReset = new Button("Reset");

    btStep.setOnAction(e -> sPane.step());
    btReset.setOnAction(e -> sPane.reset());

    HBox hbControl  = new HBox(10);
    hbControl.getChildren().addAll(btStep, btReset);
    hbControl.setAlignment(Pos.CENTER);

    setCenter(sPane);
    setBottom(hbControl);
  }
}
