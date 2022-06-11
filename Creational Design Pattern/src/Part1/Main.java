package Part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Director director = new Director();

        BufferedReader br = new BufferedReader(new FileReader("input1.txt"));
        String line = br.readLine();
        while (line != null) {
            line = line.trim();
            String[] p = line.split("\\s+|\\t+");
            String type = p[0].toLowerCase();
            String comm = p[1].toLowerCase();
            int units = Integer.parseInt(p[2]);

            if (type.equals("deluxe")){
                IBuilder deluxeBuilder = new Deluxe(comm, units);
                director.Construct(deluxeBuilder);
                Product product = deluxeBuilder.getProduct();
                product.Show();
            }
            else if (type.equals("optimal")){
                IBuilder optimalBuilder = new Optimal(comm, units);
                director.Construct(optimalBuilder);
                Product product = optimalBuilder.getProduct();
                product.Show();
            }
            else if (type.equals("poor")) {
                IBuilder poorBuilder = new Poor(comm, units);
                director.Construct(poorBuilder);
                Product product = poorBuilder.getProduct();
                product.Show();
            }
            System.out.println();
            line = br.readLine();
        }

        br.close();
    }
}
