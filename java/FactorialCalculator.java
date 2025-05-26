import java.util.*;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");
        int number = sc.nextInt();

        if (number < 0) {
            System.out.println("Invalid input! Please enter a non-negative integer.");
        } else {
            long factorial = 1;

            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }

            System.out.println("Factorial of " + number + " is " + factorial);
        }

        sc.close();
    }
}
