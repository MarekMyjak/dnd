package dnd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CharacterHitPointsTest {

    @Test
    void defaultHitPointsTest() {
//        given
        int expectedDefaultHitPoints = 6;
        Character character = PlayableCharacter.builder().build();
//        then
        assertThat(character.getHitPoints().getActual()).isEqualTo(expectedDefaultHitPoints);
    }

    @Test
    void hitPointsWithConstitutionModifierTest() {
//        given
        int expectedHitPoints = 7;
        Character character = PlayableCharacter.builder()
                .abilityScore(AbilityScore.builder()
                        .constitution(14)
                        .build())
                .build();
//        then
        assertThat(character.getHitPoints().getActual()).isEqualTo(expectedHitPoints);
    }

    @Test
    void minimalHitPointsTest() {
//        given
        int expectedHitPoints = 6;
        Character character = PlayableCharacter.builder()
                .abilityScore(AbilityScore.builder()
                        .constitution(1)
                        .build())
                .build();
//        then
        assertThat(character.getHitPoints().getActual()).isEqualTo(expectedHitPoints);
    }
}