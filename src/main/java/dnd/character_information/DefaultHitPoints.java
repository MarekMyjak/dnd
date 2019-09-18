package dnd.character_information;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class DefaultHitPoints implements HitPoints {
    private static final int DEFAULT_HIT_POINTS = 5;
    private static final int MINIMUM_HIT_POINTS_FROM_CONSTITUTION = 1;
    int actual;
    int maximum;

    DefaultHitPoints(AbilityScore abilityScore) {
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
