package dnd.character_information;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

class AttackRollModifierTest {

    @Test
    void defaultAttackRollTest() {
//        given
        Character character = DefaultCharacter.builder()
                .build();
//        then
        assertThat(character.getAttackRollModifier()).isEqualTo(0);
    }

    @Test
    void attackRollWithStrengthModifiersTest() {
//        given
        Character character = DefaultCharacter.builder()
                .abilityScore(AbilityScore.builder()
                        .strength(14)
                        .build())
                .build();
//        then
        assertThat(character.getAttackRollModifier()).isEqualTo(2);
    }

    @Test
    void attackRollOnSecondLevelTest() {
//        given
        ExperiencePoints experiencePoints = Mockito.mock(ExperiencePoints.class);
        Mockito.when(experiencePoints.getLevel()).thenReturn(2);
        Character character = DefaultCharacter.builder()
                .experiencePoints(experiencePoints)
                .build();
//        then
        assertThat(character.getAttackRollModifier()).isEqualTo(1);
    }

    @Test
    void attackRollOn17LevelWithStrengthModifierTest() {
//        given
        ExperiencePoints experiencePoints = Mockito.mock(ExperiencePoints.class);
        Mockito.when(experiencePoints.getLevel()).thenReturn(17);
        Character character = DefaultCharacter.builder()
                .experiencePoints(experiencePoints)
                .abilityScore(AbilityScore.builder()
                        .strength(16)
                        .build())
                .build();
//        then
        assertThat(character.getAttackRollModifier()).isEqualTo(11);
    }
}
