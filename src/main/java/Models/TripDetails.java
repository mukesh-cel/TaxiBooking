package Models;

public class TripDetails {
    private int cabdriverId;
    private char Source;
    private char Destinatoin;
    private int CustomerId;
    private double Zulacommisionpertrip;
    private int Fare;

    public TripDetails(char source, char destinatoin, int customerId, double zulacommisionpertrip, int fare,int cabdriverid) {
        Source = source;
        Destinatoin = destinatoin;
        CustomerId = customerId;
        Zulacommisionpertrip = zulacommisionpertrip;
        Fare = fare;
        cabdriverId=cabdriverid;
    }

    public int getCabdriverId() {
        return cabdriverId;
    }

    public void setCabdriverId(int cabdriverId) {
        this.cabdriverId = cabdriverId;
    }

    public char getSource() {
        return Source;
    }

    public void setSource(char source) {
        Source = source;
    }

    public char getDestinatoin() {
        return Destinatoin;
    }

    public void setDestinatoin(char destinatoin) {
        Destinatoin = destinatoin;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public double getZulacommisionpertrip() {
        return Zulacommisionpertrip;
    }

    public void setZulacommisionpertrip(double zulacommisionpertrip) {
        Zulacommisionpertrip = zulacommisionpertrip;
    }

    public int getFare() {
        return Fare;
    }

    public void setFare(int fare) {
        Fare = fare;
    }
}
