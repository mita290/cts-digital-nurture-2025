
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("Superhero");

        Method[] methods = cls.getDeclaredMethods();
        System.out.println("Methods in Superhero:");
        for (Method m : methods) {
            System.out.println("- " + m.getName());
        }

        Constructor<?> constructor = cls.getConstructor(String.class);
        Object hero = constructor.newInstance("Phoenix");

        Method greetMethod = cls.getDeclaredMethod("greet");
        greetMethod.invoke(hero);

        Method flyMethod = cls.getDeclaredMethod("fly");
        flyMethod.invoke(hero);
    }
}


/* Output
    Methods in Superhero:
    - greet
    - fly
    Hello, I am Phoenix!
    Phoenix is flying!
 */