package dnd.character_information;

public interface CharacterInformation {

    HitPoints getHitPoints();

    void increaseExperience(int i);

    int getLevel();

    int getArmorClass();

    int getAttackRollModifier();

    boolean isDead();
}
