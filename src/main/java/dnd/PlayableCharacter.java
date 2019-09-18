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
    CharacterInformation characterInformation;
    Named backgroundInformation;
    int armorClass;
    HitPoints hitPoints;
    AbilityScore abilityScore;
    int experiencePoints;
    int level;

    public AttackType attack(CharacterInformation enemy, int roll) {
        if (roll == 20) {
            return AttackType.CRIT;
        }
        if (enemy.isHit(roll + getAttackRollModifier())) {
            return AttackType.HIT;
        }
        return AttackType.MISS;
    }

    @Override
    public void takeDamage(int amount) {
        hitPoints.change(-amount);
    }

    @Override
    public int getAttackRollModifier() {
        return abilityScore.getModifiers(abilityScore.getStrength()) + Math.floorDiv(level, 2);
    }

    @Override
    public int getDamageModifier() {
        return abilityScore.getModifiers(abilityScore.getStrength());

    }

    @Override
    public String getName() {
        return backgroundInformation.getName();
    }

    @Override
    public Alignment getAlignment() {
        return backgroundInformation.getAlignment();
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
        while ((experiencePoints / 1000.0) >= level) {
            increaseLevel();
        }
    }

    private void increaseLevel() {
        level += 1;
        hitPoints.increaseLevel(abilityScore);
    }

    public static class PlayableCharacterBuilder {
        private static final int DEFAULT_ARMOR_CLASS = 10;

        public PlayableCharacterBuilder() {
            characterInformation = DefaultCharacterInformation.builder().build();
            armorClass = DEFAULT_ARMOR_CLASS;
            abilityScore = AbilityScore.builder().build();
            experiencePoints = 0;
            level = 1;
        }

        PlayableCharacter build() {
            hitPoints = new DefaultHitPoints(abilityScore);
            return new PlayableCharacter(characterInformation,
                    backgroundInformation,
                    armorClass + abilityScore.getModifiers(abilityScore.getDexterity()),
                    hitPoints,
                    abilityScore,
                    experiencePoints,
                    level);
        }
    }
}
