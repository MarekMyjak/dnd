package dnd.character_information;

import lombok.Builder;

import static dnd.character_information.AbilityScores.DEFAULT_ABILITY_SCORE;

@Builder
class DefaultConstitution implements Constitution {
    private static final int MINIMUM_HIT_POINTS_FROM_CONSTITUTION = 1;

    @Builder.Default
    int value = DEFAULT_ABILITY_SCORE;

    @Override
    public int getHitPointsModifiers() {
        return Math.max(MINIMUM_HIT_POINTS_FROM_CONSTITUTION, AbilityScores.getModifiers(value));
    }
}
