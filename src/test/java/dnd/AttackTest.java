package dnd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AttackTest {

    @Test
    void successfulAttackWithMinimumRollTest() {
//        given
        int defaultArmorClass = 10;
        PlayableCharacter enemy = PlayableCharacter.builder()
                .armorClass(defaultArmorClass)
                .build();
        Character character = PlayableCharacter.builder().build();
        //        when
        Combat.attack(character, enemy, defaultArmorClass);
//        then
        assertThat(enemy.getHitPoints().getActual()).isEqualTo(4);
        assertThat(enemy.getCharacterCondition()).isEqualTo(CharacterCondition.ALIVE);
    }

    @Test
    void successfulAttackWithHigherRollTest() {
//        given
        int defaultArmorClass = 10;
        PlayableCharacter enemy = PlayableCharacter.builder()
                .armorClass(defaultArmorClass)
                .build();
        Character character = PlayableCharacter.builder().build();
        int roll = defaultArmorClass + 2;
        //        when
        Combat.attack(character, enemy, roll);
//        then
        assertThat(enemy.getHitPoints().getActual()).isEqualTo(4);
        assertThat(enemy.getCharacterCondition()).isEqualTo(CharacterCondition.ALIVE);
    }

    @Test
    void successfulAttackWithNatural20Test() {
//        given
        PlayableCharacter enemy = PlayableCharacter.builder()
                .build();
        Character character = PlayableCharacter.builder().build();
        int rollNatural20 = 20;
        //        when
        Combat.attack(character, enemy, rollNatural20);
//        then
        assertThat(enemy.getHitPoints().getActual()).isEqualTo(3);
        assertThat(enemy.getCharacterCondition()).isEqualTo(CharacterCondition.ALIVE);
    }

    @Test
    void successfulAttackWithNatural20AndHighArmorTest() {
//        given
        PlayableCharacter enemy = PlayableCharacter.builder()
                .armorClass(30)
                .build();
        Character character = PlayableCharacter.builder().build();
        int rollNatural20 = 20;
        //        when
        Combat.attack(character, enemy, rollNatural20);
//        then
        assertThat(enemy.getHitPoints().getActual()).isEqualTo(3);
        assertThat(enemy.getCharacterCondition()).isEqualTo(CharacterCondition.ALIVE);
    }

    @Test
    void successfulAttackWithDeadOfEnemyTest() {
//        given
        PlayableCharacter enemy = PlayableCharacter.builder()
                .hitPoints(new HitPoints(1))
                .build();
        Character character = PlayableCharacter.builder().build();
        int roll = 15;
        //        when
        Combat.attack(character, enemy, roll);
//        then
        assertThat(enemy.getHitPoints().getActual()).isEqualTo(0);
        assertThat(enemy.getCharacterCondition()).isEqualTo(CharacterCondition.DEAD);
    }

    @Test
    void successfulAttackWithNatural20AndDeadOfEnemyTest() {
//        given
        PlayableCharacter enemy = PlayableCharacter.builder()
                .hitPoints(new HitPoints(1))
                .build();
        Character character = PlayableCharacter.builder().build();
        int rollNatural20 = 20;
        //        when
        Combat.attack(character, enemy, rollNatural20);
//        then
        assertThat(enemy.getHitPoints().getActual()).isEqualTo(-1);
        assertThat(enemy.getCharacterCondition()).isEqualTo(CharacterCondition.DEAD);

    }

    @Test
    void missedAttackTest() {
//        given
        PlayableCharacter enemy = PlayableCharacter.builder()
                .build();
        Character character = PlayableCharacter.builder().build();
        int roll = 5;
        //        when
        Combat.attack(character, enemy, roll);
//        then
        assertThat(enemy.getHitPoints().getActual()).isEqualTo(5);
        assertThat(enemy.getCharacterCondition()).isEqualTo(CharacterCondition.ALIVE);
    }

    @Test
    void successfulAttackWithStrengthModifierMinimumRollTest() {
//        given
        int defaultArmorClass = 10;
        PlayableCharacter enemy = PlayableCharacter.builder()
                .armorClass(defaultArmorClass)
                .build();
        Character character = PlayableCharacter
                .builder()
                .abilityScore(AbilityScore.builder().strength(12).build())
                .build();
        //        when
        Combat.attack(character, enemy, defaultArmorClass - 1);
//        then
        assertThat(enemy.getHitPoints().getActual()).isEqualTo(3);
        assertThat(enemy.getCharacterCondition()).isEqualTo(CharacterCondition.ALIVE);
    }

    @Test
    void successfulAttackWithNatural20WithStrengthModifierTest() {
//        given
        PlayableCharacter enemy = PlayableCharacter.builder()
                .build();
        Character character = PlayableCharacter
                .builder()
                .abilityScore(AbilityScore.builder()
                        .strength(13)
                        .build())
                .build();
        int rollNatural20 = 20;
        //        when
        Combat.attack(character, enemy, rollNatural20);
//        then
        assertThat(enemy.getHitPoints().getActual()).isEqualTo(1);
        assertThat(enemy.getCharacterCondition()).isEqualTo(CharacterCondition.ALIVE);
    }

    @Test
    void minimalDamageTest() {
//        given
        PlayableCharacter enemy = PlayableCharacter.builder()
                .build();
        Character character = PlayableCharacter
                .builder()
                .abilityScore(AbilityScore.builder()
                        .strength(1)
                        .build())
                .build();
        int roll = 18;
//        when
        Combat.attack(character, enemy, roll);
//        then
        assertThat(enemy.getHitPoints().getActual()).isEqualTo(4);
        assertThat(enemy.getCharacterCondition()).isEqualTo(CharacterCondition.ALIVE);
    }

    @Test
    void minimalDamageWithCriticalHitTest() {
//        given
        PlayableCharacter enemy = PlayableCharacter.builder()
                .build();
        Character character = PlayableCharacter
                .builder()
                .abilityScore(AbilityScore.builder()
                        .strength(1)
                        .build())
                .build();
        int roll = 20;
//        when
        Combat.attack(character, enemy, roll);
//        then
        assertThat(enemy.getHitPoints().getActual()).isEqualTo(4);
        assertThat(enemy.getCharacterCondition()).isEqualTo(CharacterCondition.ALIVE);
    }
}
