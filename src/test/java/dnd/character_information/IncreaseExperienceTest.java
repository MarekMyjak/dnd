package dnd.character_information;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IncreaseExperienceTest {

    @Test
    void increaseExperienceTest() {
//        given
        CharacterInformation characterInformation = DefaultCharacter.builder().build();
//        when
        characterInformation.increaseExperience(10);
//        then
        assertThat(characterInformation.getExperiencePoints()).isEqualTo(10);
        assertThat(characterInformation.getLevel()).isEqualTo(1);
    }

    @Test
    void increaseExperienceShouldIncreaseLevelTest() {
//        given
        CharacterInformation characterInformation = DefaultCharacter.builder().build();
//        when
        characterInformation.increaseExperience(1000);
//        then
        assertThat(characterInformation.getExperiencePoints()).isEqualTo(1000);
        assertThat(characterInformation.getLevel()).isEqualTo(2);
    }
}
