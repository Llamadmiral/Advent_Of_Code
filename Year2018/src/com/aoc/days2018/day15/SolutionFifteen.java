package com.aoc.days2018.day15;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.aoc.days2018.day15.BoardConstants.ELF;
import static com.aoc.days2018.day15.BoardConstants.EMPTY;
import static com.aoc.days2018.day15.BoardConstants.GOBLIN;

/**
 * @author Llamadmiral.
 */
class SolutionFifteen extends SolutionBase {

    private static final int[][] NEIGHBOUR_MATRIX = new int[][]{
        new int[]{-1, 0},
        new int[]{0, -1},
        new int[]{0, 1},
        new int[]{1, 0},
    };

    private static final Comparator<BoardPiece> COMBATANT_COMPARATOR =
        (piece, other) -> piece.getRow() == other.getRow()
            ? piece.getColumn() - other.getColumn()
            : piece.getRow() - other.getRow();

    private BoardPiece[][] board;

    private int currentCombatantIndex = 0;

    private List<BoardPiece> combatants = new ArrayList<>();

    SolutionFifteen(final String day) {
        super(day);
    }

    @Override
    public void init() {
        final String[] rows = input.split("\n");
        board = new BoardPiece[rows.length][rows[0].length()];
        buildBoard(rows, board);
        System.out.println(combatants);
        log();
    }

    @Override
    protected void solvePartOne() {
        simulateRound();
    }

    private void simulateRound() {
        BoardPiece actor;
        boolean finished = false;
        while (!finished) {
            actor = getNextActor();
            if (actor != null) {
                final List<BoardPiece> closestTargets = getClosestTargets(actor);
                System.out.println(actor + " -> " + closestTargets);
            } else {
                finished = true;
            }
        }
    }

    @Override
    protected void solvePartTwo() {
        //not yet solved
    }

    private List<BoardPiece> getClosestTargets(final BoardPiece actor) {
        final List<BoardPiece> boardPieces = new ArrayList<>();
        int minimalTargetPieceDistance = 0;
        final String targetType = actor.getType().equals(ELF) ? GOBLIN : ELF;
        for (final BoardPiece target : combatants) {
            if (target.getType().equals(targetType)) {
                final int distance = manhattanDistance(actor, target);
                if (minimalTargetPieceDistance == 0 || distance < minimalTargetPieceDistance) {
                    final BoardPiece closestFreePiece = getClosestFreePiece(actor, target, EMPTY);
                    if (closestFreePiece != null) {
                        minimalTargetPieceDistance = distance;
                        boardPieces.clear();
                        boardPieces.add(closestFreePiece);
                    }
                } else if (distance == minimalTargetPieceDistance) {
                    final BoardPiece closestFreePiece = getClosestFreePiece(actor, target, EMPTY);
                    if (closestFreePiece != null) {
                        boardPieces.add(closestFreePiece);
                    }
                }
            }
        }
        return boardPieces;
    }

    private BoardPiece getNextActor() {
        BoardPiece piece = null;
        for (int i = currentCombatantIndex; i < combatants.size(); i++) {
            final BoardPiece possiblePiece = combatants.get(i);
            if (possiblePiece.canAct()) {
                piece = possiblePiece;
                currentCombatantIndex++;
                break;
            }
        }
        return piece;
    }

    private void buildBoard(final String[] rows, final BoardPiece[][] board) {
        for (int rowIndex = 0; rowIndex < rows.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < rows[rowIndex].length(); columnIndex++) {
                final char tile = rows[rowIndex].charAt(columnIndex);
                final BoardPiece piece = new BoardPiece(rowIndex, columnIndex, tile);
                board[rowIndex][columnIndex] = piece;
                if (piece.canAct()) {
                    combatants.add(piece);
                }
            }
        }
        combatants.sort(COMBATANT_COMPARATOR);
    }

    private void log() {
        final StringBuilder builder = new StringBuilder();
        for (final BoardPiece[] row : board) {
            for (final BoardPiece piece : row) {
                builder.append(piece.getTile());
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }

    private int manhattanDistance(final BoardPiece from, final BoardPiece to) {
        return Math.abs(to.getRow() - from.getRow()) + Math.abs(to.getColumn() - from.getColumn());
    }

    private BoardPiece getClosestFreePiece(final BoardPiece attacker, final BoardPiece piece, final String filter) {
        BoardPiece closestFreePiece = null;
        int minDistance = 0;
        for (final int[] offset : NEIGHBOUR_MATRIX) {
            final BoardPiece neighbour = getPieceByCoordinates(piece.getRow() + offset[0], piece.getColumn() + offset[1]);
            if (neighbour != null && neighbour.getType().equals(filter)) {
                final int distance = manhattanDistance(attacker, neighbour);
                if (minDistance == 0 || distance < minDistance) {
                    minDistance = distance;
                    closestFreePiece = neighbour;
                }
            }
        }
        return closestFreePiece;
    }

    private BoardPiece getPieceByCoordinates(final int row, final int column) {
        return row >= 0 && row < board.length && column >= 0 && column <= board[row].length ? board[row][column] : null;
    }

}