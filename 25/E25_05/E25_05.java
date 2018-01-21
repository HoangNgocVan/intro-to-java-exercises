/*
  Implement the postorder method in BST using a stack instead of recursion.
  Write a test program that prompts the user to enter 10 integers, stores them
  in a BST, and invokes the postorder method to display the elements.
*/

public class E25_05 {
  public static void main(String[] args) {
    String[] list = {"George", "Ben", "Mark", "Adam", "Carl", "Mack", "Nick"};
    BST<String> tree = new BST<>(list);

    tree.postorder();
    System.out.println();
  }
}
