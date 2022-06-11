package Part1;

public class Director {
    IBuilder myBuilder;

    public void Construct(IBuilder builder){
        myBuilder = builder;
        myBuilder.setDisplayUnit();
        myBuilder.setCommunication();
        myBuilder.setCost();
    }

}
