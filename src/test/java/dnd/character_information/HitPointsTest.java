package dnd.character_information;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.BDDAssertions.then;

class HitPointsTest {

    @Test
    void defaultHitPointsTest() {
//        given
        int expectedDefaultHitPoints = 6;
        HitPoints hitPoints = DefaultCharacter.builder().build().getHitPoints();
//        then
        then(hitPoints.getActual()).isEqualTo(expectedDefaultHitPoints);
    }

    @Test
    void hitPointsWithConstitutionModifierTest() {
//        given
        int expectedHitPoints = 7;
        HitPoints hitPoints = DefaultCharacter.builder()
                .constitution(14)
                .build()
                .getHitPoints();
//        then
        then(hitPoints.getActual()).isEqualTo(expectedHitPoints);
    }

    @Test
    void minimalHitPointsTest() {
//        given
        int expectedHitPoints = 6;
        HitPoints hitPoints = DefaultCharacter.builder()
                .constitution(1)
                .build()
                .getHitPoints();
//        then
        then(hitPoints.getActual()).isEqualTo(expectedHitPoints);
    }

    @Test
    void hitPointsAt10Level() {
//        given
        int expectedHitPoints = 60;
        ExperiencePoints experiencePoints = Mockito.mock(ExperiencePoints.class);
        Mockito.when(experiencePoints.getLevel()).thenReturn(10);
        HitPoints hitPoints = new DefaultHitPoints(DefaultConstitution.builder().build(), experiencePoints);
//        then
        then(hitPoints.getActual()).isEqualTo(expectedHitPoints);
    }
}