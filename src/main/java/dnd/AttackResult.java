package dnd;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
class AttackResult {
    AttackType attackType;
    @Getter
    int damageModifier;

    boolean isCrit() {
        return AttackType.CRIT == attackType;
    }

    boolean isHit() {
        return AttackType.HIT == attackType;
    }
}
