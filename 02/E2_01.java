import java.util.Scanner;

public class E2_01 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a degree in Celsius: ");
    double celsius = input.nextDouble();

    double fahrenheit = celsiusToFahrenheit(celsius);

    System.out.println(celsius + " Celsius is " + fahrenheit + " Fahrenheit");
  }

  private static double celsiusToFahrenheit(double celsius) {
    return (9.0 / 5) * celsius + 32;
  }
}
