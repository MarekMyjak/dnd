package dnd.character_information;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class DefaultHitPoints implements HitPoints {
    private static final int DEFAULT_HIT_POINTS = 5;
    @Getter
    int actual;
    Constitution constitution;
    final ExperiencePoints experiencePoints;

    DefaultHitPoints(Constitution constitution, ExperiencePoints experiencePoints) {
        this.experiencePoints = experiencePoints;
        this.constitution = constitution;
        actual = getMaximum();
    }

    @Override
    public int getMaximum() {
        return DEFAULT_HIT_POINTS + constitution.getHitPointsModifiers()
                + ((experiencePoints.getLevel() - 1) * (5 + constitution.getHitPointsModifiers()));
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
