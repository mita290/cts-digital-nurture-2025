public class InspectJavaBytecode {
    public int square(int x) {
        return x * x;
    }

    public static void main(String[] args) {
        InspectJavaBytecode d = new InspectJavaBytecode();
        System.out.println("Square of 5 is: " + d.square(5));
    }
}


/* Output
 Compiled from "InspectJavaBytecode.java"
public class InspectJavaBytecode {
  public InspectJavaBytecode();
  public int square(int);
  public static void main(java.lang.String[]);
}
 */