package init;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GlobalService {

	public static final String host = "127.0.0.1";
	public static final String URL = "jdbc:sqlserver://" + GlobalService.host + ":1433;databaseName=bellyworry";
	public static final String USERNAME = "sa";
	public static final String PASSWORD = "sa123456";
	public static final String JNDI_DB_NAME = "java:comp/env/jdbc/bellyworryDataSQLver";
	public static final String KEY = "KittySnoopyMicky";
	
	
	public static int convertInt(String data) {
		int result = 0;
		try {
			result = Integer.parseInt(data);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			result = -1000;
		}
		return result;
	}
	
	public static double convertDouble(String data) {
		double result = 0;
		try {
			result = Double.parseDouble(data);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			result = -1000;
		}
		return result;
	}
	
	private static SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static java.util.Date convertDate(String data) {
		java.util.Date result = null;
		try {
			result = sFormat.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
			result = new java.util.Date(0);
		}
		return result;
	}
	public static String convertString(java.util.Date date){
		String result=null;
		result = sFormat.format(date);
		return result;
	}
	
	public static float convertFloat(String data) {
		float result = 0;
		try {
			result = Float.parseFloat(data);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			result = -1000;
		}
		return result;  
	}
	
}