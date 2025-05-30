public class TypeCasting {
    public static void main(String[] args) {
        double decimalValue = 9.78;
        
        int intValue = (int) decimalValue;
        
        System.out.println("Original double value: " + decimalValue);
        System.out.println("After casting to int: " + intValue);

        int wholeNumber = 42;

        double convertedDouble = wholeNumber;

        System.out.println("Original int value: " + wholeNumber);
        System.out.println("After casting to double: " + convertedDouble);
    }
}
