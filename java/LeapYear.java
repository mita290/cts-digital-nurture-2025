import java.util.*;

public class LeapYear {
    public static boolean fun(int n) {
        if (n % 4 == 0) {
            if (n % 100 == 0) {
                return n % 400 == 0;
            }
            return true;
        }
        return false;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter year:");
        int n = sc.nextInt();
        if (fun(n)) {
            System.out.println(n + " is a leap year.");
        } else {
            System.out.println(n + " is not a leap year.");
        }
        sc.close();
    }
}
