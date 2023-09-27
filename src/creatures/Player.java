package creatures;

import spells.Fireball;
import spells.Heal;
import spells.Spell;
import spells.Spells;

import java.util.HashMap;
import java.util.Map;

public class Player extends Creature {
    private final Map<String, Spell> spellBook;

    public Player(int attack, int defence, int maxHP, int minDamage, int maxDamage, String name) {
        super(attack, defence, maxHP, minDamage, maxDamage, name);

        //При создании объекта инициализируем мапу (книгу заклинаний)
        //и добавляем пару спеллов
        spellBook = new HashMap<>();
        spellBook.put(Spells.HEAL, new Heal());
        spellBook.put(Spells.FIREBALL, new Fireball());
    }

    public void castSpell(String spell, Creature target) {

        //Проверяем, есть ли заклинание в книге заклинаний
        try {
            spellBook.get(spell)
                    .cast(target);
        } catch (NullPointerException npe) {
            throw new IllegalArgumentException("Unknown spell: " + spell);
        }
    }

    public boolean hasSpellCharges(String spell) {
        return spellBook.get(spell)
                .hasCharges();
    }
}
