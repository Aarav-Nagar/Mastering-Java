public final class Warrior extends Unit implements HasRage {
    private final int maxRage;
    private int rage;

    public Warrior(String name) {
        super(name, 34);
        this.maxRage = 10;
        this.rage = 0;
    }

    @Override
    public void takeTurn(BattleView view, Unit target, BattleLog log) {
        if (!target.isAlive()) {
            return;
        }

        // Rage builds on normal hits, then powers a stronger swing.
        if (rage >= 6) {
            spendRage(6);
            int dmg = 12;
            target.damage(dmg);
            log.line(getName() + " cleaves " + target.getName() + " for " + dmg + ".");
        } else {
            int dmg = 7;
            target.damage(dmg);
            gainRage(2);
            log.line(getName() + " strikes " + target.getName() + " for " + dmg + ".");
        }

        if (!target.isAlive()) {
            log.line(target.getName() + " falls.");
        }
    }

    @Override
    public int getRage() {
        return rage;
    }

    @Override
    public int getMaxRage() {
        return maxRage;
    }

    @Override
    public void gainRage(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be >= 0");
        }
        rage = Math.min(maxRage, rage + amount);
    }

    @Override
    public void spendRage(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be >= 0");
        }
        rage = Math.max(0, rage - amount);
    }
}

