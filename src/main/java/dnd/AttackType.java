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
}
