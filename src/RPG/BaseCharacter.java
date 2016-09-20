package RPG;

/**
 * Defines a default character that all player and non-player characters are derived from.
 *
 * Created by johnathon on 9/18/2016.
 */
public class BaseCharacter {
    private StatModifierGroup statModifierGroup;

    // primary stats
    private int baseStrength;
    private int baseDexterity;
    private int baseConstitution;
    private int baseIntelligence;
    private int baseSpirit;
    public int getStrength()     { return 0; }
    public int getDexterity()    { return 0; }
    public int getConstitution() { return 0; }
    public int getIntelligence() { return 0; }
    public int getSpirit()       { return 0; }

    // secondary stats
    public int getRunSpeed()          { return 0; }
    public int getHealth()            { return 0; }
    public int getMana()              { return 0; }
    public int getMeleeAttackPower()  { return 0; }
    public int getRangedAttackPower() { return 0; }
    public int getSpellPower()        { return 0; }
    public int getMeleeHitChance()    { return 0; }
    public int getRangedHitChance()   { return 0; }
    public int getMeleeCritChance()   { return 0; }
    public int getRangedCritChance()  { return 0; }
    public int getSpellCritChance()   { return 0; }
    public int getDodgeChance()       { return 0; }
    public int getParryChance()       { return 0; }
    public int getBlockChance()       { return 0; }
    public int getHealthRegen()       { return 0; }
    public int getManaRegen()         { return 0; }
    public int getArmor()             { return 0; }

    // level
    private int level;
    private int experience;
    private int restedExperience;
    public int getLevel()            { return level;            }
    public int getExperience()       { return experience;       }
    public int getRestedExperience() { return restedExperience; }
}
