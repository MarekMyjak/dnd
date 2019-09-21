package dnd.character_information;

public interface HitPoints {
    int getActual();

    int getMaximum();

    void change(int i);

    void increaseHitPointsPerLevel(AbilityScore abilityScore);

    boolean isDead();
}
