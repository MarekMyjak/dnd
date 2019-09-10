package dnd;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
class HitPoints {
    private static final int DEFAULT_HIT_POINTS = 5;
    private static final int MINIMUM_HIT_POINTS_FROM_CONSTITUTION = 1;
    int maximum;
    int actual;

    HitPoints(int hitPointsValue) {
        this(hitPointsValue, hitPointsValue);
    }

    static HitPoints buildDefault() {
        return new HitPoints(DEFAULT_HIT_POINTS, DEFAULT_HIT_POINTS);
    }

    static HitPoints buildWithConstitution(int baseHitPoints, AbilityScore abilityScore) {
        int hitPointsValue = baseHitPoints + getConstitutionModifiersWithMinimumValue(abilityScore);
        return new HitPoints(hitPointsValue);
    }

    void change(int amount) {
        actual += amount;
    }

    void increaseLevel(AbilityScore abilityScore) {
        int amount = 5 + getConstitutionModifiersWithMinimumValue(abilityScore);
        maximum += amount;
        actual += amount;
    }

    private static int getConstitutionModifiersWithMinimumValue(AbilityScore abilityScore) {
        int constitutionModifiers = abilityScore.getModifiers(abilityScore.getConstitution());
        return Math.max(MINIMUM_HIT_POINTS_FROM_CONSTITUTION, constitutionModifiers);
    }
}
