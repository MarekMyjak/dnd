package dnd.character_information;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
        ExperiencePoints experiencePoints = Mockito.mock(ExperiencePoints.class);
        Mockito.when(experiencePoints.getLevel()).thenReturn(2);
        CharacterInformation characterInformation = DefaultCharacter.builder()
                .experiencePoints(experiencePoints)
                .build();
//        then
        assertThat(characterInformation.getAttackRollModifier()).isEqualTo(1);
    }

    @Test
    void attackRollOn17LevelWithStrengthModifierTest() {
//        given
        ExperiencePoints experiencePoints = Mockito.mock(ExperiencePoints.class);
        Mockito.when(experiencePoints.getLevel()).thenReturn(17);
        CharacterInformation characterInformation = DefaultCharacter.builder()
                .experiencePoints(experiencePoints)
                .abilityScore(AbilityScore.builder()
                        .strength(16)
                        .build())
                .build();
//        then
        assertThat(characterInformation.getAttackRollModifier()).isEqualTo(11);
    }
}
