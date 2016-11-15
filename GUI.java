import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GUI {

    private Mathematik mathe = new Mathematik();
    private JTextField zähler1 = new JTextField("1",5);
    private JTextField zähler2 = new JTextField("1",5);
    private JTextField nenner1 = new JTextField("1",5);
    private JTextField nenner2 = new JTextField("1",5);
    private JLabel ergebniszähler = new JLabel();
    private JLabel ergebnisnenner = new JLabel();
    private JTextField matheaufgabe = new JTextField("+", 3);
        // alles dynamische statisch machen
    GUI() {
        JFrame frame = new JFrame("Bruchrechnen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel gleichzeichen = new JLabel("=");
        JPanel bruchstrich1 = new JPanel();
        JPanel bruchstrich2 = new JPanel();
        JPanel bruchstrich3 = new JPanel();
        
        ergebniszähler.setAlignmentX(Component.CENTER_ALIGNMENT);
        ergebnisnenner.setAlignmentX(Component.CENTER_ALIGNMENT);

        bruchstrich1.add(zähler1);
        bruchstrich1.add(separator1);
        bruchstrich1.add(nenner1);

        bruchstrich2.add(zähler2);
        bruchstrich2.add(separator2);
        bruchstrich2.add(nenner2);

        bruchstrich3.add(ergebniszähler);
        bruchstrich3.add(new JSeparator(SwingConstants.HORIZONTAL));
        bruchstrich3.add(ergebnisnenner);

        JPanel striche = new JPanel();
        bruchstrich1.setLayout(new BoxLayout(bruchstrich1, BoxLayout.Y_AXIS));
        bruchstrich2.setLayout(new BoxLayout(bruchstrich2, BoxLayout.Y_AXIS));
        bruchstrich3.setLayout(new BoxLayout(bruchstrich3, BoxLayout.Y_AXIS));

        striche.add(bruchstrich1, "1, 1, center, center");
        striche.add(bruchstrich2, "3, 1, center, center");
        striche.add(gleichzeichen, "4, 1, left, center");
        striche.add(bruchstrich3, "5, 1, center, center");

        frame.getContentPane().add(striche);
        frame.setSize(600, 480);
        frame.setVisible(true);
        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
    zeige();
    }
    
    private void zeige() {
    Bruchrechnen ergebnis = new Bruchrechnen(0,0);
        if (matheaufgabe.getText()=="plus")
        {
            ergebnis = mathe.plus(
						new Bruchrechnen(
								Integer.parseInt(zähler1.getText()),
								Integer.parseInt(nenner1.getText())),
						new Bruchrechnen(
								Integer.parseInt(zähler2.getText()),
								Integer.parseInt(nenner2.getText())));
        }
        if (matheaufgabe.getText()=="minus")
        {
            ergebnis = mathe.minus(
						new Bruchrechnen(
								Integer.parseInt(zähler1.getText()),
								Integer.parseInt(nenner1.getText())),
						new Bruchrechnen(
								Integer.parseInt(zähler2.getText()),
								Integer.parseInt(nenner2.getText())));
        }
        if (matheaufgabe.getText()=="mal")
        {
            ergebnis = mathe.malnehmen(
						new Bruchrechnen(
								Integer.parseInt(zähler1.getText()),
								Integer.parseInt(nenner1.getText())),
						new Bruchrechnen(
								Integer.parseInt(zähler2.getText()),
								Integer.parseInt(nenner2.getText())));
        }
        if (matheaufgabe.getText()=="geteilt")
        {
            ergebnis = mathe.geteilt(
						new Bruchrechnen(
								Integer.parseInt(zähler1.getText()),
								Integer.parseInt(nenner1.getText())),
						new Bruchrechnen(
								Integer.parseInt(zähler2.getText()),
								Integer.parseInt(nenner2.getText())));
        }
    displayResult(result);
    }

    private void ergebnisse(Bruchrechnen fraction) {
        ergebniszähler.setText(String.valueOf(fraction.getzaehler()));
        ergebnisnenner.setText(String.valueOf(fraction.getnenner()));
    }
}
