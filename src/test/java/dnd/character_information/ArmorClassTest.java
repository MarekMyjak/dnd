package dnd.character_information;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArmorClassTest {

    @Test
    void defaultArmorClassTest() {
//        given
        int expectedDefaultArmorClass = 10;
        Character character = DefaultCharacter.builder().build();
//        then
        assertThat(character.getArmorClass()).isEqualTo(expectedDefaultArmorClass);
    }

    @Test
    void armorClassWithDexterityTest() {
//        given
        int expectedDefaultArmorClass = 12;
        Character character = DefaultCharacter
                .builder()
                .abilityScore(AbilityScore.builder()
                        .dexterity(15)
                        .build())
                .build();
//        then
        assertThat(character.getArmorClass()).isEqualTo(expectedDefaultArmorClass);
    }
}
