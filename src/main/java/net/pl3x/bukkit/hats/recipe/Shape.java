package net.pl3x.bukkit.hats.recipe;

import java.util.ArrayList;
import java.util.List;

public class Shape {
    private final String row1;
    private final String row2;
    private final String row3;

    public Shape(String row1) {
        this(row1, null, null);
    }

    public Shape(String row1, String row2) {
        this(row1, row2, null);
    }

    public Shape(String row1, String row2, String row3) {
        this.row1 = row1;
        this.row2 = row2;
        this.row3 = row3;
    }

    public String[] getRows() {
        List<String> list = new ArrayList<>();
        if (row1 != null) list.add(row1);
        if (row2 != null) list.add(row2);
        if (row3 != null) list.add(row3);
        return list.toArray(new String[0]);
    }
}
