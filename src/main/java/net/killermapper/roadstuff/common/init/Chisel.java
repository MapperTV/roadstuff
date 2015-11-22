package net.killermapper.roadstuff.common.init;

import com.cricketcraft.chisel.api.IMC;

import cpw.mods.fml.common.event.FMLInterModComms;

public class Chisel {

	public static void sendIMC()
	{	
		//Example
		for(int i = 1; i <= 5; i++)
		{
			FMLInterModComms.sendMessage(IMC.CHISEL_MODID,
					IMC.ADD_VARIATION.key,
					"BlockAsphaltLines|roadstuff:asphaltLines0" + i + "|0");
		}
	}
}
