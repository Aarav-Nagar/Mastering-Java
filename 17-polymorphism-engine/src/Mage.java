public final class Mage extends Unit implements HasMana {
    private final int maxMana;
    private int mana;

    public Mage(String name) {
        super(name, 22);
        this.maxMana = 12;
        this.mana = maxMana;
    }

    @Override
    public void takeTurn(BattleView view, Unit target, BattleLog log) {
        if (!target.isAlive()) {
            return;
        }

        // Demonstrates polymorphism: engine calls takeTurn(Unit) and runtime dispatch picks this.
        // Demonstrates safe casting: resource logic lives behind HasMana.
        if (mana >= 5) {
            spendMana(5);
            int dmg = 14;
            target.damage(dmg);
            log.line(getName() + " casts Arc Bolt on " + target.getName() + " for " + dmg + ".");
        } else {
            int dmg = 5;
            target.damage(dmg);
            restoreMana(2);
            log.line(getName() + " uses a wand on " + target.getName() + " for " + dmg + " (mana +2).");
        }

        if (!target.isAlive()) {
            log.line(target.getName() + " falls.");
        }
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public int getMaxMana() {
        return maxMana;
    }

    @Override
    public void spendMana(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be >= 0");
        }
        mana = Math.max(0, mana - amount);
    }

    @Override
    public void restoreMana(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be >= 0");
        }
        mana = Math.min(maxMana, mana + amount);
    }
}

