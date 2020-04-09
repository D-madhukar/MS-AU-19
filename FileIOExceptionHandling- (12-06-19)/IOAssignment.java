import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

public class IOAssignment {
	public static void main(String args[]) throws IOException {
		String basePath = "D:/MS-AU-19/Eclipse/practice";
		//Exercise-1
		File file = new File(basePath);
		printFileDirectory(file);
		
		//Exercise-2(print files with extensions .txt)
		String directoryPath=basePath + "/src";
		String extension = ".txt";
		printFilesWithExtension(directoryPath, extension);
		
		//Exercies-3 (Copy from one file to another)
		// Exercise-4 (Change the toFile path to different directory)
		String fromFile = basePath + "/src/Text2.txt";
		String toFile = basePath + "/src/Text1.txt";
		copyData(fromFile, toFile);
	}
	//Exercise-1 method
	public static void printFileDirectory(File file) {
		if(file.isDirectory()) {
			System.out.println("\n" + file.getName() + " -- Directory");
			File []files = file.listFiles();
			for(int i=0;i< files.length;i++) {
				//Recursive Call
				printFileDirectory(files[i]);
				
			}
		}else {
			System.out.println("\t" + file.getName() + ", ");
		}
		
	}
	//Exercise-2 method
	public static void printFilesWithExtension(String path, String extension) {
		File file = new File(path);
		if(!file.exists()) {
			System.out.println("No File Exist for this path (" + path + " )");
		} else {
			File[] files = file.listFiles(new CustomizedFilter(extension));
			if(files.length == 0) {
				System.out.println("No Files exist with extension --" + extension);
			} else {
				for(int i=0;i<files.length;i++) {
					File tempFile = files[i];
					System.out.println(tempFile.getName() + "Deleted");
					tempFile.delete();
				}
 			}
		}
	}
	//Exercise-3,4 method
	public static void copyData(String fromFile, String toFile) throws IOException {
		FileInputStream fi = null;
		FileOutputStream fo=null;
		try {
			fi = new FileInputStream(fromFile);
			fo = new FileOutputStream(toFile);
			int d;
			while((d=fi.read())!=-1) {
				fo.write(d);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			fi.close();
			fo.close();
		}
	}
}

//Exercise-2 utility class
class CustomizedFilter implements FilenameFilter {

	private String extension;

	public CustomizedFilter(String extension) {
		this.extension = extension.toLowerCase();
	}
	public boolean accept(File dir, String name) {
		return name.toLowerCase().endsWith(extension);
	}

}


