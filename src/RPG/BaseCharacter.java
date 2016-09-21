package RPG;

/**
 * Defines a default character that all player and non-player characters are derived from.
 *
 * Created by johnathon on 9/18/2016.
 */
public class BaseCharacter {
    private StatModifierManager statModifierManager;
    private EquipmentManager equipmentManager;

    // primary stats
    private int baseStrength;
    private int baseDexterity;
    private int baseConstitution;
    private int baseIntelligence;
    private int baseSpirit;
    public int getStrength()     { return baseStrength     + statModifierManager.getStatModifierSum(Stat.Strength);     }
    public int getDexterity()    { return baseDexterity    + statModifierManager.getStatModifierSum(Stat.Dexterity);    }
    public int getConstitution() { return baseConstitution + statModifierManager.getStatModifierSum(Stat.Constitution); }
    public int getIntelligence() { return baseIntelligence + statModifierManager.getStatModifierSum(Stat.Intelligence); }
    public int getSpirit()       { return baseSpirit       + statModifierManager.getStatModifierSum(Stat.Spirit);       }

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

    /**
     * Default constructor
     */
    public BaseCharacter() {
        statModifierManager = new StatModifierManager();
        equipmentManager = new EquipmentManager(this);
        level = 1;
    }

    /**
     * Attempt to equip an item
     * @param equipment the item to be equipped
     */
    public void equip(Equipment equipment) {
        if (equipmentManager.equip(equipment)) {
            statModifierManager.addStatModifier(equipment.getStatModifier());
        } else {
            System.out.println("Please un-equip the currently equipped item first.");
        }
    }

    /**
     * Attempt to un-equip the item in specified slot
     * @param slot attempt to un-equip the item in this slot
     */
    public void unequip(EquipmentSlot slot) {
        // check to see if something is equipped in that slot
        Equipment currentlyEquipped = equipmentManager.getEquippedItemInSlot(slot);
        if (currentlyEquipped != null) {
            equipmentManager.unequip(slot);
            statModifierManager.removeStatModifier(currentlyEquipped.getStatModifier());
        }
    }

    /**
     * Returns the currently equipped item, if any
     * @param slot specify which slot to return
     * @return currently equipped item
     */
    public Equipment getCurrentlyEquippedItem(EquipmentSlot slot) {
        return equipmentManager.getEquippedItemInSlot(slot);
    }
}
