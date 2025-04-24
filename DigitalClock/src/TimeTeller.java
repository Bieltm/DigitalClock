import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeTeller {

	private final SimpleDateFormat hoursFormat;
	private final SimpleDateFormat minutesFormat;
	private final SimpleDateFormat secondsFormat;

	public TimeTeller() {
		hoursFormat = new SimpleDateFormat ("HH");
		minutesFormat = new SimpleDateFormat ("mm");
		secondsFormat = new SimpleDateFormat ("ss");
	}

	public int getHours() {
		return extractUsingFormat (hoursFormat);
	}

	public int getMinutes() {
		return extractUsingFormat (minutesFormat);
	}

	public int getSeconds() {
		return extractUsingFormat (secondsFormat);
	}

	private int extractUsingFormat (SimpleDateFormat format) {
		Date now = getNow();
		String digits = format.format (now);
		return Integer.parseInt (digits);
	}

	private Date getNow() {
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}

}
