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

package net.killermapper.roadstuff.common.init;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class RoadStuffAchievements
{
    public static Achievement getBitumen;
    public static Achievement smeltBitumen;
    public static Achievement craftAsphalt;
    public static Achievement craftConcrete;
    public static Achievement craftCone;
    public static Achievement craftAsphaltLine;
    public static Achievement craftConcreteLine;
    public static Achievement craftAsphaltCorner;
    public static Achievement craftConcreteCorner;
    public static Achievement craftSign;
    public static Achievement configSign;
    public static Achievement craftReflector;
    public static Achievement craftIlluminatedReflector;
    public static Achievement craftAsphaltSlab;
    public static Achievement craftConcreteSlab;

    public static AchievementPage page;

    public static void initAchievements()
    {
        loadAchievements();
        registerAchievements();
        registerPage();
    }

    public static void loadAchievements()
    {
        getBitumen = new Achievement("achievement.roadstuff_getbitumen", "roadstuff_getbitumen", 0, 0, new ItemStack(RoadStuffItems.itemBitumen, 1, 0), null);
        smeltBitumen = new Achievement("achievement.roadstuff_smeltbitumen", "roadstuff_smeltbitumen", 2, 0, new ItemStack(RoadStuffItems.itemBitumen, 1, 1), getBitumen);
        craftAsphalt = new Achievement("achievement.roadstuff_craftasphalt", "roadstuff_craftasphalt", 4, 0, new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0), smeltBitumen);
        craftAsphaltLine = new Achievement("achievement.roadstuff_craftasphaltline", "roadstuff_craftasphaltline", 6, 0, new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 0), craftAsphalt);
        craftAsphaltCorner = new Achievement("achievement.roadstuff_craftasphaltcorner", "roadstuff_craftasphaltcorner", 8, 0, new ItemStack(RoadStuffBlocks.blockAsphaltCorner, 1, 0), craftAsphaltLine);
        craftAsphaltSlab = new Achievement("achievement.roadstuff_craftasphaltslab", "roadstuff_craftasphaltslab", 5, -1, new ItemStack(RoadStuffBlocks.singleSlabAsphalt, 1, 0), craftAsphalt);
        
        craftConcrete = new Achievement("achievement.roadstuff_craftconcrete", "roadstuff_craftconcrete", 4, 2, new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0), null);
        craftConcreteLine = new Achievement("achievement.roadstuff_craftconcreteline", "roadstuff_craftconcreteline", 6, 2, new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 0), craftConcrete);
        craftConcreteCorner = new Achievement("achievement.roadstuff_craftconcretecorner", "roadstuff_craftconcretecorner", 8, 2, new ItemStack(RoadStuffBlocks.blockConcreteCorner, 1, 0), craftConcreteLine);
        craftConcreteSlab = new Achievement("achievement.roadstuff_craftconcreteslab", "roadstuff_craftconcreteslab", 5, 3, new ItemStack(RoadStuffBlocks.singleSlabConcrete, 1, 0), craftConcrete);
        
        craftCone = new Achievement("achievement.roadstuff_craftcone", "roadstuff_craftcone", 2, -4, new ItemStack(RoadStuffBlocks.blockCone, 1, 0), smeltBitumen);
        craftSign = new Achievement("achievement.roadstuff_craftsign", "roadstuff_craftsign", 4, -4, new ItemStack(RoadStuffBlocks.blockTrafficSign, 1, 1), craftCone);
        configSign = new Achievement("achievement.roadstuff_configsign", "roadstuff_configsign", 6, -4, new ItemStack(RoadStuffBlocks.blockTrafficSign, 1, 1), craftSign);
        
        craftReflector = new Achievement("achievement.roadstuff_craftreflector", "roadstuff_craftreflector", 0, -4, new ItemStack(RoadStuffBlocks.blockReflector, 1, 0), craftCone);
        craftIlluminatedReflector = new Achievement("achievement.roadstuff_craftilluminatedreflector", "roadstuff_craftilluminatedreflector", 0, -6, new ItemStack(RoadStuffBlocks.blockReflector, 1, 3), craftReflector);
        
        page = new AchievementPage("Road Stuff", getBitumen, smeltBitumen, craftAsphalt, craftConcrete, craftCone, craftAsphaltLine, craftAsphaltCorner, craftConcreteLine, craftConcreteCorner, craftSign, configSign, craftReflector, craftIlluminatedReflector, craftAsphaltSlab, craftConcreteSlab);
    }

    public static void registerPage()
    {
        AchievementPage.registerAchievementPage(page);
    }

    public static void registerAchievements()
    {
        getBitumen.registerStat();
        smeltBitumen.registerStat();
        craftAsphalt.registerStat();
        craftConcrete.registerStat();
        craftCone.registerStat();
        craftAsphaltLine.registerStat();
        craftAsphaltCorner.registerStat();
        craftConcreteLine.registerStat();
        craftConcreteCorner.registerStat();
        craftSign.registerStat();
        configSign.registerStat();
        craftReflector.registerStat();
        craftIlluminatedReflector.registerStat();
        craftAsphaltSlab.registerStat();
        craftConcreteSlab.registerStat();
    }
}