/*
Road Stuff - A Minecraft MODification by KillerMapper - 2015-2016

The MIT License (MIT)

Copyright (c) 2015-2016 KillerMapper

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

Tutorial used: https://www.youtube.com/watch?v=iT-RMZP-acI from Wehavecookies
 */

package net.killermapper.roadstuff.common.init;

import cpw.mods.fml.common.FMLCommonHandler;
import net.killermapper.roadstuff.common.RoadStuff;

public class RoadStuffConfig
{
    public static boolean enableBitumen;
    public static final boolean GENBITUMEN_DEFAULT = true;
    public static final String GENBITUMEN_NAME = "Enables bitumen generation in the world";

    public static void syncConfig()
    {
        FMLCommonHandler.instance().bus().register(RoadStuff.instance);

        final String BITUMENGEN = RoadStuff.config.CATEGORY_GENERAL + RoadStuff.config.CATEGORY_SPLITTER + "OreGeneration";
        RoadStuff.config.addCustomCategoryComment(BITUMENGEN, "Enable Ore Generation in the world");
        enableBitumen = RoadStuff.config.get(BITUMENGEN, GENBITUMEN_NAME, GENBITUMEN_DEFAULT).getBoolean(GENBITUMEN_DEFAULT);
        if(RoadStuff.config.hasChanged())
        {
            RoadStuff.config.save();
        }
    }
}
