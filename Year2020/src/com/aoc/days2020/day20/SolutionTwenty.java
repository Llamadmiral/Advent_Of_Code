package com.aoc.days2020.day20;

import com.aoc.solutionbase.SolutionBase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Llamadmiral.
 */
class SolutionTwenty extends SolutionBase {

    private final Map<Long, Set<Tile>> tiles = new HashMap<>();
    private Set<Tile> possibleMonsterTiles = new HashSet<>();

    SolutionTwenty(final String day) {
        super(day);
    }

    @Override
    public void init() {
        final String[] images = input.split("\n\n");
        for (final String image : images) {
            final Tile baseTile = new Tile(image);
            tiles.put(baseTile.getId(), generateFlipsAndRotations(baseTile));
        }
    }

    private Set<Tile> generateFlipsAndRotations(final Tile tile) {
        final Set<Tile> transformations = new HashSet<>();
        transformations.add(tile);
        transformations.add(tile.flipHorizontal());
        transformations.add(tile.flipVertical());
        Tile currentTile = tile;
        for (int i = 0; i < 3; i++) {
            final Tile flippedVertically = currentTile.flipVertical();
            final Tile flippedHorizontally = currentTile.flipHorizontal();
            final Tile rotatedTile = currentTile.rotateTile();
            transformations.add(flippedVertically);
            transformations.add(flippedHorizontally);
            transformations.add(rotatedTile);
            currentTile = rotatedTile;
        }
        return transformations;
    }

    @Override
    protected void solvePartOne() {
        Set<ImageCollection> imageCollections = new HashSet<>();
        final int n = (int) Math.sqrt(tiles.size());
        for (final Set<Tile> tileSet : tiles.values()) {
            for (final Tile tile : tileSet) {
                final ImageCollection imageCollection = new ImageCollection(n, tile);
                imageCollections.add(imageCollection);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0 || j != 0) {
                    imageCollections = nextGen(imageCollections, i, j);
                }
            }
        }
        final Tile[][] tiles = imageCollections.iterator().next().getTiles();
        final Tile[] firstRow = tiles[0];
        final Tile[] lastRow = tiles[tiles.length - 1];
        setSolutionOne(firstRow[0].getId() * firstRow[firstRow.length - 1].getId() * lastRow[0].getId() * lastRow[lastRow.length - 1].getId());
        for (final ImageCollection imageCollection : imageCollections) {
            possibleMonsterTiles.add(new Tile(imageCollection.stichImage()));
        }
    }

    private Set<ImageCollection> nextGen(final Set<ImageCollection> currentImages, final int i, final int j) {
        final Set<ImageCollection> newImages = new HashSet<>();
        for (final ImageCollection imageCollection : currentImages) {
            newImages.addAll(imageCollection.next(tiles, i, j));
        }
        return newImages;
    }

    @Override
    protected void solvePartTwo() {
        Tile monsterTile = null;
        int count = 0;
        for (final Tile possibleMonsterTile : possibleMonsterTiles) {
            count = possibleMonsterTile.countSeaMonster();
            if (count > 0) {
                monsterTile = possibleMonsterTile;
                break;
            }
        }
        setSolutionTwo(monsterTile.getRocks() - 15 * count);
    }

}