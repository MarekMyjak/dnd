package dnd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LevelingTest {

    @Test
    void defaultLevelTest() {
        assertThat(PlayableCharacter.builder().build().getLevel()).isEqualTo(1);
    }

    @Test
    void levelingOfDefaultCharacterTest() {
//        given
        Character character = PlayableCharacter.builder().build();
//        when
        character.increaseExperience(1000);
//        then
        assertThat(character.getLevel()).isEqualTo(2);
        assertThat(character.getHitPoints().getActual()).isEqualTo(12);
        assertThat(character.getAttackRollModifier()).isEqualTo(1);
    }

    @Test
    void levelingOfDefaultCharacterTwoLevelsTest() {
//        given
        Character character = PlayableCharacter.builder().build();
//        when
        character.increaseExperience(2000);
//        then
        assertThat(character.getLevel()).isEqualTo(3);
        assertThat(character.getHitPoints().getActual()).isEqualTo(18);
        assertThat(character.getAttackRollModifier()).isEqualTo(1);
    }


    @Test
    void multipleLevelingOfDefaultCharacterTest() {
//        given
        Character character = PlayableCharacter.builder().build();
//        when
        character.increaseExperience(15000);
//        then
        assertThat(character.getLevel()).isEqualTo(16);
        assertThat(character.getHitPoints().getActual()).isEqualTo(96);
        assertThat(character.getAttackRollModifier()).isEqualTo(8);
    }

    @Test
    void levelingWithConstitutionTest() {
//        given
        Character character = PlayableCharacter.builder()
                .abilityScore(AbilityScore.builder()
                        .constitution(16)
                        .build())
                .build();
        assertThat(character.getHitPoints().getMaximum()).isEqualTo(8);
//        when
        character.increaseExperience(1000);
//        then
        assertThat(character.getLevel()).isEqualTo(2);
        assertThat(character.getHitPoints().getMaximum()).isEqualTo(16);
        assertThat(character.getAttackRollModifier()).isEqualTo(1);
    }

    @Test
    void levelingWithLowConstitutionTest() {
//        given
        Character character = PlayableCharacter.builder()
                .abilityScore(AbilityScore.builder()
                        .constitution(1)
                        .build())
                .build();
//        when
        character.increaseExperience(1000);
//        then
        assertThat(character.getLevel()).isEqualTo(2);
        assertThat(character.getHitPoints().getActual()).isEqualTo(12);
        assertThat(character.getAttackRollModifier()).isEqualTo(1);
    }

    @Test
    void levelingWithStrengthTest() {
//        given
        Character character = PlayableCharacter.builder()
                .abilityScore(AbilityScore.builder()
                        .strength(16)
                        .build())
                .build();
//        when
        character.increaseExperience(1000);
//        then
        assertThat(character.getLevel()).isEqualTo(2);
        assertThat(character.getHitPoints().getActual()).isEqualTo(12);
        assertThat(character.getAttackRollModifier()).isEqualTo(4);
    }
}
