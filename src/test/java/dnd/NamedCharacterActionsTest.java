package dnd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NamedCharacterActionsTest {

    @Test
    void createCharacterTest() {
//        given
        String name = "Marek";
//        when
        Named named = PlayableCharacter.builder()
                .backgroundInformation(BackgroundInformation.builder()
                        .name(name)
                        .build())
                .build();
//        then
        assertThat(named.getName()).isEqualTo(name);
    }
}
