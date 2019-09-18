package dnd.character_information;

import dnd.AttackType;
import dnd.Character;
import dnd.PlayableCharacter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AttackTest {

    @Test
    void successfulAttackWithMinimumRollTest() {
//        given
        int roll = 10;
        Character enemy = PlayableCharacter.builder().build();
        Character character = PlayableCharacter.builder().build();
//        when
//        then
        Assertions.assertThat(character.attack(enemy, roll)).isEqualTo(AttackType.HIT);
    }

    @Test
    void successfulAttackWithHigherRollTest() {
//        given
        Character enemy = PlayableCharacter.builder()
                .build();
        Character character = PlayableCharacter.builder().build();
        int roll = 12;
//        when
//        then
        Assertions.assertThat(character.attack(enemy, roll)).isEqualTo(AttackType.HIT);
    }

    @Test
    void successfulAttackWithNatural20Test() {
//        given
        Character enemy = PlayableCharacter.builder().build();
        Character character = PlayableCharacter.builder().build();
        int roll = 20;
//        when
//        then
        assertThat(character.attack(enemy, roll)).isEqualTo(AttackType.CRIT);
    }

    @Test
    void successfulAttackWithNatural20AndHighArmorTest() {
//        given
        Character enemy = PlayableCharacter.builder()
                .characterInformation(
                        DefaultCharacterInformation.builder().armorClass(30).build())
                .build();
        Character character = PlayableCharacter.builder().build();
        int roll = 20;
//        when
//        then
        assertThat(character.attack(enemy, roll)).isEqualTo(AttackType.CRIT);
    }

    @Test
    void missedAttackTest() {
//        given
        Character enemy = PlayableCharacter.builder()
                .build();
        Character character = PlayableCharacter.builder().build();
        int roll = 5;
//        when
//        then
        assertThat(character.attack(enemy, roll)).isEqualTo(AttackType.MISS);
    }
}
