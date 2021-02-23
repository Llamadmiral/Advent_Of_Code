package com.aoc.days2020.day20;

import com.aoc.util.stringutil.StringUtils;

import java.util.Arrays;

class Tile {


    private static final String SEA_MONSTER =
        "                  # \n"
            + "#    ##    ##    ###\n"
            + " #  #  #  #  #  #   ";

    private static int[][] OFFSETS;

    static {
        int n = SEA_MONSTER.length() - SEA_MONSTER.replace("#", "").length();
        OFFSETS = new int[n][2];
        final String[] rows = SEA_MONSTER.split("\n");
        int counter = 0;
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[i].length(); j++) {
                if (rows[i].charAt(j) == '#') {
                    OFFSETS[counter] = new int[]{i, j};
                    counter++;
                }
            }
        }

    }

    private long id;
    private boolean[][] pixel;
    private int upperBorder = 0;
    private int lowerBorder = 0;
    private int leftBorder = 0;
    private int rightBorder = 0;
    private int n;
    private int rocks = 0;

    Tile(final String image) {
        final String[] rows = image.split("\n");
        final String idRow = rows[0];
        this.id = Long.parseLong(idRow.substring(idRow.indexOf(" ") + 1, idRow.length() - 1));
        n = rows[1].length();
        pixel = new boolean[n][n];
        for (int i = 1; i < rows.length; i++) {
            for (int j = 0; j < rows[i].length(); j++) {
                final boolean cactus = rows[i].charAt(j) == '#';
                pixel[i - 1][j] = cactus;
                if (cactus) {
                    this.rocks++;
                    if (i == 1) {
                        this.upperBorder++;
                    }
                    if (j == 0) {
                        this.leftBorder++;
                    }
                    if (i == this.n - 1) {
                        this.lowerBorder++;
                    }
                    if (j == this.n - 1) {
                        this.rightBorder++;
                    }
                }
            }
        }
    }

    private Tile(final Tile tile) {
        this.id = tile.id;
        this.rightBorder = tile.rightBorder;
        this.lowerBorder = tile.lowerBorder;
        this.leftBorder = tile.leftBorder;
        this.upperBorder = tile.upperBorder;
        this.n = tile.n;
        this.rocks = tile.rocks;
        this.pixel = new boolean[this.n][this.n];
        final boolean[][] pixels = tile.pixel;
        for (int i = 0; i < pixels.length; i++) {
            final boolean[] row = pixels[i];
            System.arraycopy(row, 0, this.pixel[i], 0, row.length);
        }
    }

    Tile rotateTile() {
        final Tile newTile = new Tile(this);
        for (int i = 0; i < this.n / 2; i++) {
            for (int j = i; j < this.n - i - 1; j++) {
                boolean temp = newTile.pixel[i][j];
                newTile.pixel[i][j] = newTile.pixel[j][this.n - 1 - i];
                newTile.pixel[j][this.n - 1 - i] = newTile.pixel[this.n - 1 - i][this.n - 1 - j];
                newTile.pixel[this.n - 1 - i][this.n - 1 - j] = newTile.pixel[this.n - 1 - j][i];
                newTile.pixel[this.n - 1 - j][i] = temp;
            }
        }
        final int temp = newTile.leftBorder;
        newTile.leftBorder = newTile.lowerBorder;
        newTile.lowerBorder = newTile.rightBorder;
        newTile.rightBorder = newTile.upperBorder;
        newTile.upperBorder = temp;
        return newTile;
    }

    Tile flipVertical() {
        final Tile newTile = new Tile(this);
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n / 2; j++) {
                boolean temp = newTile.pixel[i][j];
                newTile.pixel[i][j] = newTile.pixel[i][this.n - 1 - j];
                newTile.pixel[i][this.n - 1 - j] = temp;
            }
        }
        final int temp = newTile.rightBorder;
        newTile.rightBorder = newTile.leftBorder;
        newTile.leftBorder = temp;
        return newTile;
    }

    Tile flipHorizontal() {
        final Tile newTile = new Tile(this);
        for (int i = 0; i < this.n / 2; i++) {
            boolean[] temp = newTile.pixel[i];
            newTile.pixel[i] = newTile.pixel[this.n - 1 - i];
            newTile.pixel[this.n - 1 - i] = temp;
        }
        final int temp = newTile.upperBorder;
        newTile.upperBorder = newTile.lowerBorder;
        newTile.lowerBorder = temp;
        return newTile;
    }

    boolean matches(final Tile left, final Tile upper, final Tile right, final Tile lower) {
        boolean matches = true;
        if (left != null) {
            for (int i = 0; i < this.n; i++) {
                if (left.pixel[i][this.n - 1] != this.pixel[i][0]) {
                    matches = false;
                    break;
                }
            }
        }
        if (matches && upper != null) {
            for (int i = 0; i < this.n; i++) {
                if (upper.pixel[this.n - 1][i] != this.pixel[0][i]) {
                    matches = false;
                    break;
                }
            }
        }
        if (matches && right != null) {
            for (int i = 0; i < this.n; i++) {
                if (right.pixel[i][0] != this.pixel[i][this.n - 1]) {
                    matches = false;
                    break;
                }
            }
        }
        if (matches && lower != null) {
            for (int i = 0; i < this.n; i++) {
                if (lower.pixel[0][i] != this.pixel[this.n - 1][i]) {
                    matches = false;
                    break;
                }
            }
        }
        return matches;
    }

    long getId() {
        return this.id;
    }

    boolean[][] getPixel() {
        return pixel;
    }

    int getRocks() {
        return rocks;
    }

    int countSeaMonster() {
        int count = 0;
        for (int i = 0; i < this.pixel.length; i++) {
            for (int j = 0; j < this.pixel[i].length; j++) {
                boolean allMonster = true;
                for (final int[] offset : OFFSETS) {
                    final boolean pix = get(i + offset[0], j + offset[1]);
                    if (!pix) {
                        allMonster = false;
                        break;
                    }
                }
                if (allMonster) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean get(final int i, final int j) {
        return i < this.pixel.length && j < this.pixel[i].length && this.pixel[i][j];
    }

    void print() {
        System.out.println(getImageString());
    }

    private String getImageString() {
        final char[][] matrix = new char[this.pixel.length][this.pixel[0].length];
        for (int i = 0; i < this.pixel.length; i++) {
            for (int j = 0; j < this.pixel[i].length; j++) {
                matrix[i][j] = this.pixel[i][j] ? '#' : '.';
            }
        }
        return StringUtils.charMatrixToArray(matrix);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Tile)) return false;
        final Tile tile = (Tile) o;
        for (int i = 0; i < this.pixel.length; i++) {
            for (int j = 0; j < this.pixel[i].length; j++) {
                if (this.pixel[i][j] != tile.pixel[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int i = 1;
        for (final boolean[] row : pixel) {
            i *= Arrays.hashCode(row);
        }
        return i;
    }
}
