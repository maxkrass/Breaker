import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created for Breaker by Max on 14.11.2016.
 */
class BreakerGui implements ChangeListener, ActionListener {

	private FractionTools tools = new FractionTools();
	private JSpinner mNumerator1 = new JSpinner();
	private JSpinner mNumerator2 = new JSpinner();
	private JSpinner mDenominator1 = new JSpinner();
	private JSpinner mDenominator2 = new JSpinner();
	private JLabel mResultNumerator = new JLabel("0");
	private JLabel mResultDenominator = new JLabel("0");
	private String[] operations = { "+", "-", "×", "÷" };
	private JComboBox<String> operatorsBox = new JComboBox(operations);

	BreakerGui() {
		JFrame frame = new JFrame("Breaker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel equals = new JLabel("=");
		JPanel mFirstFractionPanel = new JPanel();
		JPanel mSecondFractionPanel = new JPanel();
		JPanel mResultPanel = new JPanel();

		equals.setFont(equals.getFont().deriveFont(36f));
		operatorsBox.setFont(operatorsBox.getFont().deriveFont(36f));
		mNumerator1.setFont(mNumerator1.getFont().deriveFont(36f));
		mNumerator2.setFont(mNumerator2.getFont().deriveFont(36f));
		mDenominator1.setFont(mDenominator1.getFont().deriveFont(36f));
		mDenominator2.setFont(mDenominator2.getFont().deriveFont(36f));
		mResultNumerator.setAlignmentX(Component.CENTER_ALIGNMENT);
		mResultNumerator.setFont(mResultNumerator.getFont().deriveFont(36f));
		mResultDenominator.setAlignmentX(Component.CENTER_ALIGNMENT);
		mResultDenominator.setFont(mResultDenominator.getFont().deriveFont(36f));

		//operatorsBox.setMaximumSize(operatorsBox.getPreferredSize());
		mNumerator1.setMaximumSize(new Dimension(100, 50));
		mNumerator2.setMaximumSize(new Dimension(100, 50));
		mDenominator1.setMaximumSize(new Dimension(100, 50));
		mDenominator2.setMaximumSize(new Dimension(100, 50));

		mNumerator1.addChangeListener(this);
		mNumerator2.addChangeListener(this);
		mDenominator1.addChangeListener(this);
		mDenominator2.addChangeListener(this);

		operatorsBox.addActionListener(this);

		((JLabel)operatorsBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

		SpinnerNumberModel denominatorModel1 = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
		SpinnerNumberModel denominatorModel2 = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);

		mNumerator1.getModel().setValue(1);
		mNumerator2.getModel().setValue(1);
		mDenominator1.setModel(denominatorModel1);
		mDenominator2.setModel(denominatorModel2);


		JSeparator separator1 = new JSeparator(SwingConstants.HORIZONTAL);
		separator1.setMaximumSize(new Dimension(150, 1));
		separator1.setForeground(Color.black);
		separator1.setBackground(Color.BLACK);
		JSeparator separator2 = new JSeparator(SwingConstants.HORIZONTAL);
		separator2.setMaximumSize(new Dimension(150, 1));
		separator2.setForeground(Color.black);
		separator2.setBackground(Color.BLACK);

		mFirstFractionPanel.add(mNumerator1);
		mFirstFractionPanel.add(separator1);
		mFirstFractionPanel.add(mDenominator1);

		mSecondFractionPanel.add(mNumerator2);
		mSecondFractionPanel.add(separator2);
		mSecondFractionPanel.add(mDenominator2);

		mResultPanel.add(mResultNumerator);
		mResultPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
		mResultPanel.add(mResultDenominator);

		JPanel mMainPanel = new JPanel();
		mFirstFractionPanel.setLayout(new BoxLayout(mFirstFractionPanel, BoxLayout.Y_AXIS));
		mSecondFractionPanel.setLayout(new BoxLayout(mSecondFractionPanel, BoxLayout.Y_AXIS));
		mResultPanel.setLayout(new BoxLayout(mResultPanel, BoxLayout.Y_AXIS));
		mMainPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("175px"),
				ColumnSpec.decode("80px"),
				ColumnSpec.decode("175px"),
				ColumnSpec.decode("26px"),
				ColumnSpec.decode("148px"),},
			new RowSpec[] {
				RowSpec.decode("102px"),}));

		mMainPanel.add(mFirstFractionPanel, "1, 1, center, center");
		mMainPanel.add(operatorsBox, "2, 1, center, center");
		mMainPanel.add(mSecondFractionPanel, "3, 1, center, center");
		mMainPanel.add(equals, "4, 1, left, center");
		mMainPanel.add(mResultPanel, "5, 1, center, center");

		frame.getContentPane().add(mMainPanel);
		frame.setSize(600, 480);
		frame.setVisible(true);
		frame.pack();
		evaluate();
	}

	@Override
	public void stateChanged(ChangeEvent changeEvent) {
		evaluate();
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		evaluate();
	}

	private void evaluate() {
		Fraction result = new Fraction(0, 0);
		switch (operatorsBox.getSelectedIndex()) {
			case 0:
				result = tools.add(
						new Fraction(
								(int) mNumerator1.getModel().getValue(),
								(int) mDenominator1.getModel().getValue()),
						new Fraction(
								(int) mNumerator2.getModel().getValue(),
								(int) mDenominator2.getModel().getValue()));
				break;
			case 1:
				result = tools.subtract(
						new Fraction(
								(int) mNumerator1.getModel().getValue(),
								(int) mDenominator1.getModel().getValue()),
						new Fraction(
								(int) mNumerator2.getModel().getValue(),
								(int) mDenominator2.getModel().getValue()));
				break;
			case 2:
				result = tools.multiply(
						new Fraction(
								(int) mNumerator1.getModel().getValue(),
								(int) mDenominator1.getModel().getValue()),
						new Fraction(
								(int) mNumerator2.getModel().getValue(),
								(int) mDenominator2.getModel().getValue()));
				break;
			case 3:
				result = tools.divide(
						new Fraction(
								(int) mNumerator1.getModel().getValue(),
								(int) mDenominator1.getModel().getValue()),
						new Fraction(
								(int) mNumerator2.getModel().getValue(),
								(int) mDenominator2.getModel().getValue()));
				break;
		}
		displayResult(result);
	}

	private void displayResult(Fraction fraction) {
		mResultNumerator.setText(String.valueOf(fraction.getNumerator()));
		mResultDenominator.setText(String.valueOf(fraction.getDenominator()));
	}
}
