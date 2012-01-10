package commons;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {
	public static final String DATE_FORMAT = "dd/MM/yyyy";
	public static final String TIME_FORMAT = "hh:mm a";
	public static final String DATETIME_FORMAT = DATE_FORMAT + " " + TIME_FORMAT;

	public static Date stringToDate(String format, String date) {
		DateFormat df = new SimpleDateFormat(format);

		try {
			return df.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static String dateToString(String format, Date date) {
		DateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}
}
