package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {
	
	public static void main(String[] args) throws IOException {
		
		//Step 1: Load the document in Java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step 2: Create Object of properties class from Java.util
		Properties pObj = new Properties();
		
		//Step 3: load the file into properties class
		pObj.load(fis);
		
		//Step 4: provide the key and get the value
		String value = pObj.getProperty("url");
		System.out.println(value);
		
		
	}

}
