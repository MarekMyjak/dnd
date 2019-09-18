package dnd;

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
        assertThat(Combat.attack(character, enemy, roll)).isEqualTo(true);
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
        assertThat(Combat.attack(character, enemy, roll)).isEqualTo(true);
    }

    @Test
    void successfulAttackWithNatural20Test() {
//        given
        Character enemy = PlayableCharacter.builder().build();
        Character character = PlayableCharacter.builder().build();
        int roll = 20;
//        when
//        then
        assertThat(Combat.attack(character, enemy, roll)).isEqualTo(true);
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
        assertThat(Combat.attack(character, enemy, roll)).isEqualTo(true);
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
        assertThat(Combat.attack(character, enemy, roll)).isEqualTo(false);
    }

    @Test
    void successfulAttackWithStrengthModifierMinimumRollTest() {
//        given
        int roll = 9;
        Character enemy = PlayableCharacter.builder().build();
        Character character = PlayableCharacter
                .builder()
                .characterInformation(DefaultCharacterInformation.builder()
                        .abilityScore(AbilityScore.builder().strength(12).build())
                        .build())
                .build();
//        when
//        then
        assertThat(Combat.attack(character, enemy, roll)).isEqualTo(true);
    }
}
