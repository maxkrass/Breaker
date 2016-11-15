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

    GUI() {
        JFrame frame = new JFrame("Bruchrechnen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       	JLabel gleichzeichen = new JLabel("=");
       	JPanel panel = new JPanel();
        //VVVVVVVVVVVVVVVVVVVVVVVVVV
	//zähler1.setPosition(0,0); //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<das da
        //AAAAAAAAAAAAAAAAAAAAAAAAAA
	
       	panel.add(zähler1);
       	frame.getContentPane().add(panel);
       	
       	Insets insets = panel.getInsets();
       	Dimension size = zähler1.getPreferredSize();
       	zähler1.setBounds(25 + insets.left, 5 + insets.top,
       	             size.width, size.height);
       	
       	panel.setLayout(null);
       	insets = frame.getInsets();
        frame.setSize(600 + insets.left + insets.right, 480 + insets.top + insets.bottom);
        frame.setVisible(true);
        //frame.pack();
    }
	// TODO Button 
    /*
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
    evaluate();
    }
     */
    private void rechne() {
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
        ergebnisse(ergebnis);
    }

    private void ergebnisse(Bruchrechnen bruch) {
       // ergebniszähler.setText(String.valueOf(bruch.getzaehler()));
       // ergebnisnenner.setText(String.valueOf(bruch.getnenner()));
    }
}
