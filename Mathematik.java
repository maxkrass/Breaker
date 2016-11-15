/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class Mathematik    {

    Bruchrechnen plus(Bruchrechnen bruch1, Bruchrechnen bruch2) {
        bruch1.erweitern(bruch2.nenner);
        Bruchrechnen ergebnis = new Bruchrechnen(bruch1.nenner+bruch2.nenner, bruch1.nenner);
        return ergebnis;
    }

    Bruchrechnen minus(Bruchrechnen bruch1, Bruchrechnen bruch2) {
        erweitern(bruch1, bruch2);
        Bruchrechnen ergebnis = new Bruchrechnen(bruch1.nenner-bruch2.nenner, bruch1.nenner);
        return ergebnis;
    }

    Bruchrechnen malnehmen(Bruchrechnen bruch1, Bruchrechnen bruch2) {
        Bruchrechnen ergebnis = new Bruchrechnen(bruch1.nenner* bruch2.nenner, bruch1.nenner* bruch2.nenner);
        return ergebnis;
    }

    Bruchrechnen geteilt(Bruchrechnen bruch1, Bruchrechnen bruch2) {
        Bruchrechnen ergebnis = new Bruchrechnen(bruch1.nenner * bruch2.nenner, bruch1.nenner * bruch2.nenner);
        return ergebnis;
    }

    // erweitert immer n1*n2
    private void erweitern(Bruchrechnen bruch1, Bruchrechnen bruch2) {
            bruch1.erweitern(bruch2.nenner);
            bruch2.erweitern(bruch1.nenner);
    }
}