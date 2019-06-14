import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level; 
import java.util.logging.Logger; 
import java.util.logging.*;

public class ExceptionsAssignment {
	//ConsoleCONSOLE_LOGGER
	private static final Logger CONSOLE_LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public static void main(String[] args) throws IOException {
		runExercises();
	}
	//Exercise-1, Exercise-2 and Exercise-3
	public static void runExercises() throws IOException{
		//Raising ArithmeticException
		FileHandler fileHandler = new FileHandler("log.txt");
		SimpleFormatter formatter = new SimpleFormatter();  
	    fileHandler.setFormatter(formatter);
		//fileLogger
		Logger fileLogger = Logger.getLogger("fileLogger");
		fileLogger.addHandler(fileHandler);
		CONSOLE_LOGGER.log(Level.INFO, "-----------Raising ArithmeticException");
//		fileLogger.log(Level.INFO, "-----------Raising ArithmeticException");
		fileLogger.info("-----------Raising ArithmeticException");
		try {
			int a=0;
			int c=10/a;
		} catch(ArithmeticException ae) {
			ae.printStackTrace();
			CONSOLE_LOGGER.log(Level.WARNING, "ArithmeticException is occured");
			fileLogger.log(Level.WARNING, "ArithmeticException is occured");
		}
		
		//Raising ArrayIndexOutofBoundsException
		CONSOLE_LOGGER.log(Level.INFO, "-----------Raising ArrayIndexOutOfBoundsException");
		fileLogger.log(Level.INFO, "-----------Raising ArrayIndexOutOfBoundsException");
		try {
			int arr[]=new int[3];
			int c = arr[3];
		}catch(ArrayIndexOutOfBoundsException aie) {
			aie.printStackTrace();
			CONSOLE_LOGGER.log(Level.WARNING, "ArrayIndexOutOfBoundsException is occured");
			fileLogger.log(Level.WARNING, "ArrayIndexOutOfBoundsException is occured");
		}
		
		//Raising FileNotFoundException
		CONSOLE_LOGGER.log(Level.INFO, "-----------Raising FileNotFoundException");
		fileLogger.log(Level.INFO, "-----------Raising FileNotFoundException");
		try {
			FileInputStream fi = new FileInputStream("c:/Desktop/file.txt");
		}catch(FileNotFoundException fne) {
			fne.printStackTrace();
			CONSOLE_LOGGER.log(Level.WARNING, "FileNotFoundException is occured");
			fileLogger.log(Level.WARNING, "FileNotFoundException is occured");
		}
	}

}
