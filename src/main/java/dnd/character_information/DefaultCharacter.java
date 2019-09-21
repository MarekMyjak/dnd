package dnd.character_information;

import dnd.AttackType;
import dnd.Character;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DefaultCharacter implements Character {
    static final int DEFAULT_ARMOR_CLASS = 10;
    AbilityScore abilityScore;
    HitPoints hitPoints;
    ExperiencePoints experiencePoints;
    Named backgroundInformation;

    public AttackType attack(CharacterInformation enemy, int roll) {
        if (roll == 20) {
            return AttackType.CRIT;
        }
        if (enemy.getArmorClass() <= roll + getAttackRollModifier()) {
            return AttackType.HIT;
        }
        return AttackType.MISS;
    }

    @Override
    public void increaseExperience(int amount) {
        int level = getLevel();
        experiencePoints.increaseExperience(amount);
        while (experiencePoints.getLevel() > level) {
            hitPoints.increaseHitPointsPerLevel(abilityScore);
            level++;
        }
    }

    @Override
    public int getLevel() {
        return experiencePoints.getLevel();
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
    public int getDamageModifier() {
        return abilityScore.getModifiers(abilityScore.getStrength());
    }


    @Override
    public void takeDamage(int amount) {
        getHitPoints().takeDamage(amount);
    }


    public static class DefaultCharacterBuilder {

        public DefaultCharacterBuilder() {
            abilityScore = AbilityScore.builder().build();
            experiencePoints = DefaultExperiencePoints.builder().build();
        }

        public DefaultCharacter build() {
            return new DefaultCharacter(abilityScore,
                    hitPoints != null ? hitPoints : new DefaultHitPoints(abilityScore),
                    experiencePoints,
                    backgroundInformation);
        }
    }
}
