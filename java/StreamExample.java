import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> al = new ArrayList<>();

        System.out.print("Enter number of integers: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            int num = sc.nextInt();
            al.add(num);
        }

        List<Integer> evenNumbers = al.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());

        System.out.println("\nEven numbers:");
        for (int num : evenNumbers) {
            System.out.println(num);
        }

        sc.close();
    }
}
