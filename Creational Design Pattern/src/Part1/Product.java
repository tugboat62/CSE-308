package Part1;

import java.util.LinkedList;

public class Product {
    private LinkedList<String> components;

    public Product () {
        components = new LinkedList<>();
    }

    public void Add(String newComponent) {
        components.add(newComponent);
    }

    public void Show() {
        System.out.println("Product contains below components:");
        for (int i=0; i<components.size(); i++) {
            System.out.println(components.get(i));
        }
    }

}
