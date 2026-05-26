package game;

public final class Tank extends Character {
    private final int baseDamage;
    private final double damageReduction;

    public Tank(String name, int maxHp, int baseDamage, double damageReduction) {
        super(name, maxHp);
        if (baseDamage <= 0) {
            throw new IllegalArgumentException("baseDamage must be positive");
        }
        if (damageReduction < 0.0 || damageReduction >= 1.0) {
            throw new IllegalArgumentException("damageReduction must be in [0, 1)");
        }
        this.baseDamage = baseDamage;
        this.damageReduction = damageReduction;
    }

    @Override
    public void takeDamage(int rawDamage) {
        int reduced = (int) Math.floor(Math.max(0, rawDamage) * (1.0 - damageReduction));
        super.takeDamage(reduced);
    }

    @Override
    public void attack(Character target) {
        int damage = rollDamage(baseDamage, 1);
        target.takeDamage(damage);
        System.out.println(name + " slams for " + damage + " damage.");
    }
}

