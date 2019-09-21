package dnd.character_information;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IncreaseExperienceTest {

    @Test
    void increaseExperienceTest() {
//        given
        ExperiencePoints experiencePoints = DefaultExperiencePoints.builder().build();
//        when
        experiencePoints.increaseExperience(10);
//        then
        assertThat(experiencePoints.getExperiencePoints()).isEqualTo(10);
        assertThat(experiencePoints.getLevel()).isEqualTo(1);
    }

    @Test
    void increaseExperienceShouldIncreaseLevelTest() {
//        given
        ExperiencePoints experiencePoints = DefaultExperiencePoints.builder().build();
//        when
        experiencePoints.increaseExperience(1000);
//        then
        assertThat(experiencePoints.getExperiencePoints()).isEqualTo(1000);
        assertThat(experiencePoints.getLevel()).isEqualTo(2);
    }
}
