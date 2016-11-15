/**
 * Created for Breaker by Max on 14.11.2016.
 */
public class Bruchrechnen {
    int zaehler;
    int nenner;
    public Bruchrechnen(int zahl, int nenn) {
        zaehler = zahl;
        nenner = nenn;
    }
    public void erweitern(int mit) {
        nenner = nenner * mit;
        zaehler = zaehler * mit;
    }
}