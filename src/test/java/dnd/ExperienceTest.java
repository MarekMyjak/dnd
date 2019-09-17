package dnd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ExperienceTest {

    @Test
    void gainingExperienceInCombatTest() {
//        given
        Character character = Mockito.mock(Character.class);
        Mockito.when(character.attack(Mockito.any(), Mockito.anyInt())).thenReturn(AttackType.HIT);
        Character enemy = Mockito.mock(Character.class);
//        when
        Combat.attack(character, enemy, 10);
//        then
        Mockito.verify(character, Mockito.times(1)).increaseExperience(Mockito.anyInt());
    }

    @Test
    void gainingExperienceTwoTimesTest() {
//        given
        Character character = Mockito.mock(Character.class);
        Mockito.when(character.attack(Mockito.any(), Mockito.anyInt())).thenReturn(AttackType.HIT);
        Character enemy = Mockito.mock(Character.class);
//        when
        Combat.attack(character, enemy, 10);
        Combat.attack(character, enemy, 10);
//        then
        Mockito.verify(character, Mockito.times(2)).increaseExperience(Mockito.anyInt());
    }

    @Test
    void notGainingExperienceOnMiss() {
//        given
        Character character = Mockito.mock(Character.class);
        Mockito.when(character.attack(Mockito.any(), Mockito.anyInt())).thenReturn(AttackType.MISS);
        Character enemy = Mockito.mock(Character.class);
//        when
        Combat.attack(character, enemy, 10);
//        then
        Mockito.verify(character, Mockito.times(0)).increaseExperience(Mockito.anyInt());
    }
}
