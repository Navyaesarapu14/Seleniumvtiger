package genericlibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {

	 
/**
 * This method used to read data from properties
 * @paramfilePath
 * @key
 * @return
 
 */
		public String readFromProperties(String filepath, String key) {
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(filepath);
				
				}catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				Properties property = new Properties();
				try {
					property.load(fis);
				}catch (IOException e) {
					e.printStackTrace();
				}
				return property.getProperty(key);
		
	}

public void propertiesInitialization(String propertiesPath) {
	// TODO Auto-generated method stub
	
}
}


