package Part2;

public class FactoryProducer {
    public static AbstractFactory getFactory(String name) {
        if (name.equalsIgnoreCase("Parser")) return new ParserFactory();
        else if (name.equalsIgnoreCase("Font")) return new FontFactory();
        else if (name.equalsIgnoreCase("Environment")) return new EnvironmentFactory();
        else return null;
    }
}
