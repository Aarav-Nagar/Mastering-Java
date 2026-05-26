package game;

public final class Main {
    public static void main(String[] args) {
        Character fighter = new Fighter("Rhea", 42, 7);
        Character mage = new Mage("Ivo", 30, 12, 0.25);
        Character tank = new Tank("Mara", 55, 5, 0.35);

        Battle first = new Battle(fighter, mage);
        first.run();

        System.out.println();

        Battle second = new Battle(tank, fighter);
        second.run();
    }
}

