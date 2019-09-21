package dnd;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AttackType {
    HIT, CRIT, MISS;

    static boolean isHit(AttackType attackType) {
        return HIT == attackType || CRIT == attackType;
    }

    static AttackType getAttackType(int roll, int attackerAttackRollModifier, int enemyArmorClass) {
        if (roll == 20) {
            return AttackType.CRIT;
        }
        if (enemyArmorClass <= roll + attackerAttackRollModifier) {
            return AttackType.HIT;
        }
        return AttackType.MISS;
    }
}
