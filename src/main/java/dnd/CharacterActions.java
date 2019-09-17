package dnd;

interface CharacterActions {
    AttackType attack(CharacterInformation character, int roll);

    void takeDamage(int amount);

    int getAttackRollModifier();
    int getDamageModifier();
}
