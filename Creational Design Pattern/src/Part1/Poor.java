package Part1;

public class Poor implements IBuilder{
    private Product product;
    private String communication;
    private int displayNo;
    private double cost;
    private double commCost;
    private CommunicationFactory communicationFactory;
    Communication c;

    Poor(String comm, int d) {
        communication = comm;
        displayNo = d;
        product = new Product();
        cost = 10;
        communicationFactory = new CommunicationFactory();
        c = communicationFactory.getCommunication(communication);
        c.setPrice();
        commCost = c.getPrice();
    }

    @Override
    public void setDisplayUnit() {
        product.Add("Display unit: ATMega32 with LED matrix");
        product.Add("Total display units: "+displayNo);
    }

    @Override
    public void setCommunication() {
        product.Add("Communication Channel: "+communication);
    }

    @Override
    public void setCost() {
        double totalCost = (cost + commCost) * displayNo;
        product.Add("Total cost: "+totalCost+"$.");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
