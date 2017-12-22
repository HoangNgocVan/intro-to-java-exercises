public class LinearSearchState {
  int[] array;
  int key;
  int index;
  boolean wasFound = false;

  public LinearSearchState(int[] array, int key, int index) {
    this.array = array;
    this.key = key;
    this.index = index;
  }

  public int[] getArray() {
    return array;
  }

  public int getKey() {
    return key;
  }

  public int getIndex() {
    return index;
  }

  public boolean getFound() {
    return wasFound;
  }

  private void setFound(boolean found) {
    wasFound = found;
  }

  public static LinearSearchState[] generateSearchStates(int[] array, int key) {
    LinearSearchState[] states = new LinearSearchState[array.length];
    for (int i = 0; i < array.length; i++) {
      LinearSearchState lss = new LinearSearchState(array, key, i);
      states[i] = lss;
      if (key == array[i]) { lss.setFound(true); break; }
    }
    return states;
  }

  @Override
  public String toString() {
    return "array: " + array + "\n" +
           "key: " + key + "\n" +
           "index: " + index + "\n" +
           "wasFound: " + wasFound + "\n";
  }
}
