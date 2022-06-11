package Part2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AbstractFactory parserFactory = FactoryProducer.getFactory("Parser");
        AbstractFactory fontFactory = FactoryProducer.getFactory("Font");
        AbstractFactory environmentFactory = FactoryProducer.getFactory("Environment");

        BufferedReader br = new BufferedReader(new FileReader("input2.txt"));
        String line = br.readLine();
        while (line != null) {
            line = line.trim();
            String[] p = line.split("[.]");
            String type = p[1].toLowerCase();
            Font font = fontFactory.getFont(type);
            Parser parser = parserFactory.getParser(type);
            Environment environment = environmentFactory.getEnvironment(type);
            System.out.println("File name: " + line + ", " + "Parser: "
                    + parser.getParser() + ", Environment: " +
                    environment.getEnvironment() + ", Font: " + font.getFont());
            System.out.println();
            line = br.readLine();
        }

        br.close();
    }
}
