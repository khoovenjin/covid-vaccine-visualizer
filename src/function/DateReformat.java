package function;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateReformat {
	
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");      
    public static final SimpleDateFormat weekYearFormat = new SimpleDateFormat("'Week:'ww',Year:'Y");
    public static final SimpleDateFormat monthYearFormat = new SimpleDateFormat("'Month:'MM',Year:'yyyy");

    public static String convertDateToShortFormat(Date date) {
        SimpleDateFormat dateformatter = new SimpleDateFormat("dd MMM yyyy");
        return dateformatter.format(date);
    }
    
    public static String convertDateAsString(Date date) {
        SimpleDateFormat dateformatter = new SimpleDateFormat("dd MMM yyyy");
        return dateformatter.format(date);
    }
    
    public static String convertDateToMonthFormat(String monthYear) throws ParseException {
        SimpleDateFormat dateformatter = new SimpleDateFormat("MMM yyyy");
        return dateformatter.format(monthYearFormat.parse(monthYear));
    }
    
    public static String convertMonthToPrettyMonth(String monthYear) throws ParseException {
        SimpleDateFormat dateformatter = new SimpleDateFormat("MMM yyyy");
        return monthYearFormat.format(dateformatter.parse(monthYear));
    }
	
    public static Date convertStringtoDate (String strdate) {
            Date date = null;
            try {
                    date = formatter.parse(strdate);
            } catch (ParseException e) {
                    e.printStackTrace();
            }
            return date;
    }

    public static boolean compareDatesAfter (Date date1, Date date2) {
            return date1.after(date2);
    }

    public static boolean compareDatesBefore (Date date1, Date date2) {
            return date1.before(date2);
    }

    public static boolean compareDatesEquals (Date date1, Date date2) {
            return date1.equals(date2);
    }
}
