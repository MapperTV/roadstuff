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

package net.killermapper.roadstuff.common.events;

import net.killermapper.roadstuff.common.blocks.RoadStuffBlocks;
import net.killermapper.roadstuff.common.init.RoadStuffAchievements;
import net.killermapper.roadstuff.common.items.RoadStuffItems;
import net.killermapper.roadstuff.common.trafficLigth.TrafficLigthParamatersRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemPickupEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class EventPlayer
{
    @SubscribeEvent
    public void itemPickup(ItemPickupEvent eventPicked)
    {
        if(eventPicked.pickedUp.getEntityItem().getItem() == RoadStuffItems.itemBitumen && eventPicked.pickedUp.getEntityItem().getItemDamage() == 0)
        {
            if(eventPicked.player != null)
                eventPicked.player.triggerAchievement(RoadStuffAchievements.getBitumen);
        }
    }

    @SubscribeEvent
    public void itemSmelting(ItemSmeltedEvent eventSmelted)
    {
        if(eventSmelted.smelting.getItem() == RoadStuffItems.itemBitumen) // Need to find how to get metadata here
            eventSmelted.player.triggerAchievement(RoadStuffAchievements.smeltBitumen);

        if(eventSmelted.smelting.getItem() == Item.getItemFromBlock(RoadStuffBlocks.blockConcrete)) // Need to find how to get metadata here
            eventSmelted.player.triggerAchievement(RoadStuffAchievements.craftConcrete);
    }

    @SubscribeEvent
    public void itemCrafting(ItemCraftedEvent eventCrafted)
    {
        if(eventCrafted.crafting.getItem() == Item.getItemFromBlock(RoadStuffBlocks.blockAsphalt) && eventCrafted.crafting.getItemDamage() == 0)
            eventCrafted.player.triggerAchievement(RoadStuffAchievements.craftAsphalt);

        if(eventCrafted.crafting.getItem() == Item.getItemFromBlock(RoadStuffBlocks.blockCone))
            eventCrafted.player.triggerAchievement(RoadStuffAchievements.craftCone);
    }

    @SubscribeEvent
    public void onServerTick(TickEvent.ServerTickEvent event)
    {
        TrafficLigthParamatersRegister.onUpdate();
    }
}
