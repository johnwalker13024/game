package RPG;

/**
 * Defines a default character that all player and non-player characters are derived from.
 *
 * Created by johnathon on 9/18/2016.
 */
public class BaseCharacter {
    private StatModifierManager statModifierManager;
    private EquipmentManager equipmentManager;
    private InventoryManager inventoryManager;

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

    // secondary stats TODO: return statModifierManager values and implement algorithms
    public int getRunSpeed()                { return 0; }
    public int getHealth()                  { return 0; }
    public int getMana()                    { return 0; }
    public int getMeleeAttackPower()        { return 0; }
    public int getRangedAttackPower()       { return 0; }
    public int getSpellPower()              { return 0; }
    public int getMeleeHitChance()          { return 0; }
    public int getRangedHitChance()         { return 0; }
    public int getMeleeCritChance()         { return 0; }
    public int getRangedCritChance()        { return 0; }
    public int getSpellCritChance()         { return 0; }
    public int getDodgeChance()             { return 0; }
    public int getParryChance()             { return 0; }
    public int getBlockChance()             { return 0; }
    public int getHealthRegen()             { return 0; }
    public int getManaRegen()               { return 0; }
    public int getArmor()                   { return 0; }
    public int getFireResist()              { return 0; } // TODO: add the following stats to the StatModifierManager class
    public int getIceResist()               { return 0; }
    public int getPoisonResist()            { return 0; }
    public int getLightningResist()         { return 0; }
    public int getLifeSteal()               { return 0; }
    public int getPhysicalDamageReduction() { return 0; }
    public int getMagicDamageReduction()    { return 0; }

    // level
    private int level;
    private int experience;
    private int restedExperience;
    public  int getLevel()            { return level;            }
    public  int getExperience()       { return experience;       }
    public  int getRestedExperience() { return restedExperience; }

    /**
     * Default constructor
     */
    public BaseCharacter() {
        statModifierManager = new StatModifierManager();
        equipmentManager = new EquipmentManager(this);
        inventoryManager = new InventoryManager();
        level = 1;
    }

    /**
     * Attempt to equip an item. Updates the StatModifierManager if needed
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
     * Attempt to un-equip the item in specified slot. Updates the StatModifierManager if needed
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

    /**
     * Add an item to your inventory
     * @param item to be added
     */
    public void addItemToInventory(Item item) {
        inventoryManager.add(item);
    }

    /**
     * Remove an item from the inventory
     * @param slot specify which item is to be removed
     */
    public void removeItemFromInventory(int slot) {
        inventoryManager.remove(slot);
    }

    /**
     * Displays the contents of the inventory
     */
    public void displayInventoryList() {
        inventoryManager.display();
    }
}
