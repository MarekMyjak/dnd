package dnd.character_information;

public interface HitPoints {
    int getActual();

    int getMaximum();

    void takeDamage(int amount);

    boolean isDead();
}
