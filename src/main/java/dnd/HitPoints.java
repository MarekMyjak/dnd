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
    int maximum;
    int actual;

    HitPoints(int hitPointsValue) {
        this(hitPointsValue, hitPointsValue);
    }

    static HitPoints buildDefault() {
        return new HitPoints(DEFAULT_HIT_POINTS, DEFAULT_HIT_POINTS);
    }

    static HitPoints buildWithConstitution(int baseHitPoints, AbilityScore abilityScore) {
        int hitPointsValue = baseHitPoints + abilityScore.getModifiers(abilityScore.getConstitution());
        if (hitPointsValue == 0) {
            hitPointsValue = 1;
        }
        return new HitPoints(hitPointsValue);
    }

    void change(int amount) {
        actual += amount;
    }
}
