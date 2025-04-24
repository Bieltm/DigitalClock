import acm.program.GraphicsProgram;
import java.awt.Color;

public class Step2 extends GraphicsProgram {

	public static final int APPLICATION_WIDTH  = 610;
	public static final int APPLICATION_HEIGHT = 377;

	private static final int BAR_SIZE = 4;

	private static final double TIMEOUT = 1000.0;

	public void run() {
		getMenuBar().setVisible (false);
		setBackground (Color.BLACK);
		Box ledsBox = new Box (0.0, 0.0, getWidth(), getHeight());
		Bar leds = new Bar (BAR_SIZE, ledsBox);
		leds.addToGCanvas (getGCanvas());
		for (;;) {
			for (int i = 0; i < BAR_SIZE; i++) {
				leds.render(i);
				pause (TIMEOUT);
			}
		}
	}

}
