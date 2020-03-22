package net.pl3x.bukkit.hats.recipe;

import org.bukkit.Material;

public class Ingredient {
    private final char character;
    private final Material material;

    public Ingredient(char character, Material material) {
        this.character = character;
        this.material = material;
    }

    public char getCharacter() {
        return character;
    }

    public Material getMaterial() {
        return material;
    }
}
