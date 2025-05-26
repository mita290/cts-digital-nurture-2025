
public class Superhero {
    private String name;

    public Superhero(String name) {
        this.name = name;
    }

    public void greet() {
        System.out.println("Hello, I am " + name + "!");
    }

    public void fly() {
        System.out.println(name + " is flying!");
    }
}
