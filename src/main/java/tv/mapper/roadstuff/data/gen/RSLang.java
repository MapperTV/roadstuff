package tv.mapper.roadstuff.data.gen;

import java.util.Arrays;

import org.codehaus.plexus.util.StringUtils;

import net.minecraft.data.DataGenerator;
import net.minecraft.item.DyeColor;
import net.minecraftforge.common.data.LanguageProvider;
import tv.mapper.roadstuff.block.RSBlockRegistry;
import tv.mapper.roadstuff.item.RSItemRegistry;

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

                for(int i = 0; i < Arrays.stream(DyeColor.values()).count(); i++)
                {
                    String color = DyeColor.byId(i).getName();
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

                add(RSBlockRegistry.WHITE_BOLLARD.get(), "White Bollard");
                add(RSBlockRegistry.YELLOW_BOLLARD.get(), "Yellow Bollard");
                add(RSBlockRegistry.RED_BOLLARD.get(), "Red Bollard");
                add(RSBlockRegistry.WHITE_SMALL_BOLLARD.get(), "White Small Bollard");
                add(RSBlockRegistry.YELLOW_SMALL_BOLLARD.get(), "Yellow Small Bollard");
                add(RSBlockRegistry.RED_SMALL_BOLLARD.get(), "Red Small Bollard");

                add(RSBlockRegistry.STEEL_GUARDRAIL.get(), "Steel Guardrail");

                add(RSBlockRegistry.PAINT_BUCKET.get(), "Paint Bucket");
                add(RSItemRegistry.PAINT_BRUSH.get(), "Paint Brush");

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

                for(int i = 0; i < Arrays.stream(DyeColor.values()).count(); i++)
                {
                    String color = DyeColor.byId(i).getName();
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

                add(RSBlockRegistry.WHITE_BOLLARD.get(), "Bollard blanc");
                add(RSBlockRegistry.YELLOW_BOLLARD.get(), "Bollard jaune");
                add(RSBlockRegistry.RED_BOLLARD.get(), "Bollard rouge");
                add(RSBlockRegistry.WHITE_SMALL_BOLLARD.get(), "Petit bollard blanc");
                add(RSBlockRegistry.YELLOW_SMALL_BOLLARD.get(), "Petit bollard jaune");
                add(RSBlockRegistry.RED_SMALL_BOLLARD.get(), "Petit bollard rouge");

                add(RSBlockRegistry.STEEL_GUARDRAIL.get(), "Rambarde en acier");

                add(RSBlockRegistry.PAINT_BUCKET.get(), "Seau de peinture");
                add(RSItemRegistry.PAINT_BRUSH.get(), "Pinceau");

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