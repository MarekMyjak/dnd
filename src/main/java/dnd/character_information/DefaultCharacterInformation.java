package dnd.character_information;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DefaultCharacterInformation implements CharacterInformation {
    AbilityScore abilityScore;
    int armorClass;
    HitPoints hitPoints;
    private int experiencePoints;

    @Override
    public HitPoints getHitPoints() {
        return hitPoints;
    }

    @Override
    public boolean isHit(int roll) {
        return roll >= armorClass;
    }

    @Override
    public int getExperiencePoints() {
        return experiencePoints;
    }

    @Override
    public void increaseExperience(int amount) {
        int level = getLevel();
        experiencePoints += amount;
        while ((experiencePoints / 1000.0) >= level) {
            hitPoints.increaseLevel(abilityScore);
            level++;
        }
    }

    @Override
    public int getLevel() {
        return (experiencePoints / 1000) + 1;
    }

    @Override
    public int getArmorClass() {
        return armorClass + abilityScore.getModifiers(abilityScore.getDexterity());
    }

    @Override
    public int getAttackRollModifier() {
        return abilityScore.getModifiers(abilityScore.getStrength()) + Math.floorDiv(getLevel(), 2);
    }

    @Override
    public boolean isDead() {
        return hitPoints.getActual() <= 0;
    }

    public static class DefaultCharacterInformationBuilder {
        private static final int DEFAULT_ARMOR_CLASS = 10;
        static final int DEFAULT_LEVEL = 1;

        public DefaultCharacterInformationBuilder() {
            abilityScore = AbilityScore.builder().build();
            armorClass = DEFAULT_ARMOR_CLASS;
        }

        public DefaultCharacterInformation build() {
            return new DefaultCharacterInformation(abilityScore,
                    armorClass,
                    hitPoints != null ? hitPoints : new DefaultHitPoints(abilityScore),
                    experiencePoints);
        }
    }
}
