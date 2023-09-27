package utilities.combatSystem;

import creatures.Creature;
import utilities.AttackModifierCalculator;
import utilities.DiceRoller;

public class DefaultCombatSystem implements CombatSystem {

    @Override
    public void attack(Creature attacker, Creature defender) {
        int attackModifier = AttackModifierCalculator.defaultCalculate(attacker, defender);

        if (isAttackHit(attackModifier)) {
            int damage = calculateDamage(attacker);
            defender.takeDamage(damage);

            System.out.printf("%s deal %d damage to %s.\n",
                    attacker.getName(), damage, defender.getName());

            if (!defender.isAlive())
                System.out.println(defender.getName() + " was slain.");
        } else {
            System.out.println(attacker.getName() + " missed!");
        }
    }

    //Проверка на попадание. Бросаем кубики до тех пор, пока модификатор
    //атаки не станет >1 (неудачный исход) или пока не выбьем >=5 (удачный исход)
    private boolean isAttackHit(int attackModifier) {
        do {
            if (DiceRoller.isActionSuccessful(6, 5)) {
                return true;
            }
            attackModifier--;
        } while (attackModifier >= 1);

        return false;
    }

    //Расчет урона, берем случайное число между мин. уроном и макс.уроном
    private int calculateDamage(Creature attacker) {
        return (int) (attacker.getMinDamage() + Math.random() * attacker.getMaxDamage());
    }
}
