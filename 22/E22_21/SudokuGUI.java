import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

public class SudokuGUI extends BorderPane {

  public SudokuGUI() {
    drawGUI();
  }

  private void drawGUI() {
    Text tMessage = new Text();
    SudokuPane sPane = new SudokuPane();
    Button btSolve = new Button("Solve");
    Button btClear = new Button("Clear");

    btSolve.setOnAction(e -> solve(sPane, tMessage));
    btClear.setOnAction(e -> clear(sPane, tMessage));

    HBox hbControl = new HBox(10);
    hbControl.getChildren().addAll(btSolve, btClear);
    hbControl.setAlignment(Pos.CENTER);

    setTop(tMessage);
    setCenter(sPane);
    setBottom(hbControl);
    setAlignment(tMessage, Pos.CENTER);
  }

  private void solve(SudokuPane sPane, Text tMessage) {
    try {
      if (!sPane.solve()) {
        tMessage.setText("Only 1-9 or empty spaces allowed");
      }
    } catch (IllegalArgumentException ex) {
      tMessage.setText("Invalid Sudoku Grid");
    }
  }

  private void clear(SudokuPane sPane, Text tMessage) {
    sPane.clear();
    tMessage.setText("");
  }
}
