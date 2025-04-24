import acm.graphics.GCanvas;

public class Clock {

	private static final double DEC2LED_RATIO = 0.25;
	private final DecimalClock decimalClock;
	private final LedsClock    ledsClock;

	public Clock (Box clockBox) {
		Box[] topBottom = clockBox.splitTopBottom (DEC2LED_RATIO);
		decimalClock = new DecimalClock (topBottom[0]);
		ledsClock    = new LedsClock    (topBottom[1]);
	}

	public void addToGCanvas (GCanvas gCanvas) {
		ledsClock.addToGCanvas (gCanvas);
		decimalClock.addToGCanvas (gCanvas);
	}

	public void render (int hours, int minutes, int seconds) {
		ledsClock.render (hours, minutes, seconds);
		decimalClock.render (hours, minutes, seconds);
	}

}
