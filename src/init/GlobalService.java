package init;

public class GlobalService {
	public static final String host = "127.0.0.1";
	public static final String URL = "jdbc:sqlserver://" + GlobalService.host + ":1433;databaseName=JSPDB";
	public static final String USERNAME = "sa";
	public static final String PASSWORD = "sa123456";
	public static final String JNDI_DB_NAME = "java:comp/env/jdbc/BookDataSQLver";
	public static final String KEY = "KittySnoopyMicky";
}