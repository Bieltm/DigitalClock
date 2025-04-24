public class Padding {

	private final double top;
	private final double right;
	private final double bottom;
	private final double left;

	public Padding (double top, double right, double bottom, double left) {
		this.top = top;
		this.right = right;
		this.bottom = bottom;
		this.left = left;
	}

	public static Padding regular (double padding) {
		return new Padding (padding, padding, padding, padding);
	}

	public static Padding horizontal (double padding) {
		return new Padding (0.0, padding, 0.0, padding);
	}

	public static Padding vertical (double padding) {
		return new Padding (padding, 0.0, padding, 0.0);
	}

	public double getTop() {
		return top;
	}

	public double getRight() {
		return right;
	}

	public double getBottom() {
		return bottom;
	}

	public double getLeft() {
		return left;
	}

}
