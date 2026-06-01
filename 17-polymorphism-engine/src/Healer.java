public final class Healer extends Unit implements HasMana {
    private final int maxMana;
    private int mana;

    public Healer(String name) {
        super(name, 26);
        this.maxMana = 10;
        this.mana = maxMana;
    }

    @Override
    public void takeTurn(BattleView view, Unit target, BattleLog log) {
        Unit allyToHeal = pickMostInjured(view);
        if (allyToHeal != null && mana >= 4 && allyToHeal.getHp() < allyToHeal.getMaxHp()) {
            spendMana(4);
            int amount = 9;
            allyToHeal.heal(amount);
            log.line(getName() + " heals " + allyToHeal.getName() + " for " + amount + ".");
            return;
        }

        if (!target.isAlive()) {
            return;
        }

        int dmg = 4;
        target.damage(dmg);
        restoreMana(1);
        log.line(getName() + " bonks " + target.getName() + " for " + dmg + " (mana +1).");

        if (!target.isAlive()) {
            log.line(target.getName() + " falls.");
        }
    }

    private Unit pickMostInjured(BattleView view) {
        Unit best = null;
        int mostMissing = 0;
        for (Unit ally : view.getAllies()) {
            if (!ally.isAlive()) {
                continue;
            }
            int missing = ally.getMaxHp() - ally.getHp();
            if (missing > mostMissing) {
                mostMissing = missing;
                best = ally;
            }
        }
        return best;
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

