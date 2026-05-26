package game;

public abstract class Character {
    protected final String name;
    private final int maxHp;
    private int hp;

    protected Character(String name, int maxHp) {
        this.name = requireNonBlank(name, "name");
        if (maxHp <= 0) {
            throw new IllegalArgumentException("maxHp must be positive");
        }
        this.maxHp = maxHp;
        this.hp = maxHp;
    }

    public final boolean isAlive() {
        return hp > 0;
    }

    public final String getDisplayName() {
        return name + " (" + getClass().getSimpleName() + ")";
    }

    public final String statusLine() {
        return getDisplayName() + " — HP " + hp + "/" + maxHp;
    }

    public void takeDamage(int rawDamage) {
        int damage = Math.max(0, rawDamage);
        hp = Math.max(0, hp - damage);
    }

    public abstract void attack(Character target);

    protected final int rollDamage(int baseDamage, int variance) {
        int spread = Math.max(0, variance);
        int delta = (int) (Math.random() * (spread * 2 + 1)) - spread;
        return Math.max(0, baseDamage + delta);
    }

    private static String requireNonBlank(String value, String name) {
        if (value == null) {
            throw new IllegalArgumentException(name + " must not be null");
        }
        String trimmed = value.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException(name + " must not be blank");
        }
        return trimmed;
    }
}
