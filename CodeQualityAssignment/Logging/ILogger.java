package singleton;

public interface ILogger {
	public static final String LOG_FORMAT="%s\t\t%s\t%s";
	public void log(String type, String message); 
}
