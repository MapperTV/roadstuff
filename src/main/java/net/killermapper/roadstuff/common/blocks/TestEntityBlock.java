//This class is a test, and will be deleted later. Credits to MinecraftForgeFrance.

package net.killermapper.roadstuff.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class TestEntityBlock extends Block{

	public TestEntityBlock(Material material) {
		super(material);
	}
	
    @Override
    public TileEntity createTileEntity(World world, int metadata)
    {
        return new TileEntityTest();
    }

    @Override
    public boolean hasTileEntity(int metadata)
    {
        return true;
    }
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        /* 
         * petit explication sur la condition world.isRemote
         * world.isRemote = monde client, c'est celui qui va gérer le rendu
         * !world.isRemote = monde serveur, il va gérer le reste, notamment la sauvegarde, les variables d'une entité de bloc sont donc à manipuler côté serveur seulement, d'où la condition juste en dessous
         */
        if(!world.isRemote)
        {
            TileEntity tile = world.getTileEntity(x, y, z); // on obtient l'instance du TileEntity
            if(tile instanceof TileEntityTest) // si le TileEntity est bien le nôtre (cette condition est importante pour éviter tout risque de corruption de monde, car il peut arriver qu'une mauvaise entité de bloc soit sur les coordonnées de votre bloc)
            {
            	TileEntityTest tileTuto = (TileEntityTest)tile; // on cast pour avoir accès au méthode qui se trouve dans TileEntityTutoriel
                if(side == 0) // si le côté est 0, donc en dessous, on appelle la fonction decrease pour diminuer la valeur
                {
                    tileTuto.decrease();
                }
                else if(side == 1) // si le côté est 1, donc en dessous, on appelle la fonction increase pour augmenter la valeur
                {
                    tileTuto.increase();
                }
                player.addChatMessage(new ChatComponentTranslation("tile.entitytest.number", tileTuto.getNumber())); // et on affiche par un message tchat la valeur. ChatComponentTranslation permet de faire un String.format, dans mon fichier de lang je vais mettre %d qui sera remplacé par la valeur de tileTuto.getNumber(). (voir plus bas)
                return true;
            }
        }
        return false;
    }

}
