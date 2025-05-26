import java.util.*;

public class LambdaSortExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> al = new ArrayList<>();

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            String str = sc.nextLine();
            al.add(str);
        }

        Collections.sort(al, (s1, s2) -> s1.compareTo(s2));

        System.out.println("\nSorted list of strings:");
        for (String s : al) {
            System.out.println(s);
        }

        sc.close();
    }
}
