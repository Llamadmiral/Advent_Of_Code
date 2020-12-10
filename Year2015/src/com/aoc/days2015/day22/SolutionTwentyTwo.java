package com.aoc.days2015.day22;

import com.aoc.solutionbase.SolutionBase;

import static com.aoc.days2015.day22.SpellConstants.DRAIN;
import static com.aoc.days2015.day22.SpellConstants.MAGIC_MISSILE;
import static com.aoc.days2015.day22.SpellConstants.POISON;
import static com.aoc.days2015.day22.SpellConstants.RECHARGE;
import static com.aoc.days2015.day22.SpellConstants.SHIELD;
import static com.aoc.days2015.day22.SpellConstants.WHAM;

/**
 * @author Llamadmiral.
 */
class SolutionTwentyTwo extends SolutionBase {
    private static final Spell HIT_IT_VERY_HARD = new Spell(WHAM);
    private static final Spell[] HERO_SPELLS = new Spell[]{
        new Spell(RECHARGE),
        new Spell(POISON),
        new Spell(SHIELD),
        new Spell(DRAIN),
        new Spell(MAGIC_MISSILE)
    };

    private Contestant boss;
    private Contestant hero;

    SolutionTwentyTwo(final String day) {
        super(day);
    }

    /*static void log(final String msg) {
        builder.append(msg).append("\n");
    }*/

    private void testFight() {
        boss = new Contestant("Boss", 13, 0, 8, 0);
        hero = new Contestant("Hero", 10, 0, 0, 250);
        final int cost = simulateFight(new Spell[]{HERO_SPELLS[0], HERO_SPELLS[3]}, false);
        System.out.println(cost);
    }

    @Override
    protected void solvePartOne() {
        setSolutionOne(getSmallestCostOfWin(false));
    }

    @Override
    protected void solvePartTwo() {
        setSolutionTwo(getSmallestCostOfWin(true));
    }

    private int getSmallestCostOfWin(final boolean partTwo) {
        boss = new Contestant("Boss", 51, 0, 9, 0);
        hero = new Contestant("Hero", 50, 0, 0, 500);
        int[] spellIndexes = new int[7];
        int smallestCost = 0;
        boolean checkingRange = false;
        int c = 0;
        while (true) {
            spellIndexes = getSpellsToCast(spellIndexes, checkingRange);
            if (spellIndexes != null) {
                final Spell[] spells = convertToSpells(spellIndexes);
                final int spentMana = simulateFight(spells, partTwo);
                if (smallestCost == 0 || smallestCost >= spentMana) {
                    if (spentMana > 0) {
                        checkingRange = true;
                        smallestCost = spentMana;
                    }
                }
                if (spentMana == 1216) {
                    c++;
                    //System.out.println(Arrays.toString(spells));
                }
            } else {
                break;
            }
        }
        System.out.println(c);
        return smallestCost;
    }

    private Spell[] convertToSpells(final int[] spellIndexes) {
        final Spell[] spells = new Spell[spellIndexes.length];
        for (int i = 0; i < spellIndexes.length; i++) {
            final int index = spellIndexes[i];
            spells[i] = HERO_SPELLS[index];
        }
        return spells;
    }

    private int simulateFight(final Spell[] spells, final boolean partTwo) {
        //builder = new StringBuilder();
        hero.reset();
        boss.reset();
        int i = spells.length - 1;
        boolean playerTurn = true;
        boolean fightEnded = false;
        boolean playerWon = false;
        int cost = 0;
        while (!fightEnded) {
            //log(String.format("%s turn", playerTurn ? "Player" : "Boss"));
            //log(String.format("-- Player has %s hit points, %s armour, %s mana", hero.getHealthPoint(), hero.getArmour(), hero.getMana()));
            //log(String.format("-- Boss has %s hit points", boss.getHealthPoint()));
            hero.setArmour(0);
            if (playerTurn) {
                if (partTwo) {
                    hero.damage(1);
                    //log("--Player suffers 1 damage!");
                    if (hero.getHealthPoint() <= 0) {
                        //log("Hero died of heart failure!");
                        fightEnded = true;
                    }
                }
                if (!fightEnded && i > -1) {
                    hero.applyEffects();
                    boss.applyEffects();
                    if (boss.getHealthPoint() > 0) {
                        final Spell spell = spells[i];
                        if (spell.getCost() <= hero.getMana()) {
                            //log(String.format("- Player casts %s.", spell.getName()));
                            boolean didAnything = hero.performRound(boss, spells[i]);
                            cost += spell.getCost();
                            if (!didAnything) {
                                fightEnded = true;
                                //System.out.println("Illegal spell!");
                                //System.out.println(Arrays.toString(spells));
                            }
                            i--;
                        } else {
                            //log("Player has no mana for " + spell.getName() + ", thus lost!");
                            fightEnded = true;
                        }
                    } else {
                        fightEnded = true;
                        playerWon = true;
                    }
                } else {
                    //log("Player is out of spells, thus lost!");
                    fightEnded = true;
                }
            } else {
                hero.applyEffects();
                boss.applyEffects();
                if (boss.getHealthPoint() > 0) {
                    boss.performRound(hero, HIT_IT_VERY_HARD);
                    //log(String.format("- Boss attacks for %s damage.", boss.getDamage()));
                    if (hero.getHealthPoint() <= 0) {
                        //log("Player has no health left, thus lost!");
                        fightEnded = true;
                    }
                } else {
                    //log("Boss has no health left, thus player wins!");
                    playerWon = true;
                    fightEnded = true;
                }
            }
            playerTurn = !playerTurn;
        }
        return playerWon ? cost : 0;
    }

    private int[] getSpellsToCast(final int[] spells, final boolean returnNullOnFinished) {
        boolean needNew = increment(spells);
        if (needNew) {
            System.out.println(spells.length);
        }
       /* while (!needNew && !checkValidity(spells)) {
            needNew = increment(spells);
        }*/
        return returnNullOnFinished && needNew
            ? null
            : needNew ? new int[spells.length + 1] : spells;
    }

    private boolean checkValidity(final int[] spells) {
        boolean valid = true;
        for (int i = 0; i < spells.length; i++) {
            final int currentSpell = spells[i];
            if (currentSpell == 0) {
                for (int j = i + 1; j < Integer.min(i + 4, spells.length); j++) {
                    if (spells[j] == currentSpell) {
                        valid = false;
                        break;
                    }
                }
            } else if (currentSpell == 1 || currentSpell == 2) {
                for (int j = i + 1; j < Integer.min(i + 5, spells.length); j++) {
                    if (spells[j] == currentSpell) {
                        valid = false;
                        break;
                    }
                }
            }
            if (!valid) {
                break;
            }
        }
        return valid;
    }

    private boolean increment(final int[] spells) {
        int r = 1;
        for (int i = spells.length - 1; i >= 0; i--) {
            spells[i] += r;
            if (spells[i] == 5) {
                spells[i] = 0;
            } else {
                r = 0;
                break;
            }
        }
        return r == 1;
    }
}