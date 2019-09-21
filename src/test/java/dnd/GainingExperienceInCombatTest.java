package dnd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GainingExperienceInCombatTest {

    @Mock
    Attacker character;

    @Mock
    Target enemy;

    @Test
    void gainingExperienceInCombatTest() {
//        given
        Mockito.when(character.getAttackRollModifier()).thenReturn(10);
//        when
        Combat.attack(character, enemy, 10);
//        then
        Mockito.verify(character, Mockito.times(1)).increaseExperience(Mockito.anyInt());
    }

    @Test
    void gainingExperienceTwoTimesTest() {
//        given
        Mockito.when(character.getAttackRollModifier()).thenReturn(10);
//        when
        Combat.attack(character, enemy, 10);
        Combat.attack(character, enemy, 10);
//        then
        Mockito.verify(character, Mockito.times(2)).increaseExperience(Mockito.anyInt());
    }

    @Test
    void notGainingExperienceOnMiss() {
//        given
        Mockito.when(character.getAttackRollModifier()).thenReturn(0);
        Mockito.when(enemy.getArmorClass()).thenReturn(20);
//        when
        Combat.attack(character, enemy, 0);
//        then
        Mockito.verify(character, Mockito.times(0)).increaseExperience(Mockito.anyInt());
    }
}
