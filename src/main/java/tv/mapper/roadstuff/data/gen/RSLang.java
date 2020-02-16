package tv.mapper.roadstuff.data.gen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.block.BaseBlocks;
import tv.mapper.mapperbase.item.BaseItems;

public class RSLang extends LanguageProvider
{
    private String lang;

    public RSLang(DataGenerator generator, String lang)
    {
        super(generator, MapperBase.MODID, lang);
        this.lang = lang;
    }

    @Override
    protected void addTranslations()
    {
        switch(lang)
        {
            default:
            case "en_us":
                add(BaseBlocks.STEEL_BLOCK, "Steel Block");
                add(BaseBlocks.STEEL_SLAB, "Steel Slab");
                add(BaseBlocks.STEEL_STAIRS, "Steel Stairs");
                add(BaseBlocks.STEEL_WALL, "Steel Wall");
                add(BaseBlocks.STEEL_PRESSURE_PLATE, "Steel Pressure Plate");
                add(BaseBlocks.STEEL_FENCE, "Steel Fence");

                add(BaseBlocks.CONCRETE, "Concrete");
                add(BaseBlocks.CONCRETE_SLAB, "Concrete Slab");
                add(BaseBlocks.CONCRETE_STAIRS, "Concrete Stairs");
                add(BaseBlocks.CONCRETE_WALL, "Concrete Wall");
                add(BaseBlocks.CONCRETE_PRESSURE_PLATE, "Concrete Pressure Plate");

                add(BaseItems.BOLT, "Bolt");
                add(BaseItems.FLATTER_HAMMER, "Flatter Hammer");
                add(BaseItems.IRON_PLATE, "Iron Plate");
                add(BaseItems.IRON_ROD, "Iron Rod");
                add(BaseItems.STEEL_INGOT, "Steel Ingot");
                add(BaseItems.STEEL_NUGGET, "Steel Nugget");
                add(BaseItems.STEEL_PLATE, "Steel Plate");
                add(BaseItems.STEEL_ROD, "Steel Rod");

                add(BaseItems.STEEL_AXE, "Steel Axe");
                add(BaseItems.STEEL_PICKAXE, "Steel Pickaxe");
                add(BaseItems.STEEL_SHOVEL, "Steel Shovel");
                add(BaseItems.STEEL_HOE, "Steel Hoe");
                add(BaseItems.STEEL_SWORD, "Steel Sword");

                add(BaseItems.STEEL_HELMET, "Steel Helmet");
                add(BaseItems.STEEL_CHESTPLATE, "Steel Chestplate");
                add(BaseItems.STEEL_LEGGINGS, "Steel Leggings");
                add(BaseItems.STEEL_BOOTS, "Steel Boots");

                add(BaseItems.STEEL_HORSE_ARMOR, "Steel Horse Armor");

                add("itemGroup.mapperbase_group", "Mapper Base");
                break;
            case "fr_fr":
                add(BaseBlocks.STEEL_BLOCK, "Bloc d'acier");
                add(BaseBlocks.STEEL_SLAB, "Dalle en acier");
                add(BaseBlocks.STEEL_STAIRS, "Escalier en acier");
                add(BaseBlocks.STEEL_WALL, "Muret en acier");
                add(BaseBlocks.STEEL_PRESSURE_PLATE, "Plaque de pression en acier");
                add(BaseBlocks.STEEL_FENCE, "Barrière en acier");

                add(BaseBlocks.CONCRETE, "Bloc de béton");
                add(BaseBlocks.CONCRETE_SLAB, "Dalle en béton");
                add(BaseBlocks.CONCRETE_STAIRS, "Escalier en béton");
                add(BaseBlocks.CONCRETE_WALL, "Muret en béton");
                add(BaseBlocks.CONCRETE_PRESSURE_PLATE, "Plaque de pression en béton");

                add(BaseItems.BOLT, "Boulon");
                add(BaseItems.FLATTER_HAMMER, "Masse");
                add(BaseItems.IRON_PLATE, "Plaque de fer");
                add(BaseItems.IRON_ROD, "Barre de fer");
                add(BaseItems.STEEL_INGOT, "Lingot d'acier");
                add(BaseItems.STEEL_NUGGET, "Pépite d'acier");
                add(BaseItems.STEEL_PLATE, "Plaque d'acier");
                add(BaseItems.STEEL_ROD, "Barre d'acier");

                add(BaseItems.STEEL_AXE, "Hache en acier");
                add(BaseItems.STEEL_PICKAXE, "Pioche en acier");
                add(BaseItems.STEEL_SHOVEL, "Pelle en acier");
                add(BaseItems.STEEL_HOE, "Houe en acier");
                add(BaseItems.STEEL_SWORD, "Epee en acier");

                add(BaseItems.STEEL_HELMET, "Casque en acier");
                add(BaseItems.STEEL_CHESTPLATE, "Plastron en acier");
                add(BaseItems.STEEL_LEGGINGS, "Jambières en acier");
                add(BaseItems.STEEL_BOOTS, "Bottes en acier");

                add(BaseItems.STEEL_HORSE_ARMOR, "Armure en acier pour cheval");

                add("itemGroup.mapperbase_group", "Mapper Base");
                break;
        }
    }
}