package dnd;

interface CharacterInformation extends Named {

    CharacterCondition getCharacterCondition();

    HitPoints getHitPoints();

    boolean isHit(int roll);

    int getExperiencePoints();

    void increaseExperience(int i);

    int getLevel();

    int getArmorClass();
}
