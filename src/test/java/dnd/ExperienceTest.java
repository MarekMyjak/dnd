package dnd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExperienceTest {

    @Test
    void gainingExperienceTest() {
//        given
        Character character = PlayableCharacter.builder().build();
        Character enemy = PlayableCharacter.builder().build();
//        when
        Combat.attack(character, enemy, 16);
//        then
        assertThat(character.getExperiencePoints()).isEqualTo(10);
    }

    @Test
    void gainingExperienceTwoTimesTest() {
//        given
        Character character = PlayableCharacter.builder().build();
        Character enemy = PlayableCharacter.builder().build();
//        when
        Combat.attack(character, enemy, 16);
        Combat.attack(character, enemy, 16);
//        then
        assertThat(character.getExperiencePoints()).isEqualTo(20);
    }
}
