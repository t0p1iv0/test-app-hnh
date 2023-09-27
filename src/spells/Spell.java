package spells;

import creatures.Creature;

public interface Spell {
    void cast(Creature target);
    boolean hasCharges();
}
