import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Created for Breaker by Max on 14.11.2016.
 */
public class BreakerRunner {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new BreakerGui();
	}

}
