import java.util.*;
import java.util.stream.*;

record Person(String name, int age) {}

public class RecordExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Person> al = new ArrayList<>();

        System.out.print("Enter number of people: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter age: ");
            int age = sc.nextInt();
            sc.nextLine(); 
            al.add(new Person(name, age));
        }

        System.out.println("\nAll Persons:");
        for (Person p : al) {
            System.out.println(p);
        }

        List<Person> adults = al.stream()
                                .filter(p -> p.age() > 18)
                                .collect(Collectors.toList());

        System.out.println("\nPersons older than 18:");
        for (Person p : adults) {
            System.out.println(p);
        }

        sc.close();
    }
}
