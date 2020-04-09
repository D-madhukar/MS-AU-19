package singleton;

import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Date;

public class ConsoleLogger implements ILogger {
	private static ConsoleLogger logger=null;
	private static PrintWriter logWriter = null;
	private ConsoleLogger() {
		
	}
	public static ConsoleLogger getConsoleLogger() {
		if(logger==null) {
			synchronized(ConsoleLogger.class) {
				if(logger==null) {
					BufferedWriter  bw=new BufferedWriter(new OutputStreamWriter(System.out));
					logWriter = new PrintWriter(bw);
					logger= new ConsoleLogger();
				}
			}
		}
		return logger;
	}
	public void log(String type, String message) {
	   logWriter.format(LOG_FORMAT, new Date().toString(),type,message);
	   logWriter.println();
	   logWriter.flush();
	}
}
