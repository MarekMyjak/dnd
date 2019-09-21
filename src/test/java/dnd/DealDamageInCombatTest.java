package dnd;

import dnd.character_information.DefaultCharacter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class DealDamageInCombatTest {

    @Mock
    Target enemy;

    @Test
    void dealDamageOnHitTest() {
        Attacker attacker = DefaultCharacter.builder().build();
        Mockito.when(enemy.getArmorClass()).thenReturn(10);
//        when
        boolean attack = Combat.attack(attacker, enemy, 16);
//        then
        assertThat(attack).isEqualTo(true);
        Mockito.verify(enemy, Mockito.times(1)).takeDamage(1);
    }

    @Test
    void dealDoubleDamageOnCritTest() {
        Attacker attacker = DefaultCharacter.builder().build();
        Mockito.when(enemy.getArmorClass()).thenReturn(10);
//        when
        boolean attack = Combat.attack(attacker, enemy, 20);
//        then
        assertThat(attack).isEqualTo(true);
        Mockito.verify(enemy, Mockito.times(1)).takeDamage(2);
    }
}
