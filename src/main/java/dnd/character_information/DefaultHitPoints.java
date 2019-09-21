package dnd.character_information;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

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

    DefaultHitPoints(int amount) {
        if (amount < 0) {
            amount = 0;
        }
        maximum = amount;
        actual = amount;
    }

    @Override
    public int getMaximum() {
        return maximum;
    }

    @Override
    public void takeDamage(int amount) {
        actual -= amount;
        if (actual < 0) {
            actual = 0;
        }
    }

    @Override
    public void increaseHitPointsPerLevel(AbilityScore abilityScore) {
        int amount = 5 + getConstitutionModifiersWithMinimumValue(abilityScore);
        actual += amount;
        maximum += amount;
    }

    @Override
    public boolean isDead() {
        return actual <= 0;
    }

    private static int getConstitutionModifiersWithMinimumValue(AbilityScore abilityScore) {
        int constitutionModifiers = abilityScore.getModifiers(abilityScore.getConstitution());
        return Math.max(MINIMUM_HIT_POINTS_FROM_CONSTITUTION, constitutionModifiers);
    }
}
