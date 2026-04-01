package myFramework.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
//	It will run first before any method or the class variable and initiate only Once
	
	static {
		configProperty();
	}
	
	private static Properties properties;
	
//	Making Method which read the config file and map it to the memory
	
	
	public static void configProperty() {
		
		properties = new Properties();
		String rootPath = System.getProperty("user.dir");
		String configFile = rootPath + "/config.properties";
		
		try(FileInputStream fis = new FileInputStream(configFile)){
			properties.load(fis);
		}
		catch(FileNotFoundException e) {
			throw new RuntimeException("File Not found in the Project");
		}
		catch(IOException m) {
			throw new RuntimeException("File not read properly or there is some problem in loading");
		}
	}
	
	public static String getValue(String key) {
		String value = properties.getProperty(key);
		if(value ==null || value.trim().isEmpty()) {
			throw new RuntimeException("Value is not coming means either the key is wrong or something wrong with load properties");
		}
		else {
			return value.trim();
		}
	}
	
}
