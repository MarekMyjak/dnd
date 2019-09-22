package dnd.character_information;

interface Character {

    HitPoints getHitPoints();

    void increaseExperience(int amount);

    int getLevel();

    int getArmorClass();

    int getAttackRollModifier();
}
