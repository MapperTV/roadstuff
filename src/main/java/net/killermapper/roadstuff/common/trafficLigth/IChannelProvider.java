package net.killermapper.roadstuff.common.trafficLigth;

public interface IChannelProvider {
	
	public int getChannel();
	
	public void setChannel(int channel);
	
	public boolean isReversed();
	
	public void setReversed(boolean isReversed);
	
	public int getState();

}
