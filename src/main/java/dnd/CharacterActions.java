package dnd;

import dnd.character_information.CharacterInformation;

public interface CharacterActions {
    AttackType attack(CharacterInformation enemy, int roll);

    void takeDamage(int amount);

    int getAttackRollModifier();

    int getDamageModifier();

    void increaseExperience(int amount);
}
