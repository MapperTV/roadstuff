/*
Road Stuff - A Minecraft MODification by KillerMapper - 2015

The MIT License (MIT)

Copyright (c) 2015 KillerMapper

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

//Thanks for Brodi from Minecraftforgefrance.net

package net.killermapper.roadstuff.common.init;

import com.cricketcraft.chisel.api.IMC;

import cpw.mods.fml.common.event.FMLInterModComms;

public class Chisel
{

    public static void sendIMC()
    {
        //testing
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "BlockAsphaltLines|roadstuff:asphaltBase01|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "BlockAsphaltLines|roadstuff:asphaltLines01|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "BlockAsphaltLines|roadstuff:asphaltLines01|1");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "BlockAsphaltLines|roadstuff:asphaltLines01|2");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "BlockAsphaltLines|roadstuff:asphaltLines01|3");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "BlockAsphaltLines|roadstuff:asphaltLines01|4");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "BlockAsphaltLines|roadstuff:asphaltLines01|5");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "BlockAsphaltLines|roadstuff:asphaltLines01|5");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "BlockAsphaltLines|roadstuff:asphaltLines02|0");
        /* Example
        for(int i = 1; i <= 5; i++)
        {
            for(int j = 0; j <= 16; j++)
            {
                FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "BlockAsphaltLines|roadstuff:asphaltLines0" + i + "|" + j);
            }
        }*/
    }
}
