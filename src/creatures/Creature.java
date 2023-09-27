package creatures;

public abstract class Creature {
    private int attack;
    private int defence;
    private int maxHP;
    private int currentHP;
    private int minDamage;
    private int maxDamage;
    private boolean alive;
    private String name;

    public Creature(int attack, int defence, int maxHP, int minDamage, int maxDamage, String name) {
        if (attack < 1 || attack > 30) {
            throw new IllegalArgumentException("Attack cannot be less then 1 or more than 30.");
        } else {
            this.attack = attack;
        }

        if (defence < 1 || defence > 30) {
            throw new IllegalArgumentException("Defence cannot be less then 1 or more than 30.");
        } else {
            this.defence = defence;
        }

        if (maxHP < 1) {
            throw new IllegalArgumentException("Hit points cannot be less then 1.");
        } else {
            this.maxHP = maxHP;
            currentHP = maxHP;
        }

        if (minDamage > maxDamage) {
            throw new IllegalArgumentException("MinDamage cannot be more then maxDamage.");
        }
        else if (minDamage < 1) {
            throw new IllegalArgumentException("Damage cannot be less then 1.");
        } else {
            this.minDamage = minDamage;
            this.maxDamage = maxDamage;
        }

        this.name = name;
        alive = true;
    }

    public void takeDamage(int damage) {
        if (damage < currentHP)
            currentHP -= damage;
        else {
            currentHP = 0;
            alive = false;
        }
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
