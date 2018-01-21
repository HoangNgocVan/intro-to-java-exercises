/*
  Implement the preorder method in BST using a stack instead of recursion.
  Write a test program that prompts the user to enter 10 integers, stores them
  in a BST, and invokes the preorder method to display the elements.
*/

public class E25_04 {
  public static void main(String[] args) {
    Integer[] list = {10, 2, 4, 15, 13, 17, 1};
    BST<Integer> tree = new BST<>(list);
    tree.preorder();
    System.out.println();
  }
}
