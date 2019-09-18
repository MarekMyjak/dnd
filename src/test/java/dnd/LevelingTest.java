package dnd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LevelingTest {

    @Test
    void defaultLevelTest() {
        assertThat(DefaultCharacterInformation.builder().build().getLevel()).isEqualTo(1);
    }

    @Test
    void levelingOfDefaultCharacterTest() {
//        given
        CharacterInformation character = DefaultCharacterInformation.builder().build();
//        when
        character.increaseExperience(1000);
//        then
        assertThat(character.getLevel()).isEqualTo(2);
        assertThat(character.getHitPoints().getActual()).isEqualTo(12);
    }

    @Test
    void levelingOfDefaultCharacterTwoLevelsTest() {
//        given
        CharacterInformation character = DefaultCharacterInformation.builder().build();
//        when
        character.increaseExperience(2000);
//        then
        assertThat(character.getLevel()).isEqualTo(3);
        assertThat(character.getHitPoints().getActual()).isEqualTo(18);
    }


    @Test
    void multipleLevelingOfDefaultCharacterTest() {
//        given
        CharacterInformation character = DefaultCharacterInformation.builder().build();
//        when
        character.increaseExperience(15000);
//        then
        assertThat(character.getLevel()).isEqualTo(16);
        assertThat(character.getHitPoints().getActual()).isEqualTo(96);
    }

    @Test
    void levelingWithConstitutionTest() {
//        given
        CharacterInformation character = DefaultCharacterInformation.builder()
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
    }

    @Test
    void levelingWithLowConstitutionTest() {
//        given
        CharacterInformation character = DefaultCharacterInformation.builder()
                .abilityScore(AbilityScore.builder()
                        .constitution(1)
                        .build())
                .build();
//        when
        character.increaseExperience(1000);
//        then
        assertThat(character.getLevel()).isEqualTo(2);
        assertThat(character.getHitPoints().getActual()).isEqualTo(12);
    }

    @Test
    void levelingWithStrengthTest() {
//        given
        CharacterInformation character = DefaultCharacterInformation.builder()
                .abilityScore(AbilityScore.builder()
                        .strength(16)
                        .build())
                .build();
//        when
        character.increaseExperience(1000);
//        then
        assertThat(character.getLevel()).isEqualTo(2);
        assertThat(character.getHitPoints().getActual()).isEqualTo(12);
    }
}
