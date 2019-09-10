package dnd;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * > As a playableCharacter I want to have several abilities so that I am not identical to other characters except in name
 * <p>
 * - Abilities are Strength, Dexterity, Constitution, Wisdom, Intelligence, Charisma
 * - Abilities range from 1 to 20 and default to 10
 * - Abilities have modifiers according to the following table
 * <p>
 * |   Score   | Modifier |   Score   | Modifier |   Score   | Modifier |   Score   | Modifier |
 * |:---------:|:--------:|:---------:|:--------:|:---------:|:--------:|:---------:|:--------:|
 * |   __1__   |    -5    |   __6__   |    -2    |  __11__   |     0    |  __16__   |    +3    |
 * |   __2__   |    -4    |   __7__   |    -2    |  __12__   |    +1    |  __17__   |    +3    |
 * |   __3__   |    -4    |   __8__   |    -1    |  __13__   |    +1    |  __18__   |    +4    |
 * |   __4__   |    -3    |   __9__   |    -1    |  __14__   |    +2    |  __19__   |    +4    |
 * |   __5__   |    -3    |  __10__   |     0    |  __15__   |    +2    |  __20__   |    +5    |
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Getter
class AbilityScore {
    static final int DEFAULT_ABILITY_SCORE = 10;
    @Builder.Default
    int strength = DEFAULT_ABILITY_SCORE;
    @Builder.Default
    int dexterity = DEFAULT_ABILITY_SCORE;
    @Builder.Default
    int constitution = DEFAULT_ABILITY_SCORE;
    @Builder.Default
    int wisdom = DEFAULT_ABILITY_SCORE;
    @Builder.Default
    int intelligence = DEFAULT_ABILITY_SCORE;
    @Builder.Default
    int charisma = DEFAULT_ABILITY_SCORE;

    int getModifiers(int score) {
        return Math.floorDiv(score - 10, 2);
    }
}
