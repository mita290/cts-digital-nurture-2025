import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String> hm = new HashMap<>();

        System.out.print("Enter the number of students: ");
        int count = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < count; i++) {
            System.out.print("Enter student ID: ");
            int id = sc.nextInt();
            sc.nextLine(); 
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            hm.put(id, name);
        }

        System.out.print("Enter a student ID to search: ");
        int searchId = sc.nextInt();

        if (hm.containsKey(searchId)) {
            System.out.println("Student Name: " + hm.get(searchId));
        } else {
            System.out.println("Student ID not found.");
        }

        sc.close();
    }
}
