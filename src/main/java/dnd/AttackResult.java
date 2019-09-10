package dnd;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Getter
class AttackResult {
    AttackType attackType;
    int damageModifier;

    boolean isHit() {
        return AttackType.HIT == attackType || AttackType.CRIT == attackType;
    }
}
