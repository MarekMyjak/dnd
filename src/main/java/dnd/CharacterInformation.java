package dnd;

interface CharacterInformation {

    CharacterCondition getCharacterCondition();

    HitPoints getHitPoints();

    boolean isHit(int roll);

    int getExperiencePoints();

    void increaseExperience(int i);

    int getLevel();

    int getArmorClass();

    int getAttackRollModifier();
}
