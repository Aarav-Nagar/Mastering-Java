import java.util.ArrayList;
import java.util.List;

public class PolymorphismEngineApp {
    public static void main(String[] args) {
        List<Unit> party = new ArrayList<>();
        party.add(new Warrior("Rook"));
        party.add(new Mage("Sable"));
        party.add(new Healer("Iris"));

        List<Unit> monsters = new ArrayList<>();
        monsters.add(new Slime("Gloop"));
        monsters.add(new Slime("Blorp"));

        BattleEngine engine = new BattleEngine(party, monsters, new ConsoleBattleLog());
        engine.run(12);
    }
}

