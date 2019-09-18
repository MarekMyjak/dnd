package dnd.character_information;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AttackRollModifierTest {

    @Test
    void defaultAttackRollTest() {
//        given
        CharacterInformation characterInformation = DefaultCharacterInformation.builder()
                .build();
//        then
        assertThat(characterInformation.getAttackRollModifier()).isEqualTo(0);
    }

    @Test
    void attackRollWithStrengthModifiersTest() {
//        given
        CharacterInformation characterInformation = DefaultCharacterInformation.builder()
                .abilityScore(AbilityScore.builder()
                        .strength(14)
                        .build())
                .build();
//        then
        assertThat(characterInformation.getAttackRollModifier()).isEqualTo(2);
    }

    @Test
    void attackRollOnSecondLevelTest() {
//        given
        CharacterInformation characterInformation = DefaultCharacterInformation.builder()
                .level(2)
                .build();
//        then
        assertThat(characterInformation.getAttackRollModifier()).isEqualTo(1);
    }

    @Test
    void attackRollOnHighLevelWithStrengthModifierTest() {
//        given
        CharacterInformation characterInformation = DefaultCharacterInformation.builder()
                .level(17)
                .abilityScore(AbilityScore.builder()
                        .strength(16)
                        .build())
                .build();
//        then
        assertThat(characterInformation.getAttackRollModifier()).isEqualTo(11);
    }
}
