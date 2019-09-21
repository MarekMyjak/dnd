package dnd.character_information;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AbilityScoresModifiersTest {

    private static Stream<Arguments> provideModifierFromScore() {
        return Stream.of(
                Arguments.of(1, -5),
                Arguments.of(2, -4),
                Arguments.of(3, -4),
                Arguments.of(4, -3),
                Arguments.of(5, -3),
                Arguments.of(6, -2),
                Arguments.of(7, -2),
                Arguments.of(8, -1),
                Arguments.of(9, -1),
                Arguments.of(10, 0),
                Arguments.of(11, 0),
                Arguments.of(12, 1),
                Arguments.of(13, 1),
                Arguments.of(14, 2),
                Arguments.of(15, 2),
                Arguments.of(16, 3),
                Arguments.of(17, 3),
                Arguments.of(18, 4),
                Arguments.of(19, 4),
                Arguments.of(20, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("provideModifierFromScore")
    void modifierTableTest(int score, int modifier) {
        AbilityScores abilityScores = AbilityScores.builder()
                .build();
        assertThat(abilityScores.getModifiers(score)).isEqualTo(modifier);
    }
}