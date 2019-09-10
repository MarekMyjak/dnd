package dnd;

interface CharacterInformation extends Named {

    CharacterCondition getCharacterCondition();

    boolean isHit(int roll);
}
