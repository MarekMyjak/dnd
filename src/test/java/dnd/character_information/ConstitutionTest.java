package dnd.character_information;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class ConstitutionTest {

    @Test
    void defaultConstitutionModifiersTest() {
//        given
        Constitution constitution = DefaultConstitution.builder().build();
//        then
        then(constitution.getHitPointsModifiers()).isEqualTo(1);
    }
}
