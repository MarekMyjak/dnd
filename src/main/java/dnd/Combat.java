package dnd;

class Combat {
    private static final int DAMAGE_AMOUNT = 1;
    private static final int CRITICAL_DAMAGE_MULTIPLIER = 2;

    static void attack(Character attacker, Character enemy, int roll) {
        AttackResult attackResult = attacker.attack(enemy, roll);
        if (attackResult.isCrit()) {
            enemy.takeDamage(calculateCritDamage(attackResult.getDamageModifier()));
            return;
        }
        if (attackResult.isHit()) {
            enemy.takeDamage(calculateDamage(attackResult.getDamageModifier()));
        }
    }

    private static int calculateCritDamage(int damageModifier) {
        int amount = CRITICAL_DAMAGE_MULTIPLIER * (DAMAGE_AMOUNT + damageModifier);
        if (amount < 1) {
            amount = 1;
        }
        return amount;
    }

    private static int calculateDamage(int damageModifier) {
        int amount = DAMAGE_AMOUNT + damageModifier;
        if (amount < 1) {
            amount = 1;
        }
        return amount;
    }
}
