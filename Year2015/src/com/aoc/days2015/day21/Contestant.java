package com.aoc.days2015.day21;

class Contestant {
    private final int originalHealthpoint;
    private final int originalArmour;
    private final int originalDamage;
    private String name;
    private int healthPoint;
    private int armour;
    private int damage;


    Contestant(final String name, final int healthPoint, final int armour, final int damage) {
        this.name = name;
        this.originalHealthpoint = healthPoint;
        this.healthPoint = healthPoint;
        this.originalArmour = armour;
        this.armour = armour;
        this.originalDamage = damage;
        this.damage = damage;
    }

    private int getDamage() {
        return damage;
    }

    int getHealthPoint() {
        return healthPoint;
    }

    void attackedBy(final Contestant enemy) {
        final int initialDamage = enemy.getDamage() - this.armour;
        final int actualDamage = (initialDamage > 0 ? initialDamage : 1);
        this.healthPoint -= actualDamage;
        //System.out.println(enemy.getName() + " deals " + enemy.getDamage() + "-" + this.armour + " = " + actualDamage + " damage; " + this.name + " goes down to " + this.healthPoint + " hit points.");
    }

    void reset() {
        this.healthPoint = this.originalHealthpoint;
        this.armour = this.originalArmour;
        this.damage = this.originalDamage;
    }

    void applyItem(final Item item) {
        this.armour += item.getArmour();
        this.damage += item.getDamage();
    }

    @Override
    public String toString() {
        return "Contestant{" +
            "name='" + name + '\'' +
            ", healthPoint=" + healthPoint +
            '}';
    }
}
