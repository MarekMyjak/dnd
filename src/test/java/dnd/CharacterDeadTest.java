package dnd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CharacterDeadTest {

    @Test
    void characterIsDeadOnZeroHitPointsTest() {
//        given
        CharacterInformation characterInformation =
                DefaultCharacterInformation.builder()
                        .hitPoints(new DefaultHitPoints(0, 10))
                        .build();
//        then
        assertThat(characterInformation.isDead()).isEqualTo(true);
    }

    @Test
    void characterIsDeadOnNegativeHitPointsTest() {
//        given
        CharacterInformation characterInformation =
                DefaultCharacterInformation.builder()
                        .hitPoints(new DefaultHitPoints(-7, 10))
                        .build();
//        then
        assertThat(characterInformation.isDead()).isEqualTo(true);
    }

    @Test
    void characterIsNotDeadTest() {
//        given
        CharacterInformation characterInformation =
                DefaultCharacterInformation.builder().build();
//        then
        assertThat(characterInformation.isDead()).isEqualTo(false);
    }
}