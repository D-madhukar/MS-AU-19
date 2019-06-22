package singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class FileLogger implements ILogger {

	private static FileLogger logger=null;
	private static PrintWriter logWriter = null;
	private FileLogger() {
		
	}
	public static FileLogger getFileLogger() throws IOException {
		if(logger==null) {
			synchronized(FileLogger.class) {
				if(logger==null) {
					//Hard coding the filePath
					FileWriter fw=new FileWriter("C:/Users/domakonda.madhukar/Desktop/log.txt",true);
					logWriter = new PrintWriter(fw);
					logger= new FileLogger();
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
