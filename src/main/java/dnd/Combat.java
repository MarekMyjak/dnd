package dnd;

import java.util.Map;
import java.util.function.Function;

class Combat {
    private static final int DAMAGE_AMOUNT = 1;
    private static final int CRITICAL_DAMAGE_MULTIPLIER = 2;
    private static final int EXPERIENCE_POINT_FOR_SUCCESSFUL_ATTACK = 10;

    private static final Map<AttackType, Function<Integer, Integer>> damageModifierMap = Map.of(
            AttackType.HIT, x -> x,
            AttackType.CRIT, x -> CRITICAL_DAMAGE_MULTIPLIER * x
    );

    static boolean attack(Character attacker, Character enemy, int roll) {
        AttackType attackType = attacker.attack(enemy.getCharacterInformation(), roll);
        if (AttackType.isHit(attackType)) {
            enemy.takeDamage(calculateDamage(attacker.getDamageModifier(), attackType));
            attacker.increaseExperience(EXPERIENCE_POINT_FOR_SUCCESSFUL_ATTACK);
            return true;
        }
        return false;
    }

    private static int calculateDamage(int damageModifier, AttackType attackType) {
        int amount = damageModifierMap.get(attackType).apply(DAMAGE_AMOUNT + damageModifier);
        if (amount < 1) {
            amount = 1;
        }
        return amount;
    }
}
