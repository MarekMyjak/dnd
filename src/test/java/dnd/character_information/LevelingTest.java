package dnd.character_information;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LevelingTest {

    @Test
    void defaultLevelTest() {
        assertThat(DefaultCharacter.builder().build().getLevel()).isEqualTo(1);
    }

    @Test
    void levelingOfDefaultCharacterTest() {
//        given
        Character character = DefaultCharacter.builder().build();
//        when
        character.increaseExperience(1000);
//        then
        assertThat(character.getLevel()).isEqualTo(2);
        assertThat(character.getHitPoints().getMaximum()).isEqualTo(12);
    }

    @Test
    void levelingOfDefaultCharacterTwoLevelsTest() {
//        given
        Character character = DefaultCharacter.builder().build();
//        when
        character.increaseExperience(2000);
//        then
        assertThat(character.getLevel()).isEqualTo(3);
        assertThat(character.getHitPoints().getMaximum()).isEqualTo(18);
    }


    @Test
    void multipleLevelingOfDefaultCharacterTest() {
//        given
        Character character = DefaultCharacter.builder().build();
//        when
        character.increaseExperience(15000);
//        then
        assertThat(character.getLevel()).isEqualTo(16);
        assertThat(character.getHitPoints().getMaximum()).isEqualTo(96);
    }

    @Test
    void levelingWithConstitutionTest() {
//        given
        Character character = DefaultCharacter.builder()
                .constitution(16)
                .build();
        assertThat(character.getHitPoints().getMaximum()).isEqualTo(8);
//        when
        character.increaseExperience(1000);
//        then
        assertThat(character.getLevel()).isEqualTo(2);
        assertThat(character.getHitPoints().getMaximum()).isEqualTo(16);
    }

    @Test
    void levelingWithLowConstitutionTest() {
//        given
        Character character = DefaultCharacter.builder()
                .constitution(1)
                .build();
//        when
        character.increaseExperience(1000);
//        then
        assertThat(character.getLevel()).isEqualTo(2);
        assertThat(character.getHitPoints().getMaximum()).isEqualTo(12);
    }

    @Test
    void levelingWithStrengthTest() {
//        given
        Character character = DefaultCharacter.builder()
                .abilityScores(AbilityScores.builder()
                        .strength(16)
                        .build())
                .build();
//        when
        character.increaseExperience(1000);
//        then
        assertThat(character.getLevel()).isEqualTo(2);
        assertThat(character.getHitPoints().getMaximum()).isEqualTo(12);
    }
}
