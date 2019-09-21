package dnd;

import dnd.character_information.DefaultCharacter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class AttackerTest {

    @Test
    void attackerMethodTest() {
//        given
        Attacker attacker = DefaultCharacter.builder().build();

        attacker.increaseExperience(10);
        then(attacker.getAttackRollModifier()).isEqualTo(0);
        then(attacker.getDamageModifier()).isEqualTo(0);
    }
}
