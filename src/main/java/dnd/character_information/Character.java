package dnd.character_information;

interface Character {

    HitPoints getHitPoints();

    void increaseExperience(int i);

    int getLevel();

    int getArmorClass();

    int getAttackRollModifier();
}
