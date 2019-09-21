package dnd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class DealDamageInCombatTest {

    @Mock
    Character attacker;
    @Mock
    Character enemy;

    @Test
    void dealDamageOnHitTest() {
        Mockito.when(attacker.attack(enemy, 16)).thenReturn(AttackType.HIT);
//        when
        boolean attack = Combat.attack(attacker, enemy, 16);
//        then
        assertThat(attack).isEqualTo(true);
        Mockito.verify(enemy, Mockito.times(1)).takeDamage(1);
    }

    @Test
    void dealDoubleDamageOnCritTest() {
        Mockito.when(attacker.attack(enemy, 16)).thenReturn(AttackType.CRIT);
//        when
        boolean attack = Combat.attack(attacker, enemy, 16);
//        then
        assertThat(attack).isEqualTo(true);
        Mockito.verify(enemy, Mockito.times(1)).takeDamage(2);
    }
}
