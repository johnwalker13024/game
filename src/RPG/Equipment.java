package RPG;

/**
 * Defines an item that can be equipped and modify character stats
 * Created by johnathon on 9/18/2016.
 */
public class Equipment implements Item {
    private StatModifier statModifier;
    private String name;
    private EquipmentSlot equipmentSlot;
    private int requiredLevel;

    /**
     * super: Creates a new StatModifier object
     * Initializes a new Equipment object
     *
     * @param statList      list of stat modifiers this equipment has
     * @param name          name of equipment
     * @param equipmentSlot what slot it goes in
     */
    public Equipment(StatList statList, String name, EquipmentSlot equipmentSlot, int requiredLevel) {
        if (statList != null) {
            statModifier = new StatModifier(statList);
        }

        if (!name.isEmpty()) {
            this.name = name;
        }

        if (equipmentSlot != null) {
            this.equipmentSlot = equipmentSlot;
        }

        if (requiredLevel >= 1) {
            this.requiredLevel = requiredLevel;
        }
    }

    public StatModifier getStatModifier() {
        return statModifier;
    }

    public int getRequiredLevel() {
        return requiredLevel;

    }
    public String getName() {
        return name;
    }

    public EquipmentSlot getEquipmentSlot() {
        return equipmentSlot;
    }
}

/**
 * what are all the things that an item can have?
 * name
 * stats
 * slot
 * req lvl
 * activated abilities
 * PROCS
 * set bonuses
 * durability
 * flavor text
 * light, medium, heavy, colossal
 * rarity
 * sockets
 * PICTURE - thumbnail
 *
 * I need to create a random item generator for greens, blues and purples
 * green main stat = current level / 5, blues are /4, purples are /3
 */
