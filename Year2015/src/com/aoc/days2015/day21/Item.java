package com.aoc.days2015.day21;

class Item {
    private String name;
    private int cost;
    private int damage;
    private int armour;

    Item(final String name, final int cost, final int damage, final int armour) {
        this.name = name;
        this.cost = cost;
        this.damage = damage;
        this.armour = armour;
    }

    int getArmour() {
        return this.armour;
    }

    int getDamage() {
        return this.damage;
    }

    int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return this.name + ", Cost: " + this.cost;// + ", Damage: " + this.damage + ", Armour: " + this.armour;
    }
}
