package dnd;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Builder
class PlayableCharacter implements Character {
    BackgroundInformation backgroundInformation;
    int armorClass;
    HitPoints hitPoints;
    AbilityScore abilityScore;
    int experiencePoints;

    public AttackResult attack(CharacterInformation enemy, int roll) {
        int damageModifier = abilityScore.getModifiers(abilityScore.getStrength());
        int attackRollModifier = abilityScore.getModifiers(abilityScore.getStrength());
        if (roll == 20) {
            return new AttackResult(AttackType.CRIT, damageModifier);
        }
        if (enemy.isHit(roll + attackRollModifier)) {
            return new AttackResult(AttackType.HIT, damageModifier);
        }
        return new AttackResult(AttackType.MISS, damageModifier);
    }

    @Override
    public void takeDamage(int amount) {
        hitPoints.change(-amount);
    }

    @Override
    public String getName() {
        return backgroundInformation.getName();
    }

    @Override
    public CharacterCondition getCharacterCondition() {
        return hitPoints.getActual() <= 0 ? CharacterCondition.DEAD : CharacterCondition.ALIVE;
    }

    @Override
    public boolean isHit(int roll) {
        return roll >= armorClass;
    }

    @Override
    public void increaseExperience(int amount) {
        experiencePoints += amount;
    }

    public static class PlayableCharacterBuilder {
        private static final int DEFAULT_ARMOR_CLASS = 10;

        public PlayableCharacterBuilder() {
            hitPoints = HitPoints.buildDefault();
            armorClass = DEFAULT_ARMOR_CLASS;
            abilityScore = AbilityScore.builder().build();
            experiencePoints = 0;
        }

        PlayableCharacter build() {
            HitPoints hitPointsWithConstitution = HitPoints.buildWithConstitution(hitPoints.getMaximum(),
                    abilityScore);

            return new PlayableCharacter(backgroundInformation,
                    armorClass + abilityScore.getModifiers(abilityScore.getDexterity()),
                    hitPointsWithConstitution,
                    abilityScore,
                    experiencePoints);
        }
    }
}
