import java.util.*;

public class ArraySumAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        double average = (double) sum / n;

        System.out.println("Sum of array elements: " + sum);
        System.out.println("Average of array elements: " + average);

        sc.close();
    }
}
