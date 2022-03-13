package tv.mapper.roadstuff.data.gen;

import java.util.Arrays;

import org.codehaus.plexus.util.StringUtils;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.common.data.LanguageProvider;
import tv.mapper.roadstuff.world.item.RSItemRegistry;
import tv.mapper.roadstuff.world.level.block.RSBlockRegistry;

public class RSLang extends LanguageProvider
{
    private String lang;

    public RSLang(DataGenerator generator, String modid, String lang)
    {
        super(generator, modid, lang);
        this.lang = lang;
    }

    @Override
    protected void addTranslations()
    {
        // String frColorsF[] = {"blanche", "orange", "magenta", "bleu claire", "jaune", "vert claire", "rose", "grise", "gris claire", "cyan", "violette", "bleue", "marron", "verte", "rouge",
        // "noire"};
        String frColorsM[] = {"blanc", "orange", "magenta", "bleu clair", "jaune", "vert clair", "rose", "gris", "gris clair", "cyan", "violet", "bleu", "marron", "vert", "rouge", "noir"};

        switch(lang)
        {
            default:
            case "en_us":
                add(RSBlockRegistry.ASPHALT_SLOPE.get(), "Asphalt Slope");
                add(RSBlockRegistry.CONCRETE_SLOPE.get(), "Concrete Slope");

                add(RSBlockRegistry.CONCRETE.get(), "Concrete");
                add(RSBlockRegistry.CONCRETE_SLAB.get(), "Concrete Slab");
                add(RSBlockRegistry.CONCRETE_STAIRS.get(), "Concrete Stairs");
                add(RSBlockRegistry.CONCRETE_WALL.get(), "Concrete Wall");
                add(RSBlockRegistry.CONCRETE_PRESSURE_PLATE.get(), "Concrete Pressure Plate");
                add(RSBlockRegistry.CONCRETE_FENCE.get(), "Concrete Fence");
                add(RSBlockRegistry.CONCRETE_FENCE_GATE.get(), "Concrete Fence Gate");

                add(RSBlockRegistry.ASPHALT.get(), "Asphalt");
                add(RSBlockRegistry.ASPHALT_SLAB.get(), "Asphalt Slab");
                add(RSBlockRegistry.ASPHALT_STAIRS.get(), "Asphalt Stairs");
                add(RSBlockRegistry.ASPHALT_PRESSURE_PLATE.get(), "Asphalt Pressure Plate");

                add(RSItemRegistry.RAW_BITUMEN.get(), "Raw Bitumen");
                add(RSBlockRegistry.BITUMEN_ORE.get(), "Bitumen Ore");
                add(RSBlockRegistry.BITUMEN_BLOCK.get(), "Block of Bitumen");
                add(RSItemRegistry.BITUMINOUS_COAL.get(), "Bituminous Coal");

                for(int i = 0; i < Arrays.stream(DyeColor.values()).count(); i++)
                {
                    String color = DyeColor.byId(i).getSerializedName();
                    String check[] = color.split("_");
                    if(check.length > 1)
                        color = StringUtils.capitalise(check[0]) + " " + StringUtils.capitalise(check[1]);
                    else
                        color = StringUtils.capitalise(check[0]);

                    add(RSBlockRegistry.TRAFFIC_CONE_BLOCKS.get(DyeColor.byId(i)).get(), color + " Traffic Cone");
                    add(RSBlockRegistry.TRAFFIC_BARREL_BLOCKS.get(DyeColor.byId(i)).get(), color + " Traffic Barrel");
                    add(RSBlockRegistry.TRAFFIC_BOLLARD_BLOCKS.get(DyeColor.byId(i)).get(), color + " Traffic Bollard");
                    add(RSBlockRegistry.CYLINDRICAL_BOLLARD_BLOCKS.get(DyeColor.byId(i)).get(), color + " Cylindrical Bollard");
                    add(RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get(), color + " Reflector");
                    add(RSBlockRegistry.LUMINESCENT_REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get(), color + " Luminescent Reflector");
                    add(RSBlockRegistry.GUARDRAIL_BLOCKS.get(DyeColor.byId(i)).get(), color + " Guardrail");
                }

                add(RSBlockRegistry.WHITE_BOLLARD.get(), "White Delineator");
                add(RSBlockRegistry.YELLOW_BOLLARD.get(), "Yellow Delineator");
                add(RSBlockRegistry.RED_BOLLARD.get(), "Red Delineator");
                add(RSBlockRegistry.WHITE_SMALL_BOLLARD.get(), "White Small Delineator");
                add(RSBlockRegistry.YELLOW_SMALL_BOLLARD.get(), "Yellow Small Delineator");
                add(RSBlockRegistry.RED_SMALL_BOLLARD.get(), "Red Small Delineator");

                add(RSBlockRegistry.STEEL_GUARDRAIL.get(), "Steel Guardrail");

                add(RSBlockRegistry.PAINT_BUCKET.get(), "Paint Bucket");
                add(RSItemRegistry.WOODEN_PAINT_BRUSH.get(), "Wooden Paint Brush");
                add(RSItemRegistry.STONE_PAINT_BRUSH.get(), "Stone Paint Brush");
                add(RSItemRegistry.IRON_PAINT_BRUSH.get(), "Iron Paint Brush");
                add(RSItemRegistry.STEEL_PAINT_BRUSH.get(), "Steel Paint Brush");
                add(RSItemRegistry.GOLDEN_PAINT_BRUSH.get(), "Golden Paint Brush");
                add(RSItemRegistry.DIAMOND_PAINT_BRUSH.get(), "Diamond Paint Brush");
                add(RSItemRegistry.NETHERITE_PAINT_BRUSH.get(), "Netherite Paint Brush");

                add("roadstuff.message.bucket.empty", "This bucket is empty!");
                add("roadstuff.message.bucket.yellow", "This bucket is already filled with yellow paint!");
                add("roadstuff.message.bucket.white", "This bucket is already filled with white paint!");
                add("roadstuff.message.bucket.full", "This bucket is full!");
                add("roadstuff.message.bucket.underwater", "You can't interact with a bucket under water!");

                add("roadstuff.gui.paintbrush.title", "Paintbrush Configuration");
                add("roadstuff.message.brush.gui.eraser", "Paint Eraser");
                add("roadstuff.message.brush.gui.pattern", "Pattern n°");
                add("roadstuff.message.brush.gui.paint", "Paint amount: ");
                add("roadstuff.message.brush.gui.color", "Color: ");
                add("roadstuff.message.brush.gui.fav1", "Right click on a pattern");
                add("roadstuff.message.brush.gui.fav2", "to favorite it!");

                add("roadstuff.message.paint.color.white", "White");
                add("roadstuff.message.paint.color.yellow", "Yellow");

                add("itemGroup.roadstuff_group", "Road Stuff");
                break;

            case "fr_fr":
                add(RSBlockRegistry.ASPHALT_SLOPE.get(), "Pente en asphalte");
                add(RSBlockRegistry.CONCRETE_SLOPE.get(), "Pente en béton");

                add(RSBlockRegistry.CONCRETE.get(), "Bloc de béton");
                add(RSBlockRegistry.CONCRETE_SLAB.get(), "Dalle en béton");
                add(RSBlockRegistry.CONCRETE_STAIRS.get(), "Escalier en béton");
                add(RSBlockRegistry.CONCRETE_WALL.get(), "Muret en béton");
                add(RSBlockRegistry.CONCRETE_PRESSURE_PLATE.get(), "Plaque de pression en béton");
                add(RSBlockRegistry.CONCRETE_FENCE.get(), "Barrière en béton");
                add(RSBlockRegistry.CONCRETE_FENCE_GATE.get(), "Portillon en béton");

                add(RSBlockRegistry.ASPHALT.get(), "Asphalte");
                add(RSBlockRegistry.ASPHALT_SLAB.get(), "Dalle d'asphalte");
                add(RSBlockRegistry.ASPHALT_STAIRS.get(), "Escalier d'asphalte");
                add(RSBlockRegistry.ASPHALT_PRESSURE_PLATE.get(), "Plaque de pression d'asphalte");

                add(RSItemRegistry.RAW_BITUMEN.get(), "Bitume brut");
                add(RSBlockRegistry.BITUMEN_ORE.get(), "Minerai de bitume");
                add(RSBlockRegistry.BITUMEN_BLOCK.get(), "Bloc de bitume");
                add(RSItemRegistry.BITUMINOUS_COAL.get(), "Charbon bitumineux");

                for(int i = 0; i < Arrays.stream(DyeColor.values()).count(); i++)
                {
                    String color = DyeColor.byId(i).getSerializedName();
                    String check[] = color.split("_");
                    if(check.length > 1)
                        color = StringUtils.capitalise(check[0]) + " " + StringUtils.capitalise(check[1]);
                    else
                        color = StringUtils.capitalise(check[0]);

                    add(RSBlockRegistry.TRAFFIC_CONE_BLOCKS.get(DyeColor.byId(i)).get(), "Cône routier " + frColorsM[i]);
                    add(RSBlockRegistry.TRAFFIC_BARREL_BLOCKS.get(DyeColor.byId(i)).get(), "Barril routier " + frColorsM[i]);
                    add(RSBlockRegistry.TRAFFIC_BOLLARD_BLOCKS.get(DyeColor.byId(i)).get(), "Bollard  routier " + frColorsM[i]);
                    add(RSBlockRegistry.CYLINDRICAL_BOLLARD_BLOCKS.get(DyeColor.byId(i)).get(), "Bollard cylindrique " + frColorsM[i]);
                    add(RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get(), "Réflecteur " + frColorsM[i]);
                    add(RSBlockRegistry.LUMINESCENT_REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get(), "Réflecteur " + frColorsM[i] + " luminescent");
                    add(RSBlockRegistry.GUARDRAIL_BLOCKS.get(DyeColor.byId(i)).get(), "Rambarde " + frColorsM[i]);
                }

                add(RSBlockRegistry.WHITE_BOLLARD.get(), "Délinéateur blanc");
                add(RSBlockRegistry.YELLOW_BOLLARD.get(), "Délinéateur jaune");
                add(RSBlockRegistry.RED_BOLLARD.get(), "Délinéateur rouge");
                add(RSBlockRegistry.WHITE_SMALL_BOLLARD.get(), "Petit délinéateur blanc");
                add(RSBlockRegistry.YELLOW_SMALL_BOLLARD.get(), "Petit délinéateur jaune");
                add(RSBlockRegistry.RED_SMALL_BOLLARD.get(), "Petit délinéateur rouge");

                add(RSBlockRegistry.STEEL_GUARDRAIL.get(), "Rambarde en acier");

                add(RSBlockRegistry.PAINT_BUCKET.get(), "Seau de peinture");
                add(RSItemRegistry.WOODEN_PAINT_BRUSH.get(), "Pinceau en bois");
                add(RSItemRegistry.STONE_PAINT_BRUSH.get(), "Pinceau en pierre");
                add(RSItemRegistry.IRON_PAINT_BRUSH.get(), "Pinceau en fer");
                add(RSItemRegistry.STEEL_PAINT_BRUSH.get(), "Pinceau en acier");
                add(RSItemRegistry.GOLDEN_PAINT_BRUSH.get(), "Pinceau en or");
                add(RSItemRegistry.DIAMOND_PAINT_BRUSH.get(), "Pinceau en diamant");
                add(RSItemRegistry.NETHERITE_PAINT_BRUSH.get(), "Pinceau en Netherite");

                add("roadstuff.message.bucket.empty", "Ce pot est vide !");
                add("roadstuff.message.bucket.yellow", "Ce pot est déjà rempli de peinture jaune !");
                add("roadstuff.message.bucket.white", "Ce pot est déjà rempli de peinture blanche !");
                add("roadstuff.message.bucket.full", "Ce pot est plein !");
                add("roadstuff.message.bucket.underwater", "Vous ne pouvez pas interagir avec un pot sous l'eau !");

                add("roadstuff.gui.paintbrush.title", "Configuration du pinceau");
                add("roadstuff.message.brush.gui.eraser", "Effaceur de peinture");
                add("roadstuff.message.brush.gui.pattern", "Motif n°");
                add("roadstuff.message.brush.gui.paint", "Quantité de peinture: ");
                add("roadstuff.message.brush.gui.color", "Couleur: ");
                add("roadstuff.message.brush.gui.fav1", "Clic droit sur un motif");
                add("roadstuff.message.brush.gui.fav2", "pour le mettre en favori !");

                add("roadstuff.message.paint.color.white", "Blanc");
                add("roadstuff.message.paint.color.yellow", "Jaune");

                add("itemGroup.roadstuff_group", "Road Stuff");
                break;
        }
    }
}