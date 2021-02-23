package com.aoc.days2020.day20;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class ImageCollection {

    private Tile[][] tiles;
    private int n;
    private Set<Long> ids = new HashSet<>();


    ImageCollection(final int n, final Tile tile) {
        this.n = n;
        this.tiles = new Tile[n][n];
        this.tiles[0][0] = tile;
        this.ids.add(tile.getId());
    }

    private ImageCollection(final ImageCollection image, final Tile tile, final int i, final int j) {
        this.n = image.n;
        this.tiles = new Tile[n][n];
        for (int k = 0; k < n; k++) {
            System.arraycopy(image.tiles[k], 0, this.tiles[k], 0, n);
        }
        this.tiles[i][j] = tile;
        this.ids.add(tile.getId());
        this.ids.addAll(image.ids);
    }

    Set<ImageCollection> next(final Map<Long, Set<Tile>> allTiles, final int i, final int j) {
        final Set<ImageCollection> newImages = new HashSet<>();
        final Tile leftNeighbour = get(i, j - 1);
        final Tile upperNeighbour = get(i - 1, j);
        final Tile rightNeighbour = get(i, j + 1);
        final Tile lowerNeighbour = get(i + 1, j);
        final Set<Tile> possibleTiles = collectPossibleTiles(allTiles, leftNeighbour, upperNeighbour, rightNeighbour, lowerNeighbour);
        if (!possibleTiles.isEmpty()) {
            for (final Tile tile : possibleTiles) {
                newImages.add(new ImageCollection(this, tile, i, j));
            }
        }
        return newImages;
    }

    private Set<Tile> collectPossibleTiles(final Map<Long, Set<Tile>> allTiles,
                                           final Tile left,
                                           final Tile upper,
                                           final Tile right,
                                           final Tile lower) {
        final Set<Tile> possibleTiles = new HashSet<>();
        for (final Map.Entry<Long, Set<Tile>> entry : allTiles.entrySet()) {
            if (!this.ids.contains(entry.getKey())) {
                for (final Tile tile : entry.getValue()) {
                    if (tile.matches(left, upper, right, lower)) {
                        possibleTiles.add(tile);
                    }
                }
            }
        }
        return possibleTiles;
    }

    private Tile get(final int i, final int j) {
        return (i >= 0 && i < this.n && j >= 0 && j < this.n) ? this.tiles[i][j] : null;
    }

    Tile[][] getTiles() {
        return tiles;
    }

    void print() {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < this.tiles[0][0].getPixel().length; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < this.tiles[0][0].getPixel().length; l++) {
                        if (this.tiles[i] != null && this.tiles[i][k] != null) {
                            builder.append(this.tiles[i][k].getPixel()[j][l] ? '#' : '.');
                        } else {
                            builder.append(".");
                        }
                    }
                    builder.append(" ");
                }
                builder.append("\n");
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }

    String stichImage() {
        final StringBuilder builder = new StringBuilder("Tile 1427:\n");
        final int pixelRowLength = this.tiles[0][0].getPixel().length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < pixelRowLength - 1; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 1; l < pixelRowLength - 1; l++) {
                        if (this.tiles[i] != null && this.tiles[i][k] != null) {
                            builder.append(this.tiles[i][k].getPixel()[j][l] ? '#' : '.');
                        }
                    }
                }
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof ImageCollection)) return false;
        final ImageCollection imageCollection = (ImageCollection) o;
        for (int i = 0; i < this.tiles.length; i++) {
            for (int j = 0; j < this.tiles[i].length; j++) {
                if (!Objects.equals(this.tiles[i][j], imageCollection.tiles[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(tiles);
    }
}
