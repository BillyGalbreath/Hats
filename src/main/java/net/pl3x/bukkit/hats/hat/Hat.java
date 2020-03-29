package net.pl3x.bukkit.hats.hat;

import com.google.common.collect.Maps;
import net.pl3x.bukkit.hats.Hats;
import net.pl3x.bukkit.hats.recipe.Ingredient;
import net.pl3x.bukkit.hats.recipe.Shape;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.Map;

public enum Hat {
    SS_GEORGIE(1, "SS Georgie", new Shape(" P ", "PPP", "   "), new Ingredient('P', Material.PAPER)),
    WIZARD_HAT_2(2, "Wizard Hat #2", new Shape(" P ", "Y P", "PYP"), new Ingredient('P', Material.PURPLE_CONCRETE), new Ingredient('Y', Material.YELLOW_CONCRETE)),
    WIZARD_HAT(3, "Wizard Hat", new Shape("B  ", "BB ", "BDB"), new Ingredient('B', Material.BLACK_CONCRETE), new Ingredient('D', Material.DIAMOND)),
    ROUND_TOP_HAT_WHITE_BLACK(4, "Round Top Hat (white/black)", new Shape(" W ", " W ", "WBW"), new Ingredient('B', Material.BLACK_CONCRETE), new Ingredient('W', Material.WHITE_WOOL)),
    ROUND_TOP_HAT_BLACK_WHITE(5, "Round Top Hat (black/white)", new Shape(" B ", " B ", "BWB"), new Ingredient('B', Material.BLACK_CONCRETE), new Ingredient('W', Material.WHITE_WOOL)),
    TOP_HAT_BLACK_YELLOW(6, "Top Hat (black/yellow)", new Shape(" B ", " B ", "BGB"), new Ingredient('B', Material.BLACK_CONCRETE), new Ingredient('G', Material.GOLD_INGOT)),
    TOP_HAT_BLACK_WHITE(7, "Top Hat (black/white)", new Shape(" B ", " B ", "BWB"), new Ingredient('B', Material.BLACK_CONCRETE), new Ingredient('W', Material.IRON_INGOT)),
    TOP_HAT_BLACK_RED(8, "Top Hat (black/red)", new Shape(" B ", " B ", "BRB"), new Ingredient('B', Material.BLACK_CONCRETE), new Ingredient('R', Material.REDSTONE)),
    TOP_HAT_BLACK_GREY(9, "Top Hat (black/grey)", new Shape(" B ", " B ", "BGB"), new Ingredient('B', Material.BLACK_CONCRETE), new Ingredient('G', Material.GRAY_CONCRETE)),
    TOP_HAT_BLACK_BLUE(10, "Top Hat (black/blue)", new Shape(" B ", " B ", "BLB"), new Ingredient('B', Material.BLACK_CONCRETE), new Ingredient('L', Material.LAPIS_LAZULI)),
    SQUID_HAT(11, "Squid Hat", new Shape("   ", " S ", " H "), new Ingredient('S', Material.SQUID_SPAWN_EGG), new Ingredient('H', Material.LEATHER_HELMET)),
    SOMBRERO(12, "Sombrero", new Shape("   ", "WHR", "HHH"), new Ingredient('R', Material.RED_WOOL), new Ingredient('W', Material.WHITE_WOOL), new Ingredient(  'H', Material.HAY_BLOCK)),
    SANTA_CAP(13, "Santa Cap", null), // Event/cash shop
    OCELOT_TUXEDO(14, "Ocelot Tuxedo", null), // Mob drop
    OCELOT_TABBY(15, "Ocelot Tabby", null), // Mob drop
    OCELOT_SIAMESE(16, "Ocelot Siamese", null), // Mob drop
    OCELOT(17, "Ocelot", null), // Mob drop
    MULLET(18, "Mullet", new Shape("yyy", "  Y", "  Y"), new Ingredient('y', Material.YELLOW_CARPET), new Ingredient('Y', Material.YELLOW_WOOL)),
    HIGH_HAT(19, "High Hat", new Shape(" B ", "GGG", "  P"), new Ingredient('B', Material.BLACK_WOOL), new Ingredient('G', Material.GRAY_CARPET), new Ingredient( 'P', Material.GLASS_PANE)),
    CAT_EARS_HEADPHONES(20, "Cat Ears Headphones", new Shape("OOO", "O O", "W  W"), new Ingredient('O', Material.ORANGE_CARPET), new Ingredient('Y', Material.WHITE_WOOL)),
    HARD_HAT_ON(21, "Hard Hat (on)", new Shape("YYY", "YTY", "   "), new Ingredient('Y', Material.YELLOW_CONCRETE), new Ingredient('T', Material.TORCH)),
    HARD_HAT_OFF(22, "Hard Hat (off)", new Shape("YYY", "Y Y", "   "), new Ingredient('Y', Material.YELLOW_CONCRETE)),
    FEZ(23, "Fez", new Shape("  W", " RR", " RR"), new Ingredient('W', Material.WHEAT), new Ingredient('R', Material.RED_WOOL)),
    EYE_BAND(24, "Eye Band", new Shape("   ", "BBS", "   "), new Ingredient('B', Material.BLACK_WOOL), new Ingredient('S', Material.SPIDER_EYE)),
    COWBOY_HAT(25, "Cowboy Hat", new Shape("   ", " W ", "WWW"), new Ingredient('W', Material.BROWN_WOOL)),
    CLOAK(26, "Cloak", new Shape("BBB", "B B", "B B"), new Ingredient('B', Material.BLACK_WOOL)),
    CAKE_HAT(27, "Cake Hat", null), // Event
    AFRO(28, "Afro", new Shape("BBB", "B B", "B B"), new Ingredient('B', Material.BLACK_CONCRETE)),
    UNEMPLOYED_DESERT(29, "Desert Unemployed", null), // Mob drop
    CLERIC_DESERT(30, "Desert Cleric", null), // Mob drop
    LEATHERWORKER_DESERT(31, "Desert Leatherworker", null), // Mob drop
    MASON_DESERT(32, "Desert Mason", null), // Mob drop
    NITWIT_DESERT(33, "Desert Nitwit", null), // Mob drop
    TOOLSMITH_DESERT(34, "Desert Toolsmith", null), // Mob drop
    UNEMPLOYED_SAVANNA(35, "Savanna Unemployed", null), // Mob drop
    CLERIC_SAVANNA(36, "Savanna Cleric", null), // Mob drop
    LEATHERWORKER_SAVANNA(37, "Savanna Leatherworker", null), // Mob drop
    MASON_SAVANNA(38, "Savanna Mason", null), // Mob drop
    NITWIT_SAVANNA(39, "Savanna Nitwit", null), // Mob drop
    TOOLSMITH_SAVANNA(40, "Savanna Toolsmith", null), // Mob drop
    UNEMPLOYED_SNOW(41, "Snow Unemployed", null), // Mob drop
    CLERIC_SNOW(42, "Snow Cleric", null), // Mob drop
    LEATHERWORKER_SNOW(43, "Snow Leatherworker", null), // Mob drop
    MASON_SNOW(44, "Snow Mason", null), // Mob drop
    NITWIT_SNOW(45, "Snow Nitwit", null), // Mob drop
    TOOLSMITH_SNOW(46, "Snow Toolsmith", null), // Mob drop
    UNEMPLOYED_SWAMP(47, "Swamp Unemployed", null), // Mob drop
    CLERIC_SWAMP(48, "Swamp Cleric", null), // Mob drop
    LEATHERWORKER_SWAMP(49, "Swamp Leatherworker", null), // Mob drop
    MASON_SWAMP(50, "Swamp Mason", null), // Mob drop
    NITWIT_SWAMP(51, "Swamp Nitwit", null), // Mob drop
    TOOLSMITH_SWAMP(52, "Swamp Toolsmith", null), // Mob drop
    ARMORER_DESERT(53, "Desert Armorer", null), // Mob drop
    ARMORER_JUNGLE(54, "Jungle Armorer", null), // Mob drop
    ARMORER_PLAINS(55, "Plains Armorer", null), // Mob drop
    ARMORER_SAVANNA(56, "Savanna Armorer", null), // Mob drop
    ARMORER_SNOW(57, "Snow Armorer", null), // Mob drop
    ARMORER_SWAMP(58, "Swamp Armorer", null), // Mob drop
    ARMORER_TAIGA(59, "Taiga Armorer", null) // Mob drop
    ;

    private final int model;
    private final String name;
    private final ItemStack item;
    private final Shape shape;
    private final Ingredient[] ingredients;

    Hat(int model, String name, Shape shape, Ingredient... ingredients) {
        this.model = model;
        this.name = name;
        this.shape = shape;
        this.ingredients = ingredients;
        this.item = new ItemStack(Material.FEATHER);
        this.item.setCustomModelData(model);
        this.item.setDisplayName(ChatColor.WHITE + this.name);
    }

    public int getModel() {
        return model;
    }

    public String getName() {
        return name;
    }

    public ItemStack getItem() {
        return item;
    }

    private void setRecipe() {
        if (shape == null) {
            return;
        }
        NamespacedKey key = new NamespacedKey(Hats.getInstance(), name().toLowerCase());
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape(shape.getRow1(), shape.getRow2(), shape.getRow3());
        for (Ingredient ingredient : ingredients) {
            recipe.setIngredient(ingredient.getCharacter(), ingredient.getMaterial());
        }
        Bukkit.addRecipe(recipe);
    }

    public static Hat getHat(ItemStack item) {
        if (item == null) {
            return null;
        }
        if (item.getType() != Material.FEATHER) {
            return null;
        }
        if (!item.hasCustomModelData()) {
            return null;
        }
        return Hat.getHat(item.getCustomModelData());
    }

    public static Hat getHat(String name) {
        return BY_NAME.get(name.toUpperCase());
    }

    public static Hat getHat(int model) {
        return BY_MODEL.get(model);
    }

    private static final Map<String, Hat> BY_NAME = Maps.newHashMap();
    private static final Map<Integer, Hat> BY_MODEL = Maps.newHashMap();

    static {
        for (Hat hat : values()) {
            BY_NAME.put(hat.name(), hat);
            BY_MODEL.put(hat.model, hat);
            hat.setRecipe();
        }
    }
}
