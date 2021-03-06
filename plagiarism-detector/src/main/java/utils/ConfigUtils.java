package utils;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class provides with the utilities to read and write the config files
 * 
 * @author Vaibhav Dave
 * @since 4/9/2018
 *
 */
public class ConfigUtils {

	private static Logger logger = Logger.getLogger(ConfigUtils.class);
	private static Properties properties = new Properties();
	private String propertiesLoc = "config.properties";

	/**
	 * This function helps the user to write a particular value to the
	 * config.properties file
	 * 
	 * @param String title
	 * @param String value
	 */
	public void writeInConfig(String title, String value) {

		if (!value.equals(readConfig(title))) {
			try {
				properties.load(new FileInputStream(propertiesLoc));
				properties.setProperty(title, value);
				properties.store(new FileOutputStream(propertiesLoc), null);
			} catch (IOException e) {
				logger.error(e.toString());
			}
		}
	}

	/**
	 * This function helps the user to read a particular value from the
	 * config.properties file
	 * 
	 * @param String title
	 * @param String value
	 */
	public String readConfig(String title) {
		try {
			properties.load(new FileInputStream(propertiesLoc));
		} catch (IOException e) {
			logger.error(e.toString());
		}
		return properties.getProperty(title);
	}

}
