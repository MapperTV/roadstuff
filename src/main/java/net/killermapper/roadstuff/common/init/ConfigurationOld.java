package net.killermapper.roadstuff.common.init;

import java.util.Hashtable;

public class ConfigurationOld {
	
	public static Hashtable<String, Integer> integer = new Hashtable<String, Integer>();
	public static Hashtable<String, Integer> integerDefault = new Hashtable<String, Integer>();
	public static Hashtable<String, Boolean> enableBitumen = new Hashtable<String, Boolean>();
	
	static {
		integerDefault.put("traffic.delay", 60);
		enableBitumen.put("bitumen.enable", true);
	}

}
