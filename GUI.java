import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GUI {

    private Mathematik mathe = new Mathematik();
    private JSpinner zähler1 = new JSpinner();
    private JSpinner zähler2 = new JSpinner();
    private JSpinner nenner1 = new JSpinner();
    private JSpinner nenner2 = new JSpinner();
    private JLabel ergebniszähler = new JLabel();
    private JLabel ergebnisnenner = new JLabel();

    GUI() {
        JFrame frame = new JFrame("Bruchrechnen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel gleichzeichen = new JLabel("=");
        JPanel bruchstrich1 = new JPanel();
        JPanel bruchstrich2 = new JPanel();
        JPanel bruchstrich3 = new JPanel();

        ergebniszähler.setAlignmentX(Component.CENTER_ALIGNMENT);
        ergebnisnenner.setAlignmentX(Component.CENTER_ALIGNMENT);

        JSeparator separator1 = new JSeparator(SwingConstants.HORIZONTAL);
        separator1.setMaximumSize(new Dimension(150, 1));
        separator1.setForeground(Color.black);
        separator1.setBackground(Color.BLACK);
        JSeparator separator2 = new JSeparator(SwingConstants.HORIZONTAL);
        separator2.setMaximumSize(new Dimension(150, 1));
        separator2.setForeground(Color.black);
        separator2.setBackground(Color.BLACK);

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

    /*
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
    evaluate();
    }
    /*
    private void evaluate() {
    Bruchrechnen result = new Bruchrechnen(0, 0);
    switch (String.valueOf(operatorsBox.getSelectedItem())) {
    case "+":
    result = mathe.add(
    new Bruchrechnen(
    (int) zähler1.getModel().getValue(),
    (int) nenner1.getModel().getValue()),
    new Bruchrechnen(
    (int) zähler2.getModel().getValue(),
    (int) nenner2.getModel().getValue()));
    break;
    case "-":
    result = mathe.subtract(
    new Bruchrechnen(
    (int) zähler1.getModel().getValue(),
    (int) nenner1.getModel().getValue()),
    new Bruchrechnen(
    (int) zähler2.getModel().getValue(),
    (int) nenner2.getModel().getValue()));
    break;
    case "×":
    result = mathe.multiply(
    new Bruchrechnen(
    (int) zähler1.getModel().getValue(),
    (int) nenner1.getModel().getValue()),
    new Bruchrechnen(
    (int) zähler2.getModel().getValue(),
    (int) nenner2.getModel().getValue()));
    break;
    case "÷":
    result = mathe.divide(
    new Bruchrechnen(
    (int) zähler1.getModel().getValue(),
    (int) nenner1.getModel().getValue()),
    new Bruchrechnen(
    (int) zähler2.getModel().getValue(),
    (int) nenner2.getModel().getValue()));
    break;
    }
    displayResult(result);
    }
     */

    private void ergebnisse(Bruchrechnen fraction) {
        ergebniszähler.setText(String.valueOf(fraction.getzaehler()));
        ergebnisnenner.setText(String.valueOf(fraction.getnenner()));
    }
}