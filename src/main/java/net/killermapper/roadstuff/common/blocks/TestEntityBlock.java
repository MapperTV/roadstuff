//This class is a test, and will be deleted later. Credits to MinecraftForgeFrance.

package net.killermapper.roadstuff.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class TestEntityBlock extends Block{

	public TestEntityBlock() {
		super(Material.wood);
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
         * world.isRemote = monde client, c'est celui qui va g�rer le rendu
         * !world.isRemote = monde serveur, il va g�rer le reste, notamment la sauvegarde, les variables d'une entit� de bloc sont donc � manipuler c�t� serveur seulement, d'o� la condition juste en dessous
         */
        if(!world.isRemote)
        {
            TileEntity tile = world.getTileEntity(x, y, z); // on obtient l'instance du TileEntity
            if(tile instanceof TileEntityTest) // si le TileEntity est bien le n�tre (cette condition est importante pour �viter tout risque de corruption de monde, car il peut arriver qu'une mauvaise entit� de bloc soit sur les coordonn�es de votre bloc)
            {
            	TileEntityTest tileTuto = (TileEntityTest)tile; // on cast pour avoir acc�s au m�thode qui se trouve dans TileEntityTutoriel
                if(side == 0) // si le c�t� est 0, donc en dessous, on appelle la fonction decrease pour diminuer la valeur
                {
                    tileTuto.decrease();
                }
                else if(side == 1) // si le c�t� est 1, donc en dessous, on appelle la fonction increase pour augmenter la valeur
                {
                    tileTuto.increase();
                }
                player.addChatMessage(new ChatComponentTranslation("tile.entitytest.number", tileTuto.getNumber())); // et on affiche par un message tchat la valeur. ChatComponentTranslation permet de faire un String.format, dans mon fichier de lang je vais mettre %d qui sera remplac� par la valeur de tileTuto.getNumber(). (voir plus bas)
                return true;
            }
        }
        return false;
    }

}
