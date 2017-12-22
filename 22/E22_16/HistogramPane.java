import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

public class HistogramPane extends Pane {
  private static int[] searchSet = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
    14, 15, 16, 17, 18, 19, 20};
  private static final double WIDTH = 500.0;
  private static final double PANE_HEIGHT = 300.0;
  private static final double MAX_BAR_HEIGHT = 250.0;
  private static final double BAR_WIDTH = (WIDTH - 20) / searchSet.length;

  private LinearSearchState[] states;
  private Rectangle[] bars;

  public HistogramPane() {
    setPrefSize(WIDTH, PANE_HEIGHT);
    setStyle("-fx-border-color: black");
    setUp();
  }

  public LinearSearchState[] getStates() {
    return states;
  }

  public Rectangle[] getBars() {
    return bars;
  }

  public int[] getSearchSet() {
    return searchSet;
  }

  public void setUp() {
    states = null;
    shuffleSearchSet();
    drawBars();
  }

  private void drawBars() {
    getChildren().clear();
    bars = new Rectangle[searchSet.length];
    double xVal = 10.0;
    for (int i = 0; i < searchSet.length; i++, xVal += BAR_WIDTH) {
      double height = searchSet[i] / (double)searchSet.length * MAX_BAR_HEIGHT;
      Rectangle r = new Rectangle(xVal, PANE_HEIGHT - height, BAR_WIDTH, height);
      r.setFill(Color.WHITE);
      r.setStroke(Color.BLACK);
      Text t = new Text(r.getX() + 5, r.getY() - 5, searchSet[i] + "");
      getChildren().addAll(r, t);
      bars[i] = r;
    }
  }

  public void paintBarsWhite() {
    for (int i = 0; i < bars.length; i++) {
      bars[i].setFill(Color.WHITE);
    }
  }

  private void shuffleSearchSet() {
    for (int i = 0; i < searchSet.length; i++) {
      int randomIndex = (int)(Math.random() * searchSet.length);
      if (i != randomIndex) {
        int temp = searchSet[i];
        searchSet[i] = searchSet[randomIndex];
        searchSet[randomIndex] = temp;
      }
    }
  }

  public void getSearchStates(int key) {
    states = LinearSearchState.generateSearchStates(searchSet, key);
  }
}
