package Datadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadFromProperties {

	public static void main(String[] args)throws Exception {
		//Step 1: Convert physical file into java readable object
FileInputStream fis = new FileInputStream("./src/test/resources/Data.properties"); 
//Step 2: Create an instance for properties class
Properties property = new Properties();
//Step 3: Load all key-value pairs to properties object from file
property.load(fis);
//Step 4: Fetch data from properties using key
System.out.println(property.getProperty("url"));
System.out.println(property.getProperty("browser"));
System.out.println(property.getProperty("time"));
	}

}
