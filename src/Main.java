import creatures.Monster;
import creatures.Player;
import spells.Spells;
import utilities.combatSystem.CombatSystem;
import utilities.combatSystem.DefaultCombatSystem;

public class Main {
    public static void main(String[] args) {

        CombatSystem combat = new DefaultCombatSystem();

        //Создание персонажа с валидными характеристиками
        Player player = new Player(10, 10, 70, 10, 15, "Hiro");

        //Создание персонажа с невалидными характеристиками
        //Player player1 = new Player(40, 5, 50, 5, 10, "Hiro");

        //Создание монстра
        Monster goblin = new Monster(5, 3, 20, 3, 10, "Boblin");
        Monster boss = new Monster(15, 15, 100, 10, 20, "Bearshark");

        //Боевка
        while (true) {
            combat.attack(player, goblin);
            if (!goblin.isAlive())
                break;

            combat.attack(goblin, player);
            if (!player.isAlive())
                break;
        }

        while (player.isAlive() && boss.isAlive()) {
            combat.attack(player, boss);
            if (!boss.isAlive())
                break;

            combat.attack(boss, player);
            if (!player.isAlive())
                break;

            if (player.hasSpellCharges(Spells.HEAL) &&player.getCurrentHP() < player.getMaxHP() / 2) {
                player.castSpell(Spells.HEAL, player);
            }
        }


        Player mage = new Player(1, 1, 5, 20, 50, "Gendalf");
        Monster dummy = new Monster(1, 30, 100, 1, 1, "Dummy");

        //Каст заклинаний
        mage.castSpell(Spells.FIREBALL, dummy);
        mage.castSpell(Spells.FIREBALL, dummy);
        mage.castSpell(Spells.HEAL, mage);
        mage.castSpell(Spells.HEAL, player);
        mage.castSpell(Spells.HEAL, mage);
        mage.castSpell(Spells.HEAL, mage);
        mage.castSpell(Spells.HEAL, mage);

        //Каст невалидного заклинания
        //player.castSpell("Hel", player);
    }
}
