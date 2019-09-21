package dnd.character_information;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class DefaultHitPoints implements HitPoints {
    private static final int DEFAULT_HIT_POINTS = 5;
    int actual;
    int maximum;
    Constitution constitution;

    DefaultHitPoints(Constitution constitution) {
        this.constitution = constitution;
        maximum = DEFAULT_HIT_POINTS + constitution.getHitPointsModifiers();
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
    public void increaseHitPointsPerLevel() {
        int amount = 5 + constitution.getHitPointsModifiers();
        actual += amount;
        maximum += amount;
    }

    @Override
    public boolean isDead() {
        return actual <= 0;
    }
}
