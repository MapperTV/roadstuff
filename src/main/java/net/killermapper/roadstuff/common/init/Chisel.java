package net.killermapper.roadstuff.common.init;

import com.cricketcraft.chisel.api.IMC;

import cpw.mods.fml.common.event.FMLInterModComms;

public class Chisel {

	public static void sendIMC()
	{	
		//Example
		for(int i = 1; i <= 5; i++)
		{
			for(int j = 0; j<= 3; j++)
			{
		         FMLInterModComms.sendMessage(IMC.getModid(),
		                    IMC.ADD_VARIATION.key,
		                    "BlockAsphaltLines|roadstuff:asphaltLines0" + i + "|" + j);
			}
		}
	}
}
