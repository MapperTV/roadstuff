package net.killermapper.roadstuff.common.trafficLigth;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;


public class TrafficLigthParamatersRegister {

	private static HashMap<Integer, TrafficLigthParameters> channels = new HashMap<Integer, TrafficLigthParameters>();

	static {
		channels.put(0, new TrafficLigthParameters(1800));
	}
	
	public static void setChannelParam(int channel, TrafficLigthParameters param)
	{
		if(param == null) return;
		channels.put(channel, param);
	}

	public static void onUpdate()
	{
		Iterator iterator = channels.entrySet().iterator();
		Entry entry;

		while(iterator.hasNext())
		{
			entry = (Entry)iterator.next();
			TrafficLigthParameters param = (TrafficLigthParameters)(entry.getValue());
			param.setTime(param.getTime() - 1);
		}
	}

	public static int getStateFrom(int channel)
	{
		if(channels.containsKey(channel))
		{
			return channels.get(channel).getState();
		}
		return -1;
	}

	public static int getStateReversedFrom(int channel)
	{
		if(channels.containsKey(channel))
		{
			return channels.get(channel).getStateReversed();
		}
		return -1;
	}

	public static int getDelayFrom(int channel)
	{
		if(channels.containsKey(channel))
		{
			return channels.get(channel).getDelay();
		}
		return -1;
	}
}
