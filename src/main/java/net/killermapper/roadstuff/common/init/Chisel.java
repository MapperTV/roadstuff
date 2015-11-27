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
        // Asphalt base blocks
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffBase|roadstuff:asphaltBase01|0");
        for(int i = 0; i <= 5; i++)
        {
            FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffBase|roadstuff:asphaltLines01|" + i);
        }

        // Concrete base blocks
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffBaseC|roadstuff:concreteBase|0");
        for(int i = 0; i <= 5; i++)
        {
            FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffBaseC|roadstuff:concreteLine|" + i);
        }

        // Asphalt Simple White Line
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltLines01|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltLines02|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltLines02|1");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltLines02|2");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltLines02|3");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltLines05|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltLines05|1");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltLines05|2");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltLines05|3");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltLinesCorner01|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltArrows01|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltArrows01|2");

        // Asphalt Simple Yellow Line
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltLines01|1");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltLines03|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltLines03|1");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltLines03|2");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltLines03|3");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltLines04|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltLines04|1");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltLines04|2");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltLines04|3");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltLinesCorner01|1");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltArrows01|1");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltArrows01|3");

        // Concrete Simple White Line
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWLC|roadstuff:concreteLine|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWLC|roadstuff:concreteYCross|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWLC|roadstuff:concreteYCross|1");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWLC|roadstuff:concreteYCross|2");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWLC|roadstuff:concreteYCross|3");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWLC|roadstuff:concreteXCross|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWLC|roadstuff:concreteXCross|1");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWLC|roadstuff:concreteXCross|2");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWLC|roadstuff:concreteXCross|3");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWLC|roadstuff:concreteCorner|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWLC|roadstuff:concreteArrow|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWLC|roadstuff:concreteArrow|2");

        // Concrete Simple Yellow Line
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYLC|roadstuff:concreteLine|1");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYLC|roadstuff:concreteYCrossYellow|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYLC|roadstuff:concreteYCrossYellow|1");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYLC|roadstuff:concreteYCrossYellow|2");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYLC|roadstuff:concreteYCrossYellow|3");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYLC|roadstuff:concreteXCrossYellow|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYLC|roadstuff:concreteXCrossYellow|1");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYLC|roadstuff:concreteXCrossYellow|2");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYLC|roadstuff:concreteXCrossYellow|3");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYLC|roadstuff:concreteCorner|1");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYLC|roadstuff:concreteArrow|1");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYLC|roadstuff:concreteArrow|3");
        
        // Asphalt Large White Line
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffLWL|roadstuff:asphaltLines01|2");
        
        // Asphalt Large Yellow Line
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffLYL|roadstuff:asphaltLines01|3");
        
        // Asphalt Double White Line
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffDWL|roadstuff:asphaltLines01|4");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffDWL|roadstuff:asphaltLinesCorner01|2");
        
        // Asphalt Double Yellow Line
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffDYL|roadstuff:asphaltLines01|5");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffDYL|roadstuff:asphaltLinesCorner01|3");
        
        // Concrete Large White Line
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffLWL|roadstuff:concreteLine|2");
        
        // Concrete Large Yellow Line
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffLYL|roadstuff:concreteLine|3");
        
        // Concrete Double White Line
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffDWL|roadstuff:concreteLine|4");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffDWL|roadstuff:concreteCorner|2");
        
        // Concrete Double Yellow Line
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffDYL|roadstuff:concreteLine|5");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffDYL|roadstuff:concreteCorner|3");

        /*
         * Example
         * for(int i = 1; i <= 5; i++)
         * {
         * for(int j = 0; j <= 16; j++)
         * {
         * FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "BlockAsphaltLines|roadstuff:asphaltLines0" + i + "|" + j);
         * }
         * }
         */
    }
}
