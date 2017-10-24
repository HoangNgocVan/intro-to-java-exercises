

public class E10_02 {
  public static void main(String[] args) {
    BMI bmi1 = new BMI("Kim Yang", 18, 145, 70);
    System.out.println("The BMI for " + bmi1.getName() + " is " +
      bmi1.getBMI() + " " + bmi1.getStatus());

    BMI bmi2 = new BMI("Susan King", 215, 70);
    System.out.println("The BMI for " + bmi2.getName() + " is " +
      bmi2.getBMI() + " " + bmi2.getStatus());

    BMI bmi3 = new BMI("John Doe", 25, 200, 6, 7);
    System.out.println("The BMI for " + bmi3.getName() + " is " +
      bmi3.getBMI() + " " + bmi3.getStatus());
  }

  private static class BMI {
    private String name;
    private int age;
    private double weight; // in pounds
    private double height; // in inches
    static final double KILOGRAMS_PER_POUND = 0.45359237;
    static final double METERS_PER_INCH = 0.0254;

    BMI(String name, int age, double weight, double height) {
      this.name = name;
      this.age = age;
      this.weight = weight;
      this.height = height;
    }

    BMI(String name, double weight, double height) {
      this(name, 20, weight, height);
    }

    BMI(String name, int age, double weight, double feet, double inches) {
      this(name, age, weight, (feet * 12) + inches);
    }

    // instance methods
    double getBMI() {
      double bmi = weight * KILOGRAMS_PER_POUND /
        ((height * METERS_PER_INCH) * (height * METERS_PER_INCH));
      return Math.round(bmi * 100) / 100.0;
    }

    String getStatus() {
      double bmi = getBMI();
      if (bmi < 18.5) { return "Underweight"; }
      else if (bmi < 25) { return "Normal"; }
      else if (bmi < 30) { return "Overweight"; }
      else { return "Obese"; }
    }

    // getters
    String getName() {
      return name;
    }

    int getAge() {
      return age;
    }

    double getWeight() {
      return weight;
    }

    double getHeight() {
      return height;
    }
  }
}
