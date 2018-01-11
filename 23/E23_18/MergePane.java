import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class MergePane extends Pane {
  private int stateIndex;
  private int[] originalList1;
  private int[] originalList2;
  private int[] emptyTemp;
  private ArrayList<MergeState> states;

  public MergePane() {
    set();
  }

  private void drawPane(boolean orig) {
    getChildren().clear();

    final double WIDTH = 600.0;
    final double HEIGHT = 300.0;
    setPrefSize(WIDTH, HEIGHT);

    int[] list1 = orig ? originalList1 : states.get(stateIndex).getList1();
    int[] list2 = orig ? originalList2 : states.get(stateIndex).getList2();
    int[] temp = orig ? emptyTemp : states.get(stateIndex).getTemp();
    int current1 = orig ? -1 : states.get(stateIndex).getCurrent1();
    int current2 = orig ? -1 : states.get(stateIndex).getCurrent2();
    int current3 = orig ? -1 : states.get(stateIndex).getCurrent3();

    double xPos = 10.0;
    double yPos = 50.0;
    Text tList1 = new Text(xPos, yPos + 15, "list1");
    getChildren().add(tList1);
    xPos += 30.0;
    for (int i = 0; i < list1.length; i++) {
      Rectangle r = new Rectangle(xPos, yPos, 25, 20);
      r.setFill(Color.WHITE);
      r.setStroke(Color.BLACK);
      Text tNum = new Text(r.getX(), r.getY() + 15, list1[i] + "");
      getChildren().addAll(r, tNum);
      if (!orig && i == current1) {
        Text tCurrent1 = new Text(r.getX() + 5, r.getY() - 5, "C1");
        getChildren().add(tCurrent1);
      }
      xPos += 30.0;
    }

    xPos += 30.0;
    Text tList2 = new Text(xPos, yPos + 15, "list2");
    getChildren().add(tList2);
    xPos += 30.0;
    for (int i = 0; i < list1.length; i++) {
      Rectangle r = new Rectangle(xPos, yPos, 25, 20);
      r.setFill(Color.WHITE);
      r.setStroke(Color.BLACK);
      Text tNum = new Text(r.getX(), r.getY() + 15, list2[i] + "");
      getChildren().addAll(r, tNum);
      if (!orig && i == current2) {
        Text tCurrent2 = new Text(r.getX() + 5, r.getY() - 5, "C2");
        getChildren().add(tCurrent2);
      }
      xPos += 30.0;
    }

    xPos = 10.0;
    yPos = 100.0;
    Text tTemp = new Text(xPos, yPos + 15, "temp");
    getChildren().add(tTemp);
    xPos += 35.0;
    for (int i = 0; i < temp.length; i++) {
      Rectangle r = new Rectangle(xPos, yPos, 25, 20);
      r.setFill(Color.WHITE);
      r.setStroke(Color.BLACK);
      Text tNum = new Text(r.getX(), r.getY() + 15, temp[i] + "");
      getChildren().addAll(r, tNum);
      if (!orig && i == current3) {
        Text tCurrent3 = new Text(r.getX() + 5, r.getY() + 40, "C3");
        getChildren().add(tCurrent3);
      }
      xPos += 30.0;
    }
  }

  public boolean step() {
    if (stateIndex >= states.size() - 1) { drawPane(false); return true; }
    drawPane(false);
    stateIndex++;
    return false;
  }

  public void reset() {
    set();
  }

  private void set() {
    stateIndex = 0;
    originalList1 = getRandomList();
    originalList2 = getRandomList();
    emptyTemp = new int[16];
    states =
      MergeState.getStates(
        Arrays.copyOf(originalList1, originalList1.length),
        Arrays.copyOf(originalList2, originalList2.length),
        Arrays.copyOf(emptyTemp, emptyTemp.length)
      );
    drawPane(true);
  }

  private static int[] getRandomList() {
    int[] list = new int[8];
    for (int i = 0; i < list.length; i++) {
      list[i] = (int)(Math.random() * 999) + 1;
    }
    Arrays.sort(list);
    return list;
  }
}
