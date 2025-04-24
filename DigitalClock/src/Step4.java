import acm.program.GraphicsProgram;
import java.awt.Color;

public class Step4 extends GraphicsProgram {

	public static final int APPLICATION_WIDTH  = 610;
	public static final int APPLICATION_HEIGHT = 377;

	private static final double TIMEOUT = 1000.0;

	public void run() {
		getMenuBar().setVisible (false);
		setBackground (Color.BLACK);
		Box digitBox = new Box (0.0, 0.0, getWidth(), getHeight());
		DecimalDigit digit = new DecimalDigit (digitBox);
		digit.addToGCanvas (getGCanvas());
		int counter = 0;
		for (;;) {
			digit.render (counter % 10);
			counter += 1;
			pause (TIMEOUT);
		}
	}

}
