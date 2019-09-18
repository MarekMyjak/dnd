package dnd;

interface CharacterInformation {

    HitPoints getHitPoints();

    boolean isHit(int roll);

    int getExperiencePoints();

    void increaseExperience(int i);

    int getLevel();

    int getArmorClass();

    int getAttackRollModifier();

    boolean isDead();
}
