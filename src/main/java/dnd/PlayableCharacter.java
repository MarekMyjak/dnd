package dnd;

import dnd.character_information.CharacterInformation;
import dnd.character_information.DefaultCharacterInformation;
import dnd.character_information.Named;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Builder
public class PlayableCharacter implements Character {
    Named backgroundInformation;
    @Builder.Default
    CharacterInformation characterInformation = DefaultCharacterInformation.builder().build();

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
    public void takeDamage(int amount) {
        characterInformation.getHitPoints().change(-amount);
    }

    @Override
    public int getAttackRollModifier() {
        return characterInformation.getAttackRollModifier();
    }

    @Override
    public int getDamageModifier() {
        return characterInformation.getAttackRollModifier();
    }

    @Override
    public void increaseExperience(int amount) {
        characterInformation.increaseExperience(amount);
    }
}
