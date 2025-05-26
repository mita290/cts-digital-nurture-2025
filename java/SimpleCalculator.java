import java.util.*;

public class SimpleCalculator {
    public static int fun(int a, int b, int o) {
        if (o == 1) {
            return a + b;
        } else if (o == 2) {
            return a - b;
        } else if (o == 3) {
            return a * b;
        } else {
            return a / b;
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter number 1:");
            int a = sc.nextInt();
            System.out.println("Enter number 2:");
            int b = sc.nextInt();
            System.out.println("Choose operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Divison");
            System.out.println("5. Exit");
            int op = sc.nextInt();
            if (op == 5) break;
            switch(op) {
                case 1:
                    System.out.println("Sum: " + fun(a, b, op));
                    break;
                case 2:
                    System.out.println("Difference: " + fun(a, b, op));
                    break;
                case 3:
                    System.out.println("Product: " + fun(a, b, op));
                    break;
                case 4:
                    if (b == 0) {
                        System.out.println("Division by 0 not possible");
                        break;
                    }
                    System.out.println("Quotient: " + fun(a, b, op));
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
        sc.close();
    }
}
