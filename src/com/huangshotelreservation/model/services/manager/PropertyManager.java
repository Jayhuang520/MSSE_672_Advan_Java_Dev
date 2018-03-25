package com.huangshotelreservation.model.services.manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.huangshotelreservation.model.business.exception.PropertyFileNotFoundException;
import org.apache.log4j.Logger;

public class PropertyManager 
{
    static Logger log = Logger.getLogger("com.huangshotelreservation");
	private static Properties properties;
	
	/**
	 * Load the properties file from the file location.
	 * So the content should be available for classes in the
	 * model tier.
	 * 
	 * @param propertyFileLocation
	 * @throws PropertyFileNotFoundException
	 * @throws IOException 
	 */
	
	public static void loadProperties(String propertyFileLocation) throws PropertyFileNotFoundException{
		properties = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(propertyFileLocation);
			properties.load(fis);
			log.info("Property file successfully load from: "+propertyFileLocation);
			log.info("Property contents: "+properties.toString());
			
		}catch(FileNotFoundException fnfe) {
			log.error("Property file not found.");
			log.error("Property Contents: "+properties.toString());
		}catch(IOException ioe) {
			throw new PropertyFileNotFoundException("File input/output"
					+ "exception while loading property file. ",ioe);
		}catch(Exception e) {
			log.error("Exception while loading property file");
			throw new PropertyFileNotFoundException("Exception while loading"
					+ "properties file",e);
			
		}finally {
			if(fis != null) {
				try {
					fis.close();
				}catch (IOException ioe) {
					//Can't do much beside logging
					ioe.printStackTrace();
				}
			}
		}//End finally
	}//End loadProperties()
	
	/**
	 * This methods returns the value for the passed key
	 * @param key
	 * @return
	 */
	static public String getPropertyValue(String key)
	{
		return properties.getProperty(key);
	}
	
}//end class propertyManager
