package utilities;

import creatures.Creature;

public class AttackModifierCalculator {

    //Расчет модификатора атаки по формуле: разность Атаки атакующего и Защиты защищающегося плюс 1
    public static int defaultCalculate(Creature attacker, Creature defender) {
        return attacker.getAttack() - defender.getDefence() + 1;
    }

    public static int unfairCalculate(Creature attacker, Creature defender) {
        if (defender.getName().equals("Boblin")) {
            return 100;
        } else
        return attacker.getAttack() - defender.getDefence() + 1;
    }
}
