package utilities.combatSystem;

import creatures.Creature;

public interface CombatSystem {
    void attack(Creature attacker, Creature defender);
}
