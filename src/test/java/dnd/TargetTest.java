package dnd;

import dnd.character_information.DefaultCharacter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TargetTest {

    @Test
    void targetMethodTest() {
        Target target = DefaultCharacter.builder().build();

        target.takeDamage(1);
        assertThat(target.getArmorClass()).isEqualTo(10);
    }
}
