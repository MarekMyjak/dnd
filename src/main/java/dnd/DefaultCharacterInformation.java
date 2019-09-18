package dnd;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
class DefaultCharacterInformation implements CharacterInformation {
    AbilityScore abilityScore;
    int armorClass;
    DefaultHitPoints hitPoints;
    int level;
    private int experiencePoints;

    @Override
    public CharacterCondition getCharacterCondition() {
        return null;
    }

    @Override
    public DefaultHitPoints getHitPoints() {
        return hitPoints;
    }

    @Override
    public boolean isHit(int roll) {
        return false;
    }

    @Override
    public int getExperiencePoints() {
        return experiencePoints;
    }

    @Override
    public void increaseExperience(int amount) {
        experiencePoints += amount;
        while ((experiencePoints / 1000.0) >= level) {
            level += 1;
            hitPoints.increaseLevel(abilityScore);
        }
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getArmorClass() {
        return armorClass + abilityScore.getModifiers(abilityScore.getDexterity());
    }

    @Override
    public int getAttackRollModifier() {
        return abilityScore.getModifiers(abilityScore.getStrength()) + Math.floorDiv(level, 2);
    }

    public static class DefaultCharacterInformationBuilder {
        private static final int DEFAULT_ARMOR_CLASS = 10;
        static final int DEFAULT_LEVEL = 1;

        public DefaultCharacterInformationBuilder() {
            abilityScore = AbilityScore.builder().build();
            armorClass = DEFAULT_ARMOR_CLASS;
            hitPoints = new DefaultHitPoints(abilityScore);
            level = DEFAULT_LEVEL;
        }

        DefaultCharacterInformation build() {
            return new DefaultCharacterInformation(abilityScore,
                    armorClass,
                    new DefaultHitPoints(abilityScore),
                    level,
                    experiencePoints);
        }
    }
}
