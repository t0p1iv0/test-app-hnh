package spells;

import creatures.Creature;

public class Fireball implements Spell {
    private int charges = 1;
    @Override
    public void cast(Creature target) {
        if (hasCharges()) {
            target.takeDamage(30);

            charges--;

            System.out.println("Fireball hits " + target.getName() + " at 30 damage!");
        } else {
            System.out.println("Not enough spell charges to cast fireball!");
        }
    }

    @Override
    public boolean hasCharges() {
        return charges != 0;
    }
}
