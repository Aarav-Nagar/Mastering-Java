public final class Slime extends Unit {
    public Slime(String name) {
        super(name, 18);
    }

    @Override
    public void takeTurn(BattleView view, Unit target, BattleLog log) {
        if (!target.isAlive()) {
            return;
        }

        int dmg = 3;
        target.damage(dmg);
        log.line(getName() + " splats " + target.getName() + " for " + dmg + ".");

        // Small chance to split by self-healing a bit (simple behavior difference by type).
        if (getHp() <= 8) {
            heal(2);
            log.line(getName() + " quivers and reforms (+2 hp).");
        }

        if (!target.isAlive()) {
            log.line(target.getName() + " falls.");
        }
    }
}
