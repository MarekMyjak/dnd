package dnd.character_information;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CharacterDeadTest {

    @Test
    void characterIsDeadOnZeroHitPointsTest() {
//        given
        HitPoints hitPoints = new DefaultHitPoints(0, 10);
//        then
        assertThat(hitPoints.isDead()).isEqualTo(true);
    }

    @Test
    void characterIsDeadOnNegativeHitPointsTest() {
//        given
        HitPoints hitPoints = new DefaultHitPoints(-7, 10);
//        then
        assertThat(hitPoints.isDead()).isEqualTo(true);
    }

    @Test
    void characterIsNotDeadTest() {
//        given
        HitPoints hitPoints = new DefaultHitPoints(10, 10);
//        then
        assertThat(hitPoints.isDead()).isEqualTo(false);
    }
}
