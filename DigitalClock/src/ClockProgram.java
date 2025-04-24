import acm.program.GraphicsProgram;
import java.awt.Color;

public class ClockProgram extends GraphicsProgram {

	public static final int APPLICATION_WIDTH  = 610;
	public static final int APPLICATION_HEIGHT = 377;

	private static final double TIMEOUT = 500.0;

	public void run() {
		getMenuBar().setVisible (false);
		setBackground (Color.BLACK);
		Box applicationBox = new Box (0.0, 0.0, getWidth(), getHeight());
		Clock clock = new Clock (applicationBox);
		TimeTeller timeTeller = new TimeTeller();
		clock.addToGCanvas (getGCanvas());
		for (;;) {
			int hours = timeTeller.getHours();
			int minutes = timeTeller.getMinutes();
			int seconds = timeTeller.getSeconds();
			clock.render (hours, minutes, seconds);
			pause (TIMEOUT);
		}
	}

}
