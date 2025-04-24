import acm.program.GraphicsProgram;
import java.awt.Color;

public class Step5 extends GraphicsProgram {

	public static final int APPLICATION_WIDTH  = 610;
	public static final int APPLICATION_HEIGHT = 377;

	private static final int NUM_DIGITS = 3;

	private static final double TIMEOUT = 200.0;

	public void run() {
		getMenuBar().setVisible (false);
		setBackground (Color.BLACK);
		Box dnBox = new Box (0.0, 0.0, getWidth(), getHeight());
		DecimalNumber digit = new DecimalNumber (NUM_DIGITS, dnBox);
		digit.addToGCanvas (getGCanvas());
		int counter = 0;
		for (;;) {
			digit.render (counter % 1000);
			counter += 1;
			pause (TIMEOUT);
		}
	}

}
