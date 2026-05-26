package game;

public final class Battle {
    private final Character a;
    private final Character b;

    public Battle(Character a, Character b) {
        this.a = a;
        this.b = b;
    }

    public void run() {
        System.out.println("Battle: " + a.getDisplayName() + " vs " + b.getDisplayName());
        System.out.println(a.statusLine());
        System.out.println(b.statusLine());

        int round = 1;
        Character attacker = a;
        Character defender = b;

        while (attacker.isAlive() && defender.isAlive() && round <= 25) {
            System.out.println();
            System.out.println("Round " + round);
            attacker.attack(defender);
            System.out.println(defender.statusLine());

            Character tmp = attacker;
            attacker = defender;
            defender = tmp;
            round++;
        }

        System.out.println();
        if (a.isAlive() && !b.isAlive()) {
            System.out.println("Winner: " + a.getDisplayName());
        } else if (!a.isAlive() && b.isAlive()) {
            System.out.println("Winner: " + b.getDisplayName());
        } else {
            System.out.println("Result: draw");
        }
    }
}

