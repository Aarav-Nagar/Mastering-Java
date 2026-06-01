public interface HasMana {
    int getMana();
    int getMaxMana();
    void spendMana(int amount);
    void restoreMana(int amount);
}

