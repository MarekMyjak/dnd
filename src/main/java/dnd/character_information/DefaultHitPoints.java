package dnd.character_information;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class DefaultHitPoints implements HitPoints {
    private static final int DEFAULT_HIT_POINTS_PER_LEVEL = 5;
    @Getter
    int actual;
    @Getter(value = AccessLevel.PROTECTED)
    Constitution constitution;
    @Getter(value = AccessLevel.PROTECTED)
    final ExperiencePoints experiencePoints;

    public DefaultHitPoints(Constitution constitution, ExperiencePoints experiencePoints) {
        this.experiencePoints = experiencePoints;
        this.constitution = constitution;
        actual = getMaximum();
    }

    @Override
    public int getMaximum() {
        return (DEFAULT_HIT_POINTS_PER_LEVEL + constitution.getHitPointsModifiers()) *
                experiencePoints.getLevel();
    }

    @Override
    public void takeDamage(int amount) {
        actual -= amount;
        if (actual < 0) {
            actual = 0;
        }
    }

    @Override
    public boolean isDead() {
        return actual <= 0;
    }
}
