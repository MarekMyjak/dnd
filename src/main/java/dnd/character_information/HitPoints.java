package dnd.character_information;

public interface HitPoints {
    int getActual();

    int getMaximum(int level);

    void takeDamage(int amount);

    void increaseHitPointsPerLevel();

    boolean isDead();
}
