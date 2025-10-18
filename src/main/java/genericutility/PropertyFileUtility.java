package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {

	public String readDataFromPropertyFile(String key) throws IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\div31\\OneDrive\\Desktop\\commondata.properties.txt\\");
		Properties prop=new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		
		return value;
		
	}
}