package dnd;

interface CharacterActions {
    AttackResult attack(CharacterInformation character, int roll);

    void takeDamage(int amount);
}
