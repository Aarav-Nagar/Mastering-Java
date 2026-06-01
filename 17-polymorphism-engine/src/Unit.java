public abstract class Unit {
    private final String name;
    private final int maxHp;
    private int hp;

    protected Unit(String name, int maxHp) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name must be non-blank");
        }
        if (maxHp <= 0) {
            throw new IllegalArgumentException("maxHp must be positive");
        }
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
    }

    public final String getName() {
        return name;
    }

    public final int getHp() {
        return hp;
    }

    public final int getMaxHp() {
        return maxHp;
    }

    public final boolean isAlive() {
        return hp > 0;
    }

    public final void damage(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be >= 0");
        }
        hp = Math.max(0, hp - amount);
    }

    public final void heal(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be >= 0");
        }
        hp = Math.min(maxHp, hp + amount);
    }

    public abstract void takeTurn(BattleView view, Unit target, BattleLog log);

    public final String statusLine() {
        String resource = "";

        if (this instanceof HasMana) {
            HasMana manaUser = (HasMana) this;
            resource = " | mana " + manaUser.getMana() + "/" + manaUser.getMaxMana();
        } else if (this instanceof HasRage) {
            HasRage rageUser = (HasRage) this;
            resource = " | rage " + rageUser.getRage() + "/" + rageUser.getMaxRage();
        }

        return name + " hp " + hp + "/" + maxHp + resource;
    }
}
