package dnd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArmorClassTest {

    @Test
    void defaultArmorClassTest() {
//        given
        int expectedDefaultArmorClass = 10;
        CharacterInformation playableCharacter = PlayableCharacter
                .builder()
                .build();
//        then
        assertThat(playableCharacter.isHit(expectedDefaultArmorClass - 1)).isEqualTo(false);
        assertThat(playableCharacter.isHit(expectedDefaultArmorClass)).isEqualTo(true);
    }

    @Test
    void armorClassWithDexterityTest() {
//        given
        int expectedDefaultArmorClass = 12;
        CharacterInformation playableCharacter = PlayableCharacter
                .builder()
                .abilityScore(AbilityScore.builder()
                        .dexterity(15)
                        .build())
                .build();
//        then
        assertThat(playableCharacter.isHit(expectedDefaultArmorClass - 1)).isEqualTo(false);
        assertThat(playableCharacter.isHit(expectedDefaultArmorClass)).isEqualTo(true);
    }
}
