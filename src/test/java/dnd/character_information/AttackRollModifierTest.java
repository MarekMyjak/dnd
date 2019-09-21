package dnd.character_information;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AttackRollModifierTest {

    @Test
    void defaultAttackRollTest() {
//        given
        CharacterInformation characterInformation = DefaultCharacter.builder()
                .build();
//        then
        assertThat(characterInformation.getAttackRollModifier()).isEqualTo(0);
    }

    @Test
    void attackRollWithStrengthModifiersTest() {
//        given
        CharacterInformation characterInformation = DefaultCharacter.builder()
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
        CharacterInformation characterInformation = DefaultCharacter.builder()
                .experiencePoints(1000)
                .build();
//        then
        assertThat(characterInformation.getAttackRollModifier()).isEqualTo(1);
    }

    @Test
    void attackRollOnHighLevelWithStrengthModifierTest() {
//        given
        CharacterInformation characterInformation = DefaultCharacter.builder()
                .experiencePoints(16000)
                .abilityScore(AbilityScore.builder()
                        .strength(16)
                        .build())
                .build();
//        then
        assertThat(characterInformation.getAttackRollModifier()).isEqualTo(11);
    }
}
