package dnd;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
class DefaultHitPoints implements HitPoints {
    private static final int DEFAULT_HIT_POINTS = 5;
    private static final int MINIMUM_HIT_POINTS_FROM_CONSTITUTION = 1;
    int actual;
    int maximum;

    public DefaultHitPoints(AbilityScore abilityScore) {
        maximum = DEFAULT_HIT_POINTS + getConstitutionModifiersWithMinimumValue(abilityScore);
        actual = maximum;
    }

    @Override
    public int getMaximum() {
        return maximum;
    }

    @Override
    public void change(int amount) {
        actual += amount;
    }

    @Override
    public void increaseLevel(AbilityScore abilityScore) {
        int amount = 5 + getConstitutionModifiersWithMinimumValue(abilityScore);
        actual += amount;
        maximum += amount;
    }

    private static int getConstitutionModifiersWithMinimumValue(AbilityScore abilityScore) {
        int constitutionModifiers = abilityScore.getModifiers(abilityScore.getConstitution());
        return Math.max(MINIMUM_HIT_POINTS_FROM_CONSTITUTION, constitutionModifiers);
    }
}
