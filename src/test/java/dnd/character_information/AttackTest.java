package dnd.character_information;

import dnd.AttackType;
import dnd.Character;
import dnd.PlayableCharacter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

class AttackTest {

    @Test
    void successfulAttackWithMinimumRollTest() {
//        given
        int roll = 10;
        CharacterInformation enemy = DefaultCharacterInformation.builder().build();
        Character character = PlayableCharacter.builder().build();
//        when
//        then
        Assertions.assertThat(character.attack(enemy, roll)).isEqualTo(AttackType.HIT);
    }

    @Test
    void successfulAttackWithHigherRollTest() {
//        given
        CharacterInformation enemy = DefaultCharacterInformation.builder().build();
        Character character = PlayableCharacter.builder().build();
        int roll = 12;
//        when
//        then
        Assertions.assertThat(character.attack(enemy, roll)).isEqualTo(AttackType.HIT);
    }

    @Test
    void successfulAttackWithNatural20Test() {
//        given
        CharacterInformation enemy = DefaultCharacterInformation.builder().build();
        Character character = PlayableCharacter.builder().build();
        int roll = 20;
//        when
//        then
        assertThat(character.attack(enemy, roll)).isEqualTo(AttackType.CRIT);
    }

    @Test
    void successfulAttackWithNatural20AndHighArmorTest() {
//        given
        CharacterInformation enemy = Mockito.mock(CharacterInformation.class);
        Mockito.when(enemy.getArmorClass()).thenReturn(30);
        Character character = PlayableCharacter.builder().build();
        int roll = 20;
//        when
//        then
        assertThat(character.attack(enemy, roll)).isEqualTo(AttackType.CRIT);
    }

    @Test
    void missedAttackTest() {
//        given
        CharacterInformation enemy = DefaultCharacterInformation.builder().build();
        Character character = PlayableCharacter.builder().build();
        int roll = 5;
//        when
//        then
        assertThat(character.attack(enemy, roll)).isEqualTo(AttackType.MISS);
    }
}
