package game;

public final class Fighter extends Character {
    private final int baseDamage;

    public Fighter(String name, int maxHp, int baseDamage) {
        super(name, maxHp);
        if (baseDamage <= 0) {
            throw new IllegalArgumentException("baseDamage must be positive");
        }
        this.baseDamage = baseDamage;
    }

    @Override
    public void attack(Character target) {
        int damage = rollDamage(baseDamage, 2);
        target.takeDamage(damage);
        System.out.println(name + " strikes for " + damage + " damage.");
    }
}

