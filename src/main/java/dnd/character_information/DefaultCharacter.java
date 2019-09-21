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
    private static final int DEFAULT_ARMOR_CLASS = 10;
    AbilityScore abilityScore;
    HitPoints hitPoints;
    private int experiencePoints;
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

    @Override
    public int getDamageModifier() {
        return abilityScore.getModifiers(abilityScore.getStrength());
    }


    @Override
    public void takeDamage(int amount) {
        getHitPoints().change(-amount);
    }


    public static class DefaultCharacterBuilder {

        public DefaultCharacterBuilder() {
            abilityScore = AbilityScore.builder().build();
        }

        public DefaultCharacter build() {
            return new DefaultCharacter(abilityScore,
                    hitPoints != null ? hitPoints : new DefaultHitPoints(abilityScore),
                    experiencePoints,
                    backgroundInformation);
        }
    }
}
