import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BattleView {
    private final List<Unit> allies;
    private final List<Unit> enemies;

    public BattleView(List<Unit> allies, List<Unit> enemies) {
        this.allies = Collections.unmodifiableList(new ArrayList<>(allies));
        this.enemies = Collections.unmodifiableList(new ArrayList<>(enemies));
    }

    public List<Unit> getAllies() {
        return allies;
    }

    public List<Unit> getEnemies() {
        return enemies;
    }
}

