package dnd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CharacterHitPointsTest {

    @Test
    void defaultHitPointsTest() {
//        given
        int expectedDefaultHitPoints = 6;
        Character playableCharacter = PlayableCharacter.builder().build();
//        then
        assertThat(playableCharacter.getHitPoints().getActual()).isEqualTo(expectedDefaultHitPoints);
    }

    @Test
    void hitPointsWithConstitutionModifierTest() {
//        given
        int expectedHitPoints = 7;
        Character playableCharacter = PlayableCharacter.builder()
                .abilityScore(AbilityScore.builder()
                        .constitution(14)
                        .build())
                .build();
//        then
        assertThat(playableCharacter.getHitPoints().getActual()).isEqualTo(expectedHitPoints);
    }

    @Test
    void minimalHitPointsTest() {
//        given
        int expectedHitPoints = 6;
        Character playableCharacter = PlayableCharacter.builder()
                .abilityScore(AbilityScore.builder()
                        .constitution(1)
                        .build())
                .build();
//        then
        assertThat(playableCharacter.getHitPoints().getActual()).isEqualTo(expectedHitPoints);
    }
}