import acm.program.GraphicsProgram;
import java.awt.Color;

public class Step3 extends GraphicsProgram {

	public static final int APPLICATION_WIDTH  = 610;
	public static final int APPLICATION_HEIGHT = 377;

	private static final int BASE = 10;
	private static final int[] SIZES = new int[] { 4, 10 };
	private static final int MAX_COUNTER = 3 * BASE + BASE - 1;

	private static final double TIMEOUT = 1000.0;

	public void run() {
		getMenuBar().setVisible (false);
		setBackground (Color.BLACK);
		Box ledBox = new Box (0.0, 0.0, getWidth(), getHeight());
		Group ledsNum = new Group (SIZES, ledBox);
		ledsNum.addToGCanvas (getGCanvas());
		int counter = 0;
		for (;;) {
			ledsNum.render (new int[] { counter % BASE, counter / BASE });
			pause (TIMEOUT);
			counter += 1;
			if (counter > MAX_COUNTER) {
				counter = 0;
			}
		}
	}

}
