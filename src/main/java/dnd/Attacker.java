package dnd;

public interface Attacker {
    int getAttackRollModifier();

    int getDamageModifier();

    void increaseExperience(int amount);
}
