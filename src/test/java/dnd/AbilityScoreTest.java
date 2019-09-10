package dnd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AbilityScoreTest {

    @Test
    void defaultValueTest() {
//        given
        AbilityScore abilityScore = AbilityScore.builder().build();
//        then
        assertThat(abilityScore.getStrength()).isEqualTo(10);
        assertThat(abilityScore.getDexterity()).isEqualTo(10);
        assertThat(abilityScore.getConstitution()).isEqualTo(10);
        assertThat(abilityScore.getWisdom()).isEqualTo(10);
        assertThat(abilityScore.getIntelligence()).isEqualTo(10);
        assertThat(abilityScore.getCharisma()).isEqualTo(10);
    }
}