package Part1;

public class CommunicationFactory {
    public Communication getCommunication(String comm) {
        if (comm == null) return null;
        if (comm.equalsIgnoreCase("wifi")) return new Wifi();
        if (comm.equalsIgnoreCase("mobile")) return new Mobile();
        return null;
    }


}
