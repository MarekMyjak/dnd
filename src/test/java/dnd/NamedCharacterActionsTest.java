package dnd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NamedCharacterActionsTest {

    @Test
    void createCharacterTest() {
//        given
        String name = "Marek";
//        when
        Named named = BackgroundInformation.builder()
                .name(name)
                .build();
//        then
        assertThat(named.getName()).isEqualTo(name);
    }

    @Test
    void backgroundTest() {
//        given
        Named named = BackgroundInformation.builder()
                .alignment(Alignment.GOOD)
                .build();
//        then
        assertThat((named).getAlignment()).isEqualTo(Alignment.GOOD);
    }
}
