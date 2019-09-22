package dnd.character_information;

import dnd.Attacker;
import dnd.Target;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DefaultCharacter implements Character, Attacker, Target {
    static final int DEFAULT_ARMOR_CLASS = 10;
    AbilityScores abilityScores;
    HitPoints hitPoints;
    ExperiencePoints experiencePoints;
    Named backgroundInformation;

    @Override
    public void increaseExperience(int amount) {
        int previousLevel = getLevel();
        experiencePoints.increaseExperience(amount);
        for (int i = previousLevel; i < experiencePoints.getLevel(); i++){
            hitPoints.increaseHitPointsPerLevel();
        }
    }

    @Override
    public int getLevel() {
        return experiencePoints.getLevel();
    }

    @Override
    public int getArmorClass() {
        return DEFAULT_ARMOR_CLASS + AbilityScores.getModifiers(abilityScores.getDexterity());
    }

    @Override
    public int getAttackRollModifier() {
        return AbilityScores.getModifiers(abilityScores.getStrength()) + Math.floorDiv(getLevel(), 2);
    }

    @Override
    public int getDamageModifier() {
        return AbilityScores.getModifiers(abilityScores.getStrength());
    }


    @Override
    public void takeDamage(int amount) {
        getHitPoints().takeDamage(amount);
    }

public static class DefaultCharacterBuilder {

    public DefaultCharacterBuilder() {
        abilityScores = AbilityScores.builder().build();
        experiencePoints = DefaultExperiencePoints.builder().build();
    }

    public DefaultCharacter build() {
        return new DefaultCharacter(abilityScores,
                hitPoints != null ? hitPoints : new DefaultHitPoints(DefaultConstitution.builder().build()),
                experiencePoints,
                backgroundInformation);
    }
}
}
