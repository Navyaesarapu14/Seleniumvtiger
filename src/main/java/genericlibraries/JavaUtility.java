package genericlibraries;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.Random;
/**
 * This class contains reusable methods
 * 
 *
 */
public class JavaUtility {
	public int generateRandomNum(int limit) {
		Random random = new Random();
		return random.nextInt(limit);
	}
	/**
	 * This method returns current time
	 * @return
	 */
public String getCurrentTime() {
	Date date  = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_sss");
	return sdf.format(date);
}
/**
 * This method is used to convert string type month to integer
 * month
 * @author month
 * return
 */
public int convertMonthToInt(String month) {
	return DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(month).get(ChronoField.MONTH_OF_YEAR);
}
}
