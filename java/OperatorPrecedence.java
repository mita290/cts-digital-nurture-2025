public class OperatorPrecedence {
    public static void main(String[] args) {
        // Expression 1
        int result1 = 10 + 5 * 2;
        System.out.println("Result of 10 + 5 * 2 = " + result1);
        // Explanation: Multiplication (*) has higher precedence than addition (+)
        // So, 5 * 2 = 10, then 10 + 10 = 20

        // Expression 2 with parentheses
        int result2 = (10 + 5) * 2;
        System.out.println("Result of (10 + 5) * 2 = " + result2);
        // Explanation: Parentheses change the precedence
        // So, 10 + 5 = 15, then 15 * 2 = 30

        // Expression 3 with multiple operators
        int result3 = 100 / 5 + 3 * 4 - 8;
        System.out.println("Result of 100 / 5 + 3 * 4 - 8 = " + result3);
        // Explanation:
        // 100 / 5 = 20
        // 3 * 4 = 12
        // So, 20 + 12 = 32, then 32 - 8 = 24

        // Expression 4 with modulus
        int result4 = 20 + 10 % 3 * 4;
        System.out.println("Result of 20 + 10 % 3 * 4 = " + result4);
        // Explanation:
        // 10 % 3 = 1
        // 1 * 4 = 4
        // 20 + 4 = 24
    }
}
