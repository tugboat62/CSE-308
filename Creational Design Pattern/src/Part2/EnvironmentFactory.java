package Part2;

public class EnvironmentFactory extends AbstractFactory {
    @Override
    Parser getParser(String name) {
        return null;
    }

    @Override
    Font getFont(String name) {
        return null;
    }

    @Override
    Environment getEnvironment(String name) {
        if (name.equals("c")) return new CEnvironment();
        else if (name.equals("cpp")) return new CPPEnvironment();
        else if (name.equals("py")) return new PythonEnvironment();
        else return null;
    }
}
