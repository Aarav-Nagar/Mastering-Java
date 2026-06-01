public final class ConsoleBattleLog implements BattleLog {
    @Override
    public void header(String text) {
        System.out.println("== " + text + " ==");
    }

    @Override
    public void line(String text) {
        System.out.println(text);
    }

    @Override
    public void blank() {
        System.out.println();
    }
}

