public class PatternMatchingSwitchExample {

    public static void checkType(Object obj) {
        switch (obj) {
            case Integer i -> System.out.println("The object is an Integer: " + i);
            case String s -> System.out.println("The object is a String: " + s);
            case Double d -> System.out.println("The object is a Double: " + d);
            case Boolean b -> System.out.println("The object is a Boolean: " + b);
            case null -> System.out.println("The object is null.");
            default -> System.out.println("Unknown type: " + obj);
        }
    }

    public static void main(String[] args) {
        checkType(42);
        checkType("Hello");
        checkType(3.14);
        checkType(true);
        checkType(null);
        checkType(new Object());
    }
}
