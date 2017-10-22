/*
  Rewrite Listing 3.5, ComputeTax.java, using arrays. For each filing status,
  there are six tax rates. Each rate is applied to a certain amount of taxable
  income. For example, from the taxable income of $400,000 for a single filer,
  $8,350 is taxed at 10%, (33,950 - 8,350) at 15%, and so on. The six rates
  are the same for all filing statuses, which can be represented in the
  following array:

  double[] rates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35}

  The brackets for each rate for all the filing statuses can be represented
  int a two-dimensional array as follows:

  int[][] brackets = {
    {8350, 33950, 82250, 171550, 372950}, // single filer
    {16700, 67900, 137050, 208850, 372950},  // married jointly
    {8350, 33950, 68525, 104425, 186475},  // married separately
    {11950, 45500, 117450, 190200, 372950}  // head of household
  }

  Suppose the taxable income is $400,000 for single filers. The tax can be
  computed as follows:

  tax = brackets[0][0] * rates[0] +
    (brackets[0][1] - brackets[0][0]) * rates[1] +
    (brackets[0][2] - brackets[0][1]) * rates[2] +
    (brackets[0][3] - brackets[0][2]) * rates[3] +
    (brackets[0][4] - brackets[0][3]) * rates[4] +
    (400000 - brackets[0][4]) * rates[5]
*/

import java.util.Scanner;

public class E8_12 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("0: Single Filer");
    System.out.println("1: Married Jointly or Qualifying Widow(er)");
    System.out.println("2: Married Separately");
    System.out.println("3: Head of Household");
    System.out.print("Enter the filing status: ");
    int status = input.nextInt();
    System.out.print("Enter the taxable income: ");
    double income = input.nextDouble();

    System.out.println("The total tax is " + computeTax(status, income));
  }

  public static double computeTax(int status, double income) {
    double[] rates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};

    int[][] brackets = {
      {8350, 33950, 82250, 171550, 372950}, // 0 - single filer
      {16700, 67900, 137050, 208850, 372950},  // 1 - married jointly
      {8350, 33950, 68525, 104425, 186475},  // 2 - married separately
      {11950, 45500, 117450, 190200, 372950}  // 3 - head of household
    };

    double tax = brackets[status][0] * rates[0] +
      (brackets[status][1] - brackets[status][0]) * rates[1] +
      (brackets[status][2] - brackets[status][1]) * rates[2] +
      (brackets[status][3] - brackets[status][2]) * rates[3] +
      (brackets[status][4] - brackets[status][3]) * rates[4] +
      (income - brackets[status][4]) * rates[5];

    return tax;
  }
}
