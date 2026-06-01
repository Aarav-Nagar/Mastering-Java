import java.util.ArrayList;
import java.util.List;

public final class BattleEngine {
    private final List<Unit> party;
    private final List<Unit> enemies;
    private final BattleLog log;

    public BattleEngine(List<Unit> party, List<Unit> enemies, BattleLog log) {
        this.party = new ArrayList<>(party);
        this.enemies = new ArrayList<>(enemies);
        this.log = log;
    }

    public void run(int maxRounds) {
        log.header("Battle start");

        for (int round = 1; round <= maxRounds; round++) {
            if (aliveCount(party) == 0 || aliveCount(enemies) == 0) {
                break;
            }

            log.header("Round " + round);
            takeSideTurns(party, enemies);
            takeSideTurns(enemies, party);

            log.blank();
        }

        if (aliveCount(party) == 0 && aliveCount(enemies) == 0) {
            log.line("Result: draw.");
        } else if (aliveCount(party) == 0) {
            log.line("Result: enemies win.");
        } else if (aliveCount(enemies) == 0) {
            log.line("Result: party wins.");
        } else {
            log.line("Result: time limit reached.");
        }
    }

    private void takeSideTurns(List<Unit> actingSide, List<Unit> opposingSide) {
        for (Unit unit : actingSide) {
            if (!unit.isAlive()) {
                continue;
            }

            Unit target = pickFirstAlive(opposingSide);
            if (target == null) {
                return;
            }

            unit.takeTurn(new BattleView(actingSide, opposingSide), target, log);
        }
    }

    private static int aliveCount(List<Unit> units) {
        int count = 0;
        for (Unit unit : units) {
            if (unit.isAlive()) {
                count++;
            }
        }
        return count;
    }

    private static Unit pickFirstAlive(List<Unit> units) {
        for (Unit unit : units) {
            if (unit.isAlive()) {
                return unit;
            }
        }
        return null;
    }
}

