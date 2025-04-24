import acm.program.GraphicsProgram;
import java.awt.Color;

public class Step1 extends GraphicsProgram {

	public static final int APPLICATION_WIDTH  = 610;
	public static final int APPLICATION_HEIGHT = 377;

	private static final double TIMEOUT = 1000.0;

	public void run() {
		getMenuBar().setVisible (false);
		setBackground (Color.BLACK);
		Box ledBox = new Box (0.0, 0.0, getWidth(), getHeight());
		Led led = new Led (ledBox);
		led.addToGCanvas (getGCanvas());
		for (;;) {
			led.on();
			pause (TIMEOUT);
			led.off();
			pause (TIMEOUT);
		}
	}

}
