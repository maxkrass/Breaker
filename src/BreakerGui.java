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

	private JPanel mMainPanel = new JPanel();
	private JPanel mFirstFractionPanel = new JPanel();
	private JPanel mSecondFractionPanel = new JPanel();
	private JPanel mResultPanel = new JPanel();
	private JSpinner mNumerator1 = new JSpinner();
	private JSpinner mNumerator2 = new JSpinner();
	private JSpinner mDenominator1 = new JSpinner();
	private JSpinner mDenominator2 = new JSpinner();
	private JLabel mResultNumerator = new JLabel("0");
	private JLabel mResultDenominator = new JLabel("0");
	private String[] operations = { "+", "-", "×", "÷" };
	private JComboBox<String> operatorsBox = new JComboBox<>(operations);
	private String selectedOperator = "+";

	BreakerGui() {
		JFrame frame = new JFrame("Breaker");
		JLabel equals = new JLabel("=");
		selectedOperator = String.valueOf(operatorsBox.getSelectedItem());

		equals.setFont(equals.getFont().deriveFont(36f));
		operatorsBox.setFont(operatorsBox.getFont().deriveFont(36f));
		mNumerator1.setFont(mNumerator1.getFont().deriveFont(36f));
		mNumerator2.setFont(mNumerator2.getFont().deriveFont(36f));
		mDenominator1.setFont(mDenominator1.getFont().deriveFont(36f));
		mDenominator2.setFont(mDenominator2.getFont().deriveFont(36f));
		mResultNumerator.setFont(mResultNumerator.getFont().deriveFont(36f));
		mResultDenominator.setFont(mResultDenominator.getFont().deriveFont(36f));

		operatorsBox.setMaximumSize(operatorsBox.getPreferredSize());
		mNumerator1.setMaximumSize(mNumerator1.getPreferredSize());
		mNumerator2.setMaximumSize(mNumerator2.getPreferredSize());
		mDenominator1.setMaximumSize(mDenominator1.getPreferredSize());
		mDenominator2.setMaximumSize(mDenominator2.getPreferredSize());

		mNumerator1.addChangeListener(this);
		mNumerator2.addChangeListener(this);
		mDenominator1.addChangeListener(this);
		mDenominator2.addChangeListener(this);

		operatorsBox.addActionListener(this);

		SpinnerNumberModel denominatorModel1 = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
		SpinnerNumberModel denominatorModel2 = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);

		mDenominator1.setModel(denominatorModel1);
		mDenominator2.setModel(denominatorModel2);


		JSeparator separator1 = new JSeparator(SwingConstants.HORIZONTAL);
		separator1.setMaximumSize(new Dimension(100, 1));
		JSeparator separator2 = new JSeparator(SwingConstants.HORIZONTAL);
		separator2.setMaximumSize(new Dimension(100, 1));

		mFirstFractionPanel.add(mNumerator1);
		mFirstFractionPanel.add(separator1);
		mFirstFractionPanel.add(mDenominator1);

		mSecondFractionPanel.add(mNumerator2);
		mSecondFractionPanel.add(separator2);
		mSecondFractionPanel.add(mDenominator2);

		mResultPanel.add(mResultNumerator);
		mResultPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
		mResultPanel.add(mResultDenominator);

		mMainPanel.setLayout(new BoxLayout(mMainPanel, BoxLayout.X_AXIS));
		mFirstFractionPanel.setLayout(new BoxLayout(mFirstFractionPanel, BoxLayout.Y_AXIS));
		mSecondFractionPanel.setLayout(new BoxLayout(mSecondFractionPanel, BoxLayout.Y_AXIS));
		mResultPanel.setLayout(new BoxLayout(mResultPanel, BoxLayout.Y_AXIS));

		mMainPanel.add(mFirstFractionPanel);
		mMainPanel.add(operatorsBox);
		mMainPanel.add(mSecondFractionPanel);
		mMainPanel.add(equals);
		mMainPanel.add(mResultPanel);

		frame.getContentPane().add(mMainPanel);
		frame.setSize(600, 480);
		frame.setVisible(true);
		frame.pack();
	}

	@Override
	public void stateChanged(ChangeEvent changeEvent) {
		evaluate();
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		evaluate();
	}

	void evaluate() {

	}
}
