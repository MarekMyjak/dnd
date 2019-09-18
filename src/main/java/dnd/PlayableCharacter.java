package dnd;

import dnd.character_information.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Builder
public class PlayableCharacter implements dnd.character_information.Character {
    Named backgroundInformation;
    @Builder.Default
    CharacterInformation characterInformation = DefaultCharacterInformation.builder().build();

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
        characterInformation.getHitPoints().change(-amount);
    }

    @Override
    public int getAttackRollModifier() {
        return characterInformation.getAttackRollModifier();
    }

    @Override
    public boolean isDead() {
        return characterInformation.isDead();
    }

    @Override
    public int getDamageModifier() {
        return characterInformation.getAttackRollModifier();

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
    public HitPoints getHitPoints() {
        return characterInformation.getHitPoints();
    }

    @Override
    public boolean isHit(int roll) {
        return roll >= characterInformation.getArmorClass();
    }

    @Override
    public int getExperiencePoints() {
        return characterInformation.getExperiencePoints();
    }

    @Override
    public void increaseExperience(int amount) {
        characterInformation.increaseExperience(amount);
    }

    @Override
    public int getLevel() {
        return characterInformation.getLevel();
    }

    @Override
    public int getArmorClass() {
        return characterInformation.getArmorClass();
    }
}
