package dnd;

import org.junit.jupiter.api.Test;

import static dnd.AttackType.*;
import static org.assertj.core.api.BDDAssertions.then;

class AttackTypeTest {

    @Test
    void successfulAttackWithMinimumRollTest() {
        then(getAttackType(10, 0, 10)).isEqualTo(HIT);
    }

    @Test
    void successfulAttackWithHigherRollTest() {
        then(getAttackType(12, 0, 10)).isEqualTo(HIT);
    }

    @Test
    void successfulAttackWithLowRollButHighModifierTest() {
        then(getAttackType(1, 12, 10)).isEqualTo(HIT);
    }

    @Test
    void successfulAttackWithNatural20Test() {
        then(getAttackType(20, 0, 10)).isEqualTo(CRIT);
    }

    @Test
    void successfulAttackWithNatural20AndHighArmorTest() {
        then(getAttackType(20, 0, 30)).isEqualTo(CRIT);
    }

    @Test
    void missedAttackTest() {
        then(getAttackType(5, 0, 10)).isEqualTo(MISS);
    }
}
