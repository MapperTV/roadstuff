package net.killermapper.roadstuff.common.init;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import net.killermapper.roadstuff.common.RoadStuff;

import org.apache.logging.log4j.Level;

public class ConfigurationLoader {
	
	public static String configFilePath;
	
	public static void load(File configDir)
	{
		ConfigurationLoader.configFilePath = configDir.getAbsolutePath() + "/roadstuff.properties";
		
		File config = new File(configDir.getAbsolutePath() + "/roadstuff.properties");
		try {
			if(!config.exists())
			{
				config.createNewFile();
				setDefaultParameters(config.getAbsoluteFile());
				RoadStuff.logger.log(Level.INFO, "Created configuration file");
			}
			read(config);
		} catch (IOException e) {
			RoadStuff.logger.log(Level.ERROR, "Cannot create configuration file");
		}        
	}

	private static void setDefaultParameters(File file)
	{
		try {
			//BufferedInputStream streamIn = new BufferedInputStream(new FileInputStream(file));
			//BufferedOutputStream streamOut = new BufferedOutputStream(new FileOutputStream(file));
			FileWriter writer = new FileWriter(file);
			writer.write("#This configuration file has been automatically generated\n");
			writer.write("#++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
			writer.write("#+           Configuration file of RoadStuff            +\n");
			writer.write("#++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
			writer.write("\n");
			writer.write("#Length of time all the traffic ligths of a channel will be red (tick)\n");
			writer.write("traffic.delay=" + Configuration.integerDefault.get("traffic.delay") + "\n");
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			RoadStuff.logger.log(Level.ERROR, "Configuration file not found");
		} catch (IOException e) {
			RoadStuff.logger.log(Level.ERROR, "Error reading configuration file");
		}
	}

	public static void read(File file)
	{
		Properties prop = new Properties();
		try {
			BufferedInputStream streamIn = new BufferedInputStream(new FileInputStream(file));
			prop.load(streamIn);
			
			try {
				int delay = Integer.parseInt(prop.getProperty("traffic.delay"));
				Configuration.integer.put("traffic.delay", delay);
			} catch (NumberFormatException e) {
				RoadStuff.logger.log(Level.INFO, "Cannot load traffic.delay, default value will be used");
				Configuration.integer.put("traffic.delay", Configuration.integerDefault.get("traffic.delay"));
			}

		} catch (FileNotFoundException e) {
			RoadStuff.logger.log(Level.ERROR, "Configuration file not found");
		} catch (IOException e) {
			RoadStuff.logger.log(Level.ERROR, "Error reading configuration file");
		}
	}

}
