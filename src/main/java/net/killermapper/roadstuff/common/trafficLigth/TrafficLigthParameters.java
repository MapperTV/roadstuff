package net.killermapper.roadstuff.common.trafficLigth;


public class TrafficLigthParameters {

	private int delay;
	private int time;
	public static final int GREEN = 0;
	public static final int ORANGE = 1;
	public static final int RED = 2;

	/**
	 * Green = delay / 3
	 * Orange = delay / 6
	 * Red = delay / 3 + delay / 6
	 * Warning : Tick time
	 * @param delay
	 */
	public TrafficLigthParameters(int delay)
	{
		this.delay = delay;
		this.time = delay;
	}

	public void setTime(int time)
	{
		this.time = time;
		if(this.time <= 0)
		{
			this.time = this.delay;
		}
	}
	
	public int getStateReversed()
	{
		if(this.time <= this.delay / 6)
		{
			return ORANGE;
		}
		else if(this.time <= this.delay / 3 + this.delay / 6 - 60)
		{
			return GREEN;
		}
		else
		{
			return RED;
		}
	}

	public int getTime()
	{
		return this.time;
	}

	public int getState()
	{
		if(this.time <= this.delay / 3 + this.delay / 6 || this.time >= this.delay - 60)
		{
			return RED;
		}
		else if(this.time <= (this.delay / 3) * 2)
		{
			return ORANGE;
		}
		else
		{
			return GREEN;
		}
	}
	
	public int getDelay()
	{
		return this.delay;
	}
	
}
