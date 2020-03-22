package net.pl3x.bukkit.hats.recipe;

public class Shape {
    private final String row1;
    private final String row2;
    private final String row3;

    public Shape(String row1, String row2, String row3) {
        this.row1 = row1;
        this.row2 = row2;
        this.row3 = row3;
    }

    public String getRow1() {
        return row1;
    }

    public String getRow2() {
        return row2;
    }

    public String getRow3() {
        return row3;
    }
}
