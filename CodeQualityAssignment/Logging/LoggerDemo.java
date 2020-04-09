package singleton;

import java.io.IOException;

public class LoggerDemo {

	public static void main(String[] args) {
		try {
			ILogger fileLogger = ApplicationLogger.getLogger(LoggerType.FILE_LOGGER);
			fileLogger.log("INFO", "First Logging message");
			ILogger consoleLogger = ApplicationLogger.getLogger(LoggerType.CONSOLE_LOGGER);
			consoleLogger.log("INFO", "First Logging message");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
