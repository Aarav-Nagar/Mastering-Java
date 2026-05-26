package game;

public final class Mage extends Character {
    private final int baseSpellDamage;
    private final double critChance;

    public Mage(String name, int maxHp, int baseSpellDamage, double critChance) {
        super(name, maxHp);
        if (baseSpellDamage <= 0) {
            throw new IllegalArgumentException("baseSpellDamage must be positive");
        }
        if (critChance < 0.0 || critChance > 1.0) {
            throw new IllegalArgumentException("critChance must be between 0 and 1");
        }
        this.baseSpellDamage = baseSpellDamage;
        this.critChance = critChance;
    }

    @Override
    public void attack(Character target) {
        int damage = rollDamage(baseSpellDamage, 3);
        boolean crit = Math.random() < critChance;
        if (crit) {
            damage *= 2;
        }
        target.takeDamage(damage);
        System.out.println(name + " casts a spell for " + damage + " damage" + (crit ? " (CRIT)" : "") + ".");
    }
}

