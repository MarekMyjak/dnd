package dnd.fighter;

import dnd.character_information.*;

class FighterHitPoints extends DefaultHitPoints implements HitPoints {

    private static final int FIGHTER_HIT_POINTS_PER_LEVEL = 10;

    FighterHitPoints(Constitution constitution, ExperiencePoints experiencePoints) {
        super(constitution, experiencePoints);
    }

    static FighterHitPoints buildDefault() {
        return new FighterHitPoints(
                DefaultConstitution.builder().build(),
                DefaultExperiencePoints.builder().build());
    }

    @Override
    public int getMaximum() {
        return (FIGHTER_HIT_POINTS_PER_LEVEL - 1 + getConstitution().getHitPointsModifiers()) *
                getExperiencePoints().getLevel();
    }
}
