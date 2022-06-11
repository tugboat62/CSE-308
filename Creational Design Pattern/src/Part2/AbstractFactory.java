package Part2;

public abstract class AbstractFactory {
    abstract Parser getParser(String name);
    abstract Font getFont(String name);
    abstract Environment getEnvironment(String name);
}
