package RPG;

import com.sun.javaws.exceptions.InvalidArgumentException;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;

// TODO: create a Timer class that uses the listener/observer model and notifies the listeners when their timers are up. would be used by the Buff Manager class as well as for keeping track of cast times and time for spell to travel

/**
 * Defines a default character that all player and non-player characters are derived from.
 *
 * Created by johnathon on 9/18/2016.
 */
public class BaseCharacter implements TimerListener {

    private String name;
    public  String getName() { return name; }

    private StatModifierManager statModifierManager;
    private EquipmentManager equipmentManager;
    private InventoryManager inventoryManager;
    private SpellManager spellManager;
    private BuffManager buffManager;
    private ProcManager procManager;

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

    private int damageTaken;
    private int manaSpent;

    // secondary stats TODO: return statModifierManager values and implement algorithms
    public int getRunSpeed()                { return 0; }
    public int getMaxHealth()               { return (baseConstitution + statModifierManager.getStatModifierSum(Stat.Constitution)) * 10; }
    public int getCurrentHealth()           { return getMaxHealth() - damageTaken; }
    public int getMaxMana()                 { return (baseIntelligence + statModifierManager.getStatModifierSum(Stat.Intelligence)) * 10; }
    public int getCurrentMana()             { return getMaxMana() - manaSpent; }
    public int getMeleeAttackPower()        { return 0; }
    public int getRangedAttackPower()       { return 0; }
    public int getSpellPower()              { return 0; }
    public int getMeleeHitChance()          { return 0; }
    public int getRangedHitChance()         { return 0; }
    public int getSpellHitChance()          { return 0; }
    public float getMeleeCritChance()       { return 0; }
    public float getRangedCritChance()      { return 0; }
    public float getSpellCritChance()       { return ((float)(baseIntelligence + statModifierManager.getStatModifierSum(Stat.Intelligence)) / 20.0f); }
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
    public BaseCharacter(String name) {
        if (name == null) {
            System.out.println("Invalid parameter. Name is required.");
            return;
        }

        statModifierManager = new StatModifierManager();
        equipmentManager = new EquipmentManager(this);
        inventoryManager = new InventoryManager();
        spellManager = new SpellManager(this);
        buffManager = new BuffManager(this);
        procManager = new ProcManager(this);

        level = 1;

        baseStrength = 10;
        baseDexterity = 10;
        baseConstitution = 10;
        baseIntelligence = 500;
        baseSpirit = 10;

        damageTaken = 0;
        manaSpent = 0;
    }

    /**
     * Reduce the player's current health
     * @param damage taken
     */
    private void reduceHealth(int damage) {
        System.out.println("Reducing health by: " + damage);
        damageTaken += damage;
        //todo: handle when damageTaken >= maxhealth (dead)
    }

    /**
     * Reduce the player's current mana
     * @param manaCost of the spell cast
     */
    private void reduceMana(int manaCost) {
        manaSpent += manaCost;
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

    /**
     * adds a new spell to the spellbook
     * @param spell to be added
     */
    public void learnNewSpell(Spell spell) {
        if (spell == null) {
            return;
        }
        spellManager.add(spell);
    }

    /**
     * returns a list of known spells
     * @return arraylist of spells
     */
    public ArrayList<Spell> getSpellList() {
        return spellManager.getSpellList();
    }

    /**
     * cast a spell
     * @param spell to be cast
     * @return successful or not
     */
    public Boolean cast(Spell spell, BaseCharacter target) {
        // verify that the spell is known
        if (spellManager.getSpellList().contains(spell)) {
            try {
                spell.cast(this, target);
            } catch (NotEnoughManaException e) {
                System.out.println(e.getMessage());
                return false;
            }
            reduceMana(spell.getCost());
            return true;
        } else {
            System.out.println("You do not know that spell.");
            return false;
        }
    }

    /**
     * On the receiving end of a harmful spell. Applies resists, reduces health if necessary, applies debuffs if necessary
     * @param damage raw incoming damage
     * @param spellType fire, ice, lightning, or poison
     * @param debuff can be null, apply a debuff
     */
    public void takeSpellDamage(int damage, SpellType spellType, Buff debuff) {
        // chance to fully resist
        int resistance;
        switch (spellType) {
            case Fire:
                resistance = getFireResist();
                break;
            case Ice:
                resistance = getIceResist();
                break;
            case Lightning:
                resistance = getLightningResist();
                break;
            case Poison:
                resistance = getPoisonResist();
                break;
            default:
                return;
        }

        System.out.println("Taking spell damage. Computing resists...");
        float random = Spell.getRandomNumber();
        float fullResistChance = resistance * 0.08f;
        System.out.println("random: " + random);
        System.out.println("fullResistChance: " + fullResistChance);
        if (fullResistChance > random) {
            System.out.println("Spell resisted.");
            return;
        }

        // apply flat reduction based on resist
        float flatDamageReduction = resistance * .25f / 100;
        System.out.println("flatDamageReduction: " + flatDamageReduction);
        System.out.println("Damage: " + damage);
        System.out.println("flatDamageReduction * damage: " + flatDamageReduction * damage);
        int damageTaken;
        if (flatDamageReduction == 0.0f) {
            damageTaken = damage;
        } else {
            damageTaken = (int)(flatDamageReduction * damage);
        }
        reduceHealth(damageTaken);
    }

    @Override
    public void update() {
        System.out.println("TimerListener is getting an update...");
    }
}
