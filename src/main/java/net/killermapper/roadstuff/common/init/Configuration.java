package net.killermapper.roadstuff.common.init;

import java.util.Hashtable;

public class Configuration {
	
	public static Hashtable<String, Integer> integer = new Hashtable<String, Integer>();
	public static Hashtable<String, Integer> integerDefault = new Hashtable<String, Integer>();
	
	static {
		integerDefault.put("traffic.delay", 60);
	}

}
