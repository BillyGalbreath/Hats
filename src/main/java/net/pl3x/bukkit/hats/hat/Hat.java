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
    UNEMPLOYED_DESERT(1, "Desert Unemployed"),
    //UNEMPLOYED_JUNGLE(2, "Jungle Unemployed"), // Not used
    //UNEMPLOYED_PLAINS(3, "Plains Unemployed"), // Not used
    UNEMPLOYED_SAVANNA(4, "Savanna Unemployed"),
    UNEMPLOYED_SNOW(5, "Snow Unemployed"),
    UNEMPLOYED_SWAMP(6, "Swamp Unemployed"),
    //UNEMPLOYED_TAIGA(7, "Taiga Unemployed"), // Not used
    ARMORER_DESERT(8, "Desert Armorer"),
    ARMORER_JUNGLE(9, "Jungle Armorer"),
    ARMORER_PLAINS(10, "Plains Armorer"),
    ARMORER_SAVANNA(11, "Savanna Armorer"),
    ARMORER_SNOW(12, "Snow Armorer"),
    ARMORER_SWAMP(13, "Swamp Armorer"),
    ARMORER_TAIGA(14, "Taiga Armorer"),
    BUTCHER_DESERT(15, "Desert Butcher"),
    BUTCHER_JUNGLE(16, "Jungle Butcher"),
    BUTCHER_PLAINS(17, "Plains Butcher"),
    BUTCHER_SAVANNA(18, "Savanna Butcher"),
    BUTCHER_SNOW(19, "Snow Butcher"),
    BUTCHER_SWAMP(20, "Swamp Butcher"),
    BUTCHER_TAIGA(21, "Taiga Butcher"),
    CARTOGRAPHER_DESERT(22, "Desert Cartographer"),
    CARTOGRAPHER_JUNGLE(23, "Jungle Cartographer"),
    CARTOGRAPHER_PLAINS(24, "Plains Cartographer"),
    CARTOGRAPHER_SAVANNA(25, "Savanna Cartographer"),
    CARTOGRAPHER_SNOW(26, "Snow Cartographer"),
    CARTOGRAPHER_SWAMP(27, "Swamp Cartographer"),
    CARTOGRAPHER_TAIGA(28, "Taiga Cartographer"),
    CLERIC_DESERT(29, "Desert Cleric"),
    //CLERIC_JUNGLE(30, "Jungle Cleric"), // Not used
    //CLERIC_PLAINS(31, "Plains Cleric"), // Not used
    CLERIC_SAVANNA(32, "Savanna Cleric"),
    CLERIC_SNOW(33, "Snow Cleric"),
    CLERIC_SWAMP(34, "Swamp Cleric"),
    //CLERIC_TAIGA(35, "Taiga Cleric"), // Not used
    FARMER_DESERT(36, "Desert Farmer"),
    FARMER_JUNGLE(37, "Jungle Farmer"),
    FARMER_PLAINS(38, "Plains Farmer"),
    FARMER_SAVANNA(39, "Savanna Farmer"),
    FARMER_SNOW(40, "Snow Farmer"),
    FARMER_SWAMP(41, "Swamp Farmer"),
    FARMER_TAIGA(42, "Taiga Farmer"),
    FISHERMAN_DESERT(43, "Desert Fisherman"),
    FISHERMAN_JUNGLE(44, "Jungle Fisherman"),
    FISHERMAN_PLAINS(45, "Plains Fisherman"),
    FISHERMAN_SAVANNA(46, "Savanna Fisherman"),
    FISHERMAN_SNOW(47, "Snow Fisherman"),
    FISHERMAN_SWAMP(48, "Swamp Fisherman"),
    FISHERMAN_TAIGA(49, "Taiga Fisherman"),
    FLETCHER_DESERT(50, "Desert Fletcher"),
    FLETCHER_JUNGLE(51, "Jungle Fletcher"),
    FLETCHER_PLAINS(52, "Plains Fletcher"),
    FLETCHER_SAVANNA(53, "Savanna Fletcher"),
    FLETCHER_SNOW(54, "Snow Fletcher"),
    FLETCHER_SWAMP(55, "Swamp Fletcher"),
    FLETCHER_TAIGA(56, "Taiga Fletcher"),
    LEATHERWORKER_DESERT(57, "Desert Leatherworker"),
    //LEATHERWORKER_JUNGLE(58, "Jungle Leatherworker"), // Not used
    //LEATHERWORKER_PLAINS(59, "Plains Leatherworker"), // Not used
    LEATHERWORKER_SAVANNA(60, "Savanna Leatherworker"),
    LEATHERWORKER_SNOW(61, "Snow Leatherworker"),
    LEATHERWORKER_SWAMP(62, "Swamp Leatherworker"),
    //LEATHERWORKER_TAIGA(63, "Taiga Leatherworker"), // Not used
    LIBRARIAN_DESERT(64, "Desert Librarian"),
    LIBRARIAN_JUNGLE(65, "Jungle Librarian"),
    LIBRARIAN_PLAINS(66, "Plains Librarian"),
    LIBRARIAN_SAVANNA(67, "Savanna Librarian"),
    LIBRARIAN_SNOW(68, "Snow Librarian"),
    LIBRARIAN_SWAMP(69, "Swamp Librarian"),
    LIBRARIAN_TAIGA(70, "Taiga Librarian"),
    MASON_DESERT(71, "Desert Mason"),
    //MASON_JUNGLE(72, "Jungle Mason"), // Not used
    //MASON_PLAINS(73, "Plains Mason"), // Not used
    MASON_SAVANNA(74, "Savanna Mason"),
    MASON_SNOW(75, "Snow Mason"),
    MASON_SWAMP(76, "Swamp Mason"),
    //MASON_TAIGA(77, "Taiga Mason"), // Not used
    NITWIT_DESERT(78, "Desert Nitwit"),
    //NITWIT_JUNGLE(79, "Jungle Nitwit"), // Not used
    //NITWIT_PLAINS(80, "Plains Nitwit"), // Not used
    NITWIT_SAVANNA(81, "Savanna Nitwit"),
    NITWIT_SNOW(82, "Snow Nitwit"),
    NITWIT_SWAMP(83, "Swamp Nitwit"),
    //NITWIT_TAIGA(84, "Taiga Nitwit"), // Not used
    SHEPHERD_DESERT(85, "Desert Shepherd"),
    SHEPHERD_JUNGLE(86, "Jungle Shepherd"),
    SHEPHERD_PLAINS(87, "Plains Shepherd"),
    SHEPHERD_SAVANNA(88, "Savanna Shepherd"),
    SHEPHERD_SNOW(89, "Snow Shepherd"),
    SHEPHERD_SWAMP(90, "Swamp Shepherd"),
    SHEPHERD_TAIGA(91, "Taiga Shepherd"),
    TOOLSMITH_DESERT(92, "Desert Toolsmith"),
    //TOOLSMITH_JUNGLE(93, "Jungle Toolsmith"), // Not used
    //TOOLSMITH_PLAINS(94, "Plains Toolsmith"), // Not used
    TOOLSMITH_SAVANNA(95, "Savanna Toolsmith"),
    TOOLSMITH_SNOW(96, "Snow Toolsmith"),
    TOOLSMITH_SWAMP(97, "Swamp Toolsmith"),
    //TOOLSMITH_TAIGA(98, "Taiga Toolsmith"), // Not used
    WEAPONSMITH_DESERT(99, "Desert Weaponsmith"),
    WEAPONSMITH_JUNGLE(100, "Jungle Weaponsmith"),
    WEAPONSMITH_PLAINS(101, "Plains Weaponsmith"),
    WEAPONSMITH_SAVANNA(102, "Savanna Weaponsmith"),
    WEAPONSMITH_SNOW(103, "Snow Weaponsmith"),
    WEAPONSMITH_SWAMP(104, "Swamp Weaponsmith"),
    WEAPONSMITH_TAIGA(105, "Taiga Weaponsmith"),

    SS_GEORGIE(106, "SS Georgie", new Shape(" P ", "PPP", "   "), new Ingredient('P', Material.PAPER)),
    WIZARD_HAT_2(107, "Wizard Hat #2", new Shape(" P ", "Y P", "PYP"), new Ingredient('P', Material.PURPLE_CONCRETE), new Ingredient('Y', Material.YELLOW_CONCRETE)),
    WIZARD_HAT(108, "Wizard Hat", new Shape("B  ", "BB ", "BDB"), new Ingredient('B', Material.BLACK_CONCRETE), new Ingredient('D', Material.DIAMOND)),
    ROUND_TOP_HAT_WHITE_BLACK(109, "Round Top Hat (white/black)", new Shape(" W ", " W ", "WBW"), new Ingredient('B', Material.BLACK_CONCRETE), new Ingredient('W', Material.WHITE_WOOL)),
    ROUND_TOP_HAT_BLACK_WHITE(110, "Round Top Hat (black/white)", new Shape(" B ", " B ", "BWB"), new Ingredient('B', Material.BLACK_CONCRETE), new Ingredient('W', Material.WHITE_WOOL)),
    TOP_HAT_BLACK_YELLOW(111, "Top Hat (black/yellow)", new Shape(" B ", " B ", "BGB"), new Ingredient('B', Material.BLACK_CONCRETE), new Ingredient('G', Material.GOLD_INGOT)),
    TOP_HAT_BLACK_WHITE(112, "Top Hat (black/white)", new Shape(" B ", " B ", "BWB"), new Ingredient('B', Material.BLACK_CONCRETE), new Ingredient('W', Material.IRON_INGOT)),
    TOP_HAT_BLACK_RED(113, "Top Hat (black/red)", new Shape(" B ", " B ", "BRB"), new Ingredient('B', Material.BLACK_CONCRETE), new Ingredient('R', Material.REDSTONE)),
    TOP_HAT_BLACK_GREY(114, "Top Hat (black/grey)", new Shape(" B ", " B ", "BGB"), new Ingredient('B', Material.BLACK_CONCRETE), new Ingredient('G', Material.GRAY_CONCRETE)),
    TOP_HAT_BLACK_BLUE(115, "Top Hat (black/blue)", new Shape(" B ", " B ", "BLB"), new Ingredient('B', Material.BLACK_CONCRETE), new Ingredient('L', Material.LAPIS_LAZULI)),
    SQUID_HAT(116, "Squid Hat", new Shape("   ", " S ", " H "), new Ingredient('S', Material.SQUID_SPAWN_EGG), new Ingredient('H', Material.LEATHER_HELMET)),
    SOMBRERO(117, "Sombrero", new Shape("   ", "WHR", "HHH"), new Ingredient('R', Material.RED_WOOL), new Ingredient('W', Material.WHITE_WOOL), new Ingredient('H', Material.HAY_BLOCK)),
    SANTA_CAP(118, "Santa Cap"), // Event/cash shop
    OCELOT_TUXEDO(119, "Ocelot Tuxedo"), // Mob drop
    OCELOT_TABBY(120, "Ocelot Tabby"), // Mob drop
    OCELOT_SIAMESE(121, "Ocelot Siamese"), // Mob drop
    OCELOT(122, "Ocelot"), // Mob drop
    MULLET(123, "Mullet", new Shape("yyy", "  Y", "  Y"), new Ingredient('y', Material.YELLOW_CARPET), new Ingredient('Y', Material.YELLOW_WOOL)),
    HIGH_HAT(124, "High Hat", new Shape(" B ", "GGG", "  P"), new Ingredient('B', Material.BLACK_WOOL), new Ingredient('G', Material.GRAY_CARPET), new Ingredient('P', Material.GLASS_PANE)),
    CAT_EARS_HEADPHONES(125, "Cat Ears Headphones", new Shape("OOO", "O O", "W W"), new Ingredient('O', Material.ORANGE_CARPET), new Ingredient('W', Material.WHITE_WOOL)),
    HARD_HAT_ON(126, "Hard Hat (on)", new Shape("YYY", "YTY", "   "), new Ingredient('Y', Material.YELLOW_CONCRETE), new Ingredient('T', Material.TORCH)),
    HARD_HAT_OFF(127, "Hard Hat (off)", new Shape("YYY", "Y Y", "   "), new Ingredient('Y', Material.YELLOW_CONCRETE)),
    FEZ(128, "Fez", new Shape("  W", " RR", " RR"), new Ingredient('W', Material.WHEAT), new Ingredient('R', Material.RED_WOOL)),
    EYE_BAND(129, "Eye Band", new Shape("   ", "BBS", "   "), new Ingredient('B', Material.BLACK_WOOL), new Ingredient('S', Material.SPIDER_EYE)),
    COWBOY_HAT(130, "Cowboy Hat", new Shape("   ", " W ", "WWW"), new Ingredient('W', Material.BROWN_WOOL)),
    CLOAK(131, "Cloak", new Shape("BBB", "B B", "B B"), new Ingredient('B', Material.BLACK_WOOL)),
    CAKE_HAT(132, "Cake Hat"), // Event
    AFRO(133, "Afro", new Shape("BBB", "B B", "B B"), new Ingredient('B', Material.BLACK_CONCRETE)),
    ;

    private final int model;
    private final String name;
    private final ItemStack item;
    private final Shape shape;
    private final Ingredient[] ingredients;

    Hat(int model, String name) {
        this(model, name, null);
    }

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
