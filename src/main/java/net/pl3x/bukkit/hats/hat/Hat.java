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
    SS_GEORGIE(1, "SS Georgie", null),
    WIZARD_HAT_2(2, "Wizard Hat #2", null),
    WIZARD_HAT(3, "Wizard Hat", null),
    ROUND_TOP_HAT_WHITE_BLACK(4, "Round Top Hat (white/black)", null),
    ROUND_TOP_HAT_BLACK_WHITE(5, "Round Top Hat (black/white)", null),
    TOP_HAT_BLACK_YELLOW(6, "Top Hat (black/yellow)", null),
    TOP_HAT_BLACK_WHITE(7, "Top Hat (black/white)", null),
    TOP_HAT_BLACK_RED(8, "Top Hat (black/red)", null),
    TOP_HAT_BLACK_GREY(9, "Top Hat (black/grey)", null),
    TOP_HAT_BLACK_BLUE(10, "Top Hat (black/blue)", null),
    SQUID_HAT(11, "Squid Hat", null),
    SOMBRERO(12, "Sombrero", null),
    SANTA_CAP(13, "Santa Cap", null),
    OCELOT_TUXEDO(14, "Ocelot Tuxedo", null),
    OCELOT_TABBY(15, "Ocelot Tabby", null),
    OCELOT_SIAMESE(16, "Ocelot Siamese", null),
    OCELOT(17, "Ocelot", null),
    MULLET(18, "Mullet", null),
    HIGH_HAT(19, "High Hat", null),
    CAT_EARS_HEADPHONES(20, "Cat Ears Headphones", null),
    HARD_HAT_ON(21, "Hard Hat (on)", null),
    HARD_HAT_OFF(22, "Hard Hat (off)", null),
    FEz(23, "Fez", null),
    EYE_BAND(24, "Eye Band", null),
    COWBOY_HAT(25, "Cowboy Hat", new Shape("   ", " W ", "WWW"), new Ingredient('W', Material.BROWN_WOOL)),
    CLOAK(26, "Cloak", null),
    CAKE_HAT(27, "Cake Hat", null),
    AFRO(28, "Afro", null);

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
