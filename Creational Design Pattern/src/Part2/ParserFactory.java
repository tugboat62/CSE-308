package Part2;

public class ParserFactory extends AbstractFactory {
    public Parser getParser(String name) {
        if (name.equals("c")) return new CParser();
        else if (name.equals("cpp")) return new CPPParser();
        else if (name.equals("py")) return new PythonParser();
        else return null;
    }

    @Override
    Font getFont(String name) {
        return null;
    }

    @Override
    Environment getEnvironment(String name) {
        return null;
    }

}
