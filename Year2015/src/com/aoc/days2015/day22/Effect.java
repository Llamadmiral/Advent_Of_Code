package com.aoc.days2015.day22;

import java.util.HashMap;
import java.util.Map;

import static com.aoc.days2015.day22.SpellConstants.POISON;
import static com.aoc.days2015.day22.SpellConstants.RECHARGE;
import static com.aoc.days2015.day22.SpellConstants.SHIELD;

class Effect {
    static final Map<String, Effect> EFFECTS = new HashMap<>();

    static {
        EFFECTS.put(SHIELD, new Effect(SHIELD, 6));
        EFFECTS.put(POISON, new Effect(POISON, 6));
        EFFECTS.put(RECHARGE, new Effect(RECHARGE, 5));
    }

    private final int originalTimer;


    private String name;
    private int timer;

    private Effect(final String name, final int timer) {
        this.name = name;
        this.originalTimer = timer;
        this.timer = timer;
    }

    void apply(final Contestant target) {
        switch (this.name) {
            case SHIELD:
                target.setArmour(7);
                break;
            case POISON:
                target.damage(3);
                break;
            case RECHARGE:
                target.giveMana(101);
                break;
        }
    }

    int getTimer() {
        return this.timer;
    }

    String getName() {
        return this.name;
    }

    void resetTimer() {
        this.timer = this.originalTimer;
    }

    void decreaseTimer() {
        this.timer--;
    }
}
