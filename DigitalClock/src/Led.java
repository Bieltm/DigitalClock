import acm.graphics.GCanvas;
import acm.graphics.GRect;
import java.awt.Color;

public class Led {

	private static final double PADDING = 0.1;
	private final GRect rect;

	private static final Color COLOR_OFF = Color.BLACK;
	private static final Color COLOR_ON = Color.RED;
	private static final Color COLOR_BORDER = Color.RED.darker();

	public Led (Box ledBox) {
		Box rectBox = ledBox.withPadding (Padding.regular (PADDING));
		rect = new GRect (rectBox.getX(),
								rectBox.getY(),
								rectBox.getWidth(),
								rectBox.getHeight());
		rect.setColor (COLOR_BORDER);
		rect.setFilled (true);
		rect.setFillColor (COLOR_OFF);
	}

	public void addToGCanvas (GCanvas gCanvas) {
		gCanvas.add (rect);
	}

	public void on() {
		rect.setFillColor (COLOR_ON);
	}

	public void off() {
		rect.setFillColor (COLOR_OFF);
	}

}
