/*
  Write a program that displays Welcome to Java five times.
*/

public class E1_02 {
  public static void main(String[] args) {
    for (int i = 0; i < 5; i++) {
      System.out.println("Welcome to Java");
    }
    //OR
    int i = 0;
    while(i < 5){
      System.out.println("Welcome to Java");
    }
    i = 0;
    //OR
    do{
      System.out.println("Welcome to Java");
    }while(i < 5);
  }
}
