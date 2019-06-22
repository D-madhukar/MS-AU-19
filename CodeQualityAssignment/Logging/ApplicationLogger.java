package singleton;

import java.io.IOException;

//Factory Class to create ILogger concrete classes
public class ApplicationLogger {
	public static ILogger getLogger(LoggerType loggerType) throws IOException {
		if(loggerType == LoggerType.CONSOLE_LOGGER) {
			return ConsoleLogger.getConsoleLogger();
		} else if(loggerType == LoggerType.FILE_LOGGER ) {
			return FileLogger.getFileLogger();//By default logs info into log.txt(on Desktop) 
		}
		return null;
	}
}
enum LoggerType{
	CONSOLE_LOGGER,
	FILE_LOGGER
}