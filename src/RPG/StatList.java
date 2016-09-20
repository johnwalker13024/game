package RPG;

/**
 * A list of all the stats along with getters
 * Created by johnathon on 9/19/2016.
 */
public class StatList {
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int spirit;
    private int runSpeed;
    private int health;
    private int mana;
    private int meleeAttackPower;
    private int rangedAttackPower;
    private int spellPower;
    private int meleeHitChance;
    private int rangedHitChance;
    private int spellHitChance;
    private int meleeCritChance;
    private int rangedCritChance;
    private int spellCritChance;
    private int dodgeChance;
    private int parryChance;
    private int blockChance;
    private int healthRegen;
    private int manaRegen;
    private int armor;

    // constructor: initialize all stats
    public StatList(int strength, int dexterity, int constitution, int intelligence, int spirit, int runSpeed,
                    int health, int mana, int meleeAttackPower, int rangedAttackPower, int spellPower,
                    int meleeHitChance, int rangedHitChance, int spellHitChance, int meleeCritChance,
                    int rangedCritChance, int spellCritChance, int dodgeChance, int parryChance, int blockChance,
                    int healthRegen, int manaRegen, int armor) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.spirit = spirit;
        this.runSpeed = runSpeed;
        this.health = health;
        this.mana = mana;
        this.meleeAttackPower = meleeAttackPower;
        this.rangedAttackPower = rangedAttackPower;
        this.spellPower = spellPower;
        this.meleeHitChance = meleeHitChance;
        this.rangedHitChance = rangedHitChance;
        this.spellHitChance = spellHitChance;
        this.meleeCritChance = meleeCritChance;
        this.rangedCritChance = rangedCritChance;
        this.spellCritChance = spellCritChance;
        this.dodgeChance = dodgeChance;
        this.parryChance = parryChance;
        this.blockChance = blockChance;
        this.healthRegen = healthRegen;
        this.manaRegen = manaRegen;
        this.armor = armor;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getSpirit() {
        return spirit;
    }

    public int getRunSpeed() {
        return runSpeed;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public int getMeleeAttackPower() {
        return meleeAttackPower;
    }

    public int getRangedAttackPower() {
        return rangedAttackPower;
    }

    public int getSpellPower() {
        return spellPower;
    }

    public int getMeleeHitChance() {
        return meleeHitChance;
    }

    public int getRangedHitChance() {
        return rangedHitChance;
    }

    public int getSpellHitChance() {
        return spellHitChance;
    }

    public int getMeleeCritChance() {
        return meleeCritChance;
    }

    public int getRangedCritChance() {
        return rangedCritChance;
    }

    public int getSpellCritChance() {
        return spellCritChance;
    }

    public int getDodgeChance() {
        return dodgeChance;
    }

    public int getParryChance() {
        return parryChance;
    }

    public int getBlockChance() {
        return blockChance;
    }

    public int getHealthRegen() {
        return healthRegen;
    }

    public int getManaRegen() {
        return manaRegen;
    }

    public int getArmor() {
        return armor;
    }
}
