package spells;

import creatures.Creature;

public class Heal implements Spell {
    private int charges = 4;

    @Override
    public void cast(Creature target) {
        if (hasCharges()) {

            //Находим значение лечения, складывая текуще здоровье и 30% от макс. здоровья
            int heal = (int) (target.getCurrentHP() + target.getMaxHP() * 0.3);

            //Если хил превышает макс. здоровье, то хилимся до макс. здоровья
            if (target.getMaxHP() < heal) {
                target.setCurrentHP(target.getMaxHP());
            } else {
                target.setCurrentHP(heal);
            }

            charges--;

            System.out.printf("%s was healed.\nCurrent HP: %d\nRemaining charges: %d\n",
                    target.getName(), target.getCurrentHP(), charges);
        } else
            System.out.println("Not enough spell charges to cast heal!");
    }

    public boolean hasCharges() {
        return charges != 0;
    }
}
