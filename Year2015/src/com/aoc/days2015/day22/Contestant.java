package com.aoc.days2015.day22;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Contestant {

    private final int originalHealthpoint;
    private String name;
    private int healthPoint;
    private int armour;
    private int damage;
    private int mana;
    private List<Effect> effects = new ArrayList<>();
    private int originalMana;

    Contestant(final String name, final int healthPoint, final int armour, final int damage, final int mana) {
        this.name = name;
        this.originalHealthpoint = healthPoint;
        this.healthPoint = healthPoint;
        this.armour = armour;
        this.damage = damage;
        this.originalMana = mana;
        this.mana = mana;
    }

    boolean performRound(final Contestant enemy, final Spell spell) {
        return spell.cast(this, enemy);
    }

    void damage(final int amount) {
        final int initialDamage = amount - this.armour;
        final int actualDamage = (initialDamage > 0 ? initialDamage : 1);
        this.healthPoint -= actualDamage;
        //System.out.println(enemy.getName() + " deals " + enemy.getDamage() + "-" + this.armour + " = " + actualDamage + " damage; " + this.name + " goes down to " + this.healthPoint + " hit points.");
    }

    void giveMana(final int amount) {
        this.mana += amount;
    }

    boolean addEffect(final Effect effect) {
        boolean added = false;
        if (!this.effects.contains(effect)) {
            this.effects.add(effect);
            added = true;
        }
        return added;
    }

    int getDamage() {
        return this.damage;
    }

    void heal(final int amount) {
        this.healthPoint += amount;
    }

    void applyEffects() {
        for (final Iterator<Effect> iterator = this.effects.iterator(); iterator.hasNext(); ) {
            final Effect effect = iterator.next();
            effect.decreaseTimer();
            effect.apply(this);
            //SolutionTwentyTwo.log("---" + effect.getName() + " is applied! Its timer is " + effect.getTimer());
            if (effect.getTimer() == 0) {
                iterator.remove();
                effect.resetTimer();
                //SolutionTwentyTwo.log("---" + effect.getName() + " wears off!");
            }
        }
    }

    int getHealthPoint() {
        return this.healthPoint;
    }

    int getArmour() {
        return this.armour;
    }

    void setArmour(final int amount) {
        this.armour = amount;
    }

    int getMana() {
        return mana;
    }

    void reset() {
        this.healthPoint = this.originalHealthpoint;
        this.mana = this.originalMana;
        this.armour = 0;
        this.effects.clear();
    }
}
