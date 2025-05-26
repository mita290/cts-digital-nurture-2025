import java.util.*;

public class MultiplicationTable {
    public static void fun(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " * " + n +" = " + (n * i));
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number:");
        int n = sc.nextInt();
        fun(n);
        sc.close();
    }
}
