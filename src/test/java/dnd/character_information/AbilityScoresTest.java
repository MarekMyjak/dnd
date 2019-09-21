package dnd.character_information;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AbilityScoresTest {

    @Test
    void defaultValueTest() {
//        given
        AbilityScores abilityScores = AbilityScores.builder().build();
//        then
        assertThat(abilityScores.getStrength()).isEqualTo(10);
        assertThat(abilityScores.getDexterity()).isEqualTo(10);
        assertThat(abilityScores.getWisdom()).isEqualTo(10);
        assertThat(abilityScores.getIntelligence()).isEqualTo(10);
        assertThat(abilityScores.getCharisma()).isEqualTo(10);
    }
}