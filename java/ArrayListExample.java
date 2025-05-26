import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> al = new ArrayList<>();

        System.out.print("Enter the number of students: ");
        int count = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < count; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            String name = sc.nextLine();
            al.add(name);
        }

        System.out.println("List of student names:");
        for (String name : al) {
            System.out.println(name);
        }

        sc.close();
    }
}
