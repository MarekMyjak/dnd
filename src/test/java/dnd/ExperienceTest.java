package dnd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ExperienceTest {

    @Mock
    Character character;

    @Mock
    Character enemy;

    @Test
    void gainingExperienceInCombatTest() {
//        given
        Mockito.when(character.attack(Mockito.any(), Mockito.anyInt())).thenReturn(AttackType.HIT);
//        when
        Combat.attack(character, enemy, 10);
//        then
        Mockito.verify(character, Mockito.times(1)).increaseExperience(Mockito.anyInt());
    }

    @Test
    void gainingExperienceTwoTimesTest() {
//        given
        Mockito.when(character.attack(Mockito.any(), Mockito.anyInt())).thenReturn(AttackType.HIT);
//        when
        Combat.attack(character, enemy, 10);
        Combat.attack(character, enemy, 10);
//        then
        Mockito.verify(character, Mockito.times(2)).increaseExperience(Mockito.anyInt());
    }

    @Test
    void notGainingExperienceOnMiss() {
//        given
        Mockito.when(character.attack(Mockito.any(), Mockito.anyInt())).thenReturn(AttackType.MISS);
//        when
        Combat.attack(character, enemy, 10);
//        then
        Mockito.verify(character, Mockito.times(0)).increaseExperience(Mockito.anyInt());
    }
}
