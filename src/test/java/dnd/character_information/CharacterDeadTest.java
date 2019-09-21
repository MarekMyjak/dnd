package dnd.character_information;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CharacterDeadTest {

    @Test
    void characterIsDeadOnZeroHitPointsTest() {
//        given
        HitPoints hitPoints = new DefaultHitPoints(0);
//        then
        assertThat(hitPoints.isDead()).isEqualTo(true);
    }

    @Test
    void characterIsDeadOnNegativeHitPointsTest() {
//        given
        HitPoints hitPoints = new DefaultHitPoints(-7);
//        then
        assertThat(hitPoints.getActual()).isEqualTo(0);
        assertThat(hitPoints.isDead()).isEqualTo(true);
    }

    @Test
    void characterIsNotDeadTest() {
//        given
        HitPoints hitPoints = new DefaultHitPoints(10);
//        then
        assertThat(hitPoints.isDead()).isEqualTo(false);
    }
}
