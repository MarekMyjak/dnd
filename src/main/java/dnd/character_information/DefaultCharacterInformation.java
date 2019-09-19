package dnd.character_information;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DefaultCharacterInformation implements CharacterInformation {
    private static final int DEFAULT_ARMOR_CLASS = 10;
    AbilityScore abilityScore;
    HitPoints hitPoints;
    private int experiencePoints;

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
        return DEFAULT_ARMOR_CLASS + abilityScore.getModifiers(abilityScore.getDexterity());
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

        public DefaultCharacterInformationBuilder() {
            abilityScore = AbilityScore.builder().build();
        }

        public DefaultCharacterInformation build() {
            return new DefaultCharacterInformation(abilityScore,
                    hitPoints != null ? hitPoints : new DefaultHitPoints(abilityScore),
                    experiencePoints);
        }
    }
}
