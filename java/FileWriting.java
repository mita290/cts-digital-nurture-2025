import java.util.*;
import java.io.*;

public class FileWriting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string to write to the file: ");
        String input = sc.nextLine();

        try {
            FileWriter fw = new FileWriter("output.txt");
            fw.write(input);
            fw.close();
            System.out.println("Data has been written to output.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
        sc.close();
    }
}