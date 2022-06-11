package Part2;

public class FontFactory extends AbstractFactory {
    @Override
    Parser getParser(String name) {
        return null;
    }

    public Font getFont(String name) {
        if (name.equals("c")) return new CFont();
        else if (name.equals("cpp")) return new CPPFont();
        else if (name.equals("py")) return new PythonFont();
        else return null;
    }

    @Override
    Environment getEnvironment(String name) {
        return null;
    }

}
