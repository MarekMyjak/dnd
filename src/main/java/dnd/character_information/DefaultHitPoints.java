package dnd.character_information;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class DefaultHitPoints implements HitPoints {
    private static final int DEFAULT_HIT_POINTS = 5;
    int actual;
    Constitution constitution;

    DefaultHitPoints(Constitution constitution, int level) {
        this.constitution = constitution;
        actual = getMaximum(level);
    }

    DefaultHitPoints(int amount) {
        if (amount < 0) {
            amount = 0;
        }
        actual = amount;
    }

    @Override
    public int getMaximum(int level) {
        return DEFAULT_HIT_POINTS + constitution.getHitPointsModifiers()
                + ((level - 1) * (5 + constitution.getHitPointsModifiers()));
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
    }

    @Override
    public boolean isDead() {
        return actual <= 0;
    }
}
