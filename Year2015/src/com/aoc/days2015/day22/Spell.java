package com.aoc.days2015.day22;

import java.util.HashMap;
import java.util.Map;

import static com.aoc.days2015.day22.SpellConstants.DRAIN;
import static com.aoc.days2015.day22.SpellConstants.MAGIC_MISSILE;
import static com.aoc.days2015.day22.SpellConstants.POISON;
import static com.aoc.days2015.day22.SpellConstants.RECHARGE;
import static com.aoc.days2015.day22.SpellConstants.SHIELD;
import static com.aoc.days2015.day22.SpellConstants.WHAM;

class Spell {


    private static final Map<String, Integer> COSTS = new HashMap<>();

    static {
        COSTS.put(WHAM, 0);
        COSTS.put(MAGIC_MISSILE, 53);
        COSTS.put(DRAIN, 73);
        COSTS.put(SHIELD, 113);
        COSTS.put(POISON, 173);
        COSTS.put(RECHARGE, 229);
    }

    private String name;
    private int cost;

    Spell(final String name) {
        this.name = name;
        this.cost = COSTS.get(name);
    }

    boolean cast(final Contestant caster, final Contestant target) {
        boolean didAnything = false;
        switch (this.name) {
            case WHAM:
                target.damage(caster.getDamage());
                didAnything = true;
                break;
            case MAGIC_MISSILE:
                target.damage(4);
                didAnything = true;
                break;
            case DRAIN:
                target.damage(2);
                caster.heal(2);
                didAnything = true;
                break;
            case SHIELD:
                didAnything = caster.addEffect(Effect.EFFECTS.get(SHIELD));
                break;
            case POISON:
                didAnything = target.addEffect(Effect.EFFECTS.get(POISON));
                break;
            case RECHARGE:
                didAnything = caster.addEffect(Effect.EFFECTS.get(RECHARGE));
                break;
        }
        caster.giveMana(-this.cost);
        return didAnything;
    }

    String getName() {
        return this.name;
    }

    int getCost() {
        return this.cost;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
