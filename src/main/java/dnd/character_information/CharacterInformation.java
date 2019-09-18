package dnd.character_information;

public interface CharacterInformation {

    HitPoints getHitPoints();

    boolean isHit(int roll);

    int getExperiencePoints();

    void increaseExperience(int i);

    int getLevel();

    int getArmorClass();

    int getAttackRollModifier();

    boolean isDead();
}