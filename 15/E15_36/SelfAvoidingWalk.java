import java.util.ArrayList;

public class SelfAvoidingWalk {
  private boolean[][] grid;
  private int cRow; // current row on grid
  private int cCol; // current column on grid

  public SelfAvoidingWalk(int n) {
    grid = generateGrid(n);
    cRow = n / 2 - 1;
    cCol = n / 2 - 1;
  }

  public int walk() {
    grid[cRow][cCol] = true;

    while (isDoneWalking() == 0) {
      ArrayList<Integer> directions = getValidDirections();
      int r = (int)(Math.random() * directions.size());
      int ranDir = directions.get(r);
      if (ranDir == 0) { cRow--; }
      else if (ranDir == 1) { cCol++; }
      else if (ranDir == 2) { cRow++; }
      else if (ranDir == 3) { cCol--; }
      grid[cRow][cCol] = true;
    }

    // -1 for dead-end path, 1 for non-dead-end path
    return isDoneWalking();
  }

  private int isDoneWalking() {
    if (cRow == 0 || cRow == grid.length - 1 ||
        cCol == 0 || cCol == grid[0].length - 1) {
      // denotes non-dead-end path
      return 1;
    }

    if (grid[cRow - 1][cCol] && grid[cRow + 1][cCol] &&
        grid[cRow][cCol - 1] && grid[cRow][cCol + 1]) {
      // denotes dead-end path
      return -1;
    }

    // not done walking
    return 0;
  }

  private ArrayList<Integer> getValidDirections() {
    ArrayList<Integer> directions = new ArrayList<>();
    if (!grid[cRow - 1][cCol]) { directions.add(0); } // North
    if (!grid[cRow][cCol + 1]) { directions.add(1); } // East
    if (!grid[cRow + 1][cCol]) { directions.add(2); } // South
    if (!grid[cRow][cCol - 1]) { directions.add(3); } // West
    return directions;
  }

  public boolean[][] getGrid() {
    return grid;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < grid.length; i++) {
      sb.append(String.format("%2d", i) + "{ ");
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j]) { sb.append("* "); }
        else { sb.append(". "); }
      }
      sb.append("}\n");
    }
    return sb.toString();
  }

  // Creates a "blank" (all false) boolean grid
  private static boolean[][] generateGrid(int n) {
    return new boolean[n][n];
  }
}
