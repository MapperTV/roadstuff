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
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffBase|roadstuff:asphaltBlock|0");
        for(int i = 0; i <= 5; i++)
        {
            FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffBase|roadstuff:asphaltLine|" + i);
        }
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffBase|roadstuff:asphaltWordExit|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffBase|roadstuff:asphaltWordExit|1");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffBase|roadstuff:asphaltWordExit|2");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffBase|roadstuff:asphaltWordExit|3");

        // Concrete base blocks
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffBaseC|roadstuff:concreteBlock|0");
        for(int i = 0; i <= 5; i++)
        {
            FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffBaseC|roadstuff:concreteLine|" + i);
        }

        // Asphalt Simple White Line
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltLine|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltYCross|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltYCross|1");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltYCross|2");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltYCross|3");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltXCross|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltXCross|1");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltXCross|2");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltXCross|3");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltCorner|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltArrow|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltArrow|2");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltArrow2|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltArrow2|1");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltCorner2|2");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltCorner3|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWL|roadstuff:asphaltCorner3|2");

        // Asphalt Simple Yellow Line
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltLine|1");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltYCrossYellow|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltYCrossYellow|1");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltYCrossYellow|2");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltYCrossYellow|3");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltXCrossYellow|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltXCrossYellow|1");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltXCrossYellow|2");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltXCrossYellow|3");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltCorner|1");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltArrow|1");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltArrow|3");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltArrow2|2");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltArrow2|3");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltCorner2|3");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltCorner3|1");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYL|roadstuff:asphaltCorner3|3");

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
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWLC|roadstuff:concreteArrow2|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWLC|roadstuff:concreteArrow2|1");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWLC|roadstuff:concreteCorner2|2");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWLC|roadstuff:concreteCorner3|0");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSWLC|roadstuff:concreteCorner3|2");

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
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYLC|roadstuff:concreteArrow2|2");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYLC|roadstuff:concreteArrow2|3");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYLC|roadstuff:concreteCorner2|3");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYLC|roadstuff:concreteCorner3|1");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffSYLC|roadstuff:concreteCorner3|3");

        // Asphalt Large White Line
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffLWL|roadstuff:asphaltLine|2");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffLWL|roadstuff:asphaltCorner2|0");

        // Asphalt Large Yellow Line
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffLYL|roadstuff:asphaltLine|3");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffLYL|roadstuff:asphaltCorner2|1");

        // Asphalt Double White Line
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffDWL|roadstuff:asphaltLine|4");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffDWL|roadstuff:asphaltCorner|2");

        // Asphalt Double Yellow Line
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffDYL|roadstuff:asphaltLine|5");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffDYL|roadstuff:asphaltCorner|3");

        // Concrete Large White Line
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffLWLC|roadstuff:concreteLine|2");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffLWLC|roadstuff:concreteCorner2|0");

        // Concrete Large Yellow Line
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffLYLC|roadstuff:concreteLine|3");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffLYLC|roadstuff:concreteCorner2|1");

        // Concrete Double White Line
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffDWLC|roadstuff:concreteLine|4");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffDWLC|roadstuff:concreteCorner|2");

        // Concrete Double Yellow Line
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffDYLC|roadstuff:concreteLine|5");
        FMLInterModComms.sendMessage(IMC.getModid(), IMC.ADD_VARIATION.key, "RoadStuffDYLC|roadstuff:concreteCorner|3");
    }
}
