import java.io.*;
import java.util.*;

public class FileReading {
    public static void main(String[] args) {
        try {
            File file = new File("output.txt");
            Scanner sc = new Scanner(file);

            System.out.println("Contents of output.txt:");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: output.txt");
        }
    }
}
