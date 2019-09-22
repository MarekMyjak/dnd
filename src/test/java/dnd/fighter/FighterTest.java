package dnd.fighter;

import dnd.character_information.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.BDDAssertions.then;

class FighterTest {

    @Test
    void hitPointAt10LevelTest() {
//        given
        ExperiencePoints experiencePoints = Mockito.mock(ExperiencePoints.class);
        Mockito.when(experiencePoints.getLevel()).thenReturn(10);
        HitPoints fighterHitPoints = new FighterHitPoints(
                DefaultConstitution.builder().build(),
                        experiencePoints);
//        then
        then(fighterHitPoints.getMaximum()).isEqualTo(100);
    }
}
