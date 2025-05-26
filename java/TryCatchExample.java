import java.util.*;

public class TryCatchExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the dividend: ");
        int numerator = sc.nextInt();

        System.out.print("Enter the divisor: ");
        int denominator = sc.nextInt();

        try {
            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        }

        sc.close();
    }
}
