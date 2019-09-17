package dnd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AttackTest {

    @Test
    void successfulAttackWithMinimumRollTest() {
//        given
        int roll = 10;
        PlayableCharacter enemy = PlayableCharacter.builder().build();
        Character character = PlayableCharacter.builder().build();
//        when
//        then
        assertThat(Combat.attack(character, enemy, roll)). isEqualTo(true);
    }

    @Test
    void successfulAttackWithHigherRollTest() {
//        given
        PlayableCharacter enemy = PlayableCharacter.builder()
                .build();
        Character character = PlayableCharacter.builder().build();
        int roll = 12;
//        when
//        then
        assertThat(Combat.attack(character, enemy, roll)). isEqualTo(true);
    }

    @Test
    void successfulAttackWithNatural20Test() {
//        given
        PlayableCharacter enemy = PlayableCharacter.builder().build();
        Character character = PlayableCharacter.builder().build();
        int roll = 20;
//        when
//        then
        assertThat(Combat.attack(character, enemy, roll)). isEqualTo(true);
    }

    @Test
    void successfulAttackWithNatural20AndHighArmorTest() {
//        given
        PlayableCharacter enemy = PlayableCharacter.builder()
                .armorClass(30)
                .build();
        Character character = PlayableCharacter.builder().build();
        int roll = 20;
//        when
//        then
        assertThat(Combat.attack(character, enemy, roll)). isEqualTo(true);
    }

    @Test
    void missedAttackTest() {
//        given
        PlayableCharacter enemy = PlayableCharacter.builder()
                .build();
        Character character = PlayableCharacter.builder().build();
        int roll = 5;
//        when
//        then
        assertThat(Combat.attack(character, enemy, roll)). isEqualTo(false);
    }

    @Test
    void successfulAttackWithStrengthModifierMinimumRollTest() {
//        given
        int roll = 9;
        PlayableCharacter enemy = PlayableCharacter.builder().build();
        Character character = PlayableCharacter
                .builder()
                .abilityScore(AbilityScore.builder().strength(12).build())
                .build();
//        when
//        then
        assertThat(Combat.attack(character, enemy, roll)). isEqualTo(true);

    }
}
