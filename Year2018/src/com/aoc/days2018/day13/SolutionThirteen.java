package com.aoc.days2018.day13;

import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.stringutil.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Llamadmiral.
 */
class SolutionThirteen extends SolutionBase {
    private static final Set<Character> BASE_TRACKS = new HashSet<>();
    private static final char[] DIR = "<^>v".toCharArray();

    private static final int[][] OFFSET_COORDS = new int[][]{
        new int[]{0, -1},
        new int[]{-1, 0},
        new int[]{0, 1},
        new int[]{1, 0}
    };
    private static final Comparator<Cart> CART_COMPARATOR = (o1, o2) ->
        o1.getX() < o2.getX()
            ? -1
            : (o1.getX() == o2.getX() ? (o1.getY() < o2.getY() ? -1 : 1) : 1);

    static {
        BASE_TRACKS.add('|');
        BASE_TRACKS.add('-');
        BASE_TRACKS.add('+');
        BASE_TRACKS.add('/');
        BASE_TRACKS.add('\\');
        BASE_TRACKS.add(' ');
        BASE_TRACKS.add((char) 0);
    }

    private Set<Cart> carts = new TreeSet<>(CART_COMPARATOR);
    private char[][] trackMap = null;
    private String solutionOne = null;

    SolutionThirteen(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        boolean crashed = false;
        while (!crashed) {
            final Set<Cart> newCarts = new TreeSet<>(CART_COMPARATOR);
            for (final Cart cart : carts) {
                if (cart.isAlive()) {
                    crashed = tick(cart);
                    if (!crashed) {
                        newCarts.add(cart);
                    } else {
                        break;
                    }
                }
            }
            carts = newCarts;
        }
        setSolutionOne(solutionOne);
    }

    @Override
    protected void solvePartTwo() {
        reset();
        while (countAliveCarts() != 1) {
            final Set<Cart> newCarts = new TreeSet<>(CART_COMPARATOR);
            for (final Cart cart : carts) {
                if (cart.isAlive() && !tick(cart)) {
                    newCarts.add(cart);
                }
            }
            carts = newCarts;
        }
        final Cart lastCart = getLastAliveCart();
        if (lastCart != null) {
            setSolutionTwo(lastCart.getX() + "," + lastCart.getY());
        }
    }

    private int countAliveCarts() {
        int sum = 0;
        for (final Cart cart : carts) {
            if (cart.isAlive()) {
                sum++;
            }
        }
        return sum == 0 ? 1 : sum;
    }

    private void reset() {
        carts.clear();
        init();
    }

    private boolean tick(final Cart cart) {
        boolean crashed = false;
        final char current = trackMap[cart.getY()][cart.getX()];
        if (current == '-' || current == '|') {
            crashed = moveCart(cart);
        } else if (current == '/') {
            final int currentDir = cart.getCurrentDir();
            cart.setCurrentDir((3 - currentDir));
            crashed = moveCart(cart);
        } else if (current == '\\') {
            cart.setCurrentDir((Math.floorMod((1 - cart.getCurrentDir()), 4)));
            crashed = moveCart(cart);
        } else if (current == '+') {
            final int intersectDir = cart.getNextIntersectionDir();
            if (intersectDir == 0) {
                cart.setCurrentDir(Math.floorMod((cart.getCurrentDir() - 1), 4));
            } else if (intersectDir == 2) {
                cart.setCurrentDir(Math.floorMod((cart.getCurrentDir() + 1), 4));
            }
            crashed = moveCart(cart);
            cart.setNextIntersectionDir((intersectDir + 1) % 3);
        }
        return crashed;
    }

    private boolean moveCart(final Cart cart) {
        boolean crashed = false;
        final int[] offsets = OFFSET_COORDS[cart.getCurrentDir()];
        final int x = cart.getX();
        final int y = cart.getY();
        final int newY = y + offsets[0];
        final int newX = x + offsets[1];
        cart.setX(newX);
        cart.setY(newY);
        if (checkCrashes(cart)) {
            if (solutionOne == null) {
                solutionOne = (newX) + "," + (newY);
            }
            crashed = true;
        }
        return crashed;
    }

    private boolean checkCrashes(final Cart cart) {
        boolean crashed = false;
        for (final Cart otherCart : carts) {
            if (otherCart.isAlive() && cart.getId() != otherCart.getId() && cart.getX() == otherCart.getX() && cart.getY() == otherCart.getY()) {
                cart.setAlive(false);
                otherCart.setAlive(false);
                crashed = true;
                break;
            }
        }
        return crashed;
    }

    private void printMap() {
        final char[][] map = new char[trackMap.length][trackMap[0].length];
        for (int y = 0; y < trackMap.length; y++) {
            char[] row = trackMap[y];
            System.arraycopy(trackMap[y], 0, map[y], 0, row.length);
        }
        for (final Cart cart : carts) {
            if (cart.isAlive()) {
                map[cart.getY()][cart.getX()] = DIR[cart.getCurrentDir()];
            }
        }
        System.out.println(StringUtils.charMatrixToArray(map));
    }

    @Override
    public void init() {
        List<char[]> rows = new ArrayList<>();
        String[] split = input.split("\n");
        for (int y = 0; y < split.length; y++) {
            String row = split[y];
            final char[] cRow = new char[row.length()];
            char[] charArray = row.toCharArray();
            for (int x = 0; x < charArray.length; x++) {
                final char c = charArray[x];
                if (c == '<' || c == '>' || c == '^' || c == 'v') {
                    int direction = -1;
                    char trackPiece = 0;
                    switch (c) {
                        case '<':
                            direction = 0;
                            trackPiece = '-';
                            break;
                        case '>':
                            direction = 2;
                            trackPiece = '-';
                            break;
                        case '^':
                            direction = 1;
                            trackPiece = '|';
                            break;
                        case 'v':
                            direction = 3;
                            trackPiece = '|';
                            break;
                        default:
                            break;
                    }
                    final Cart cart = new Cart(x, y, direction);
                    carts.add(cart);
                    cRow[x] = trackPiece;
                } else {
                    cRow[x] = c;
                }
            }
            rows.add(cRow);
        }
        trackMap = new char[rows.size()][rows.get(0).length];
        for (int i = 0; i < rows.size(); i++) {
            trackMap[i] = rows.get(i);
        }
    }

    public Cart getLastAliveCart() {
        Cart lastCart = null;
        for (final Cart cart : carts) {
            if (cart.isAlive()) {
                lastCart = cart;
                break;
            }
        }
        return lastCart;
    }
}
