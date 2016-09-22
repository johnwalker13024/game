package RPG;

import java.util.EnumMap;

/**
 * Handles the equipping and un-equipping of equipment
 * Created by johnathon on 9/19/2016.
 */
public class EquipmentManager {
    private Equipment[] equippedItems;
    private EnumMap<EquipmentSlot, Integer> equipmentSlotEnumMap;
    private BaseCharacter character;

    /**
     * Constructor
     * @param character requires a reference to a BaseCharacter object
     */
    public EquipmentManager(BaseCharacter character) {
        equippedItems = new Equipment[EquipmentSlot.values().length];

        equipmentSlotEnumMap = new EnumMap<>(EquipmentSlot.class);
        equipmentSlotEnumMap.put(EquipmentSlot.Back,     0);
        equipmentSlotEnumMap.put(EquipmentSlot.Chest,    1);
        equipmentSlotEnumMap.put(EquipmentSlot.Feet,     2);
        equipmentSlotEnumMap.put(EquipmentSlot.Finger,   3);
        equipmentSlotEnumMap.put(EquipmentSlot.Hands,    4);
        equipmentSlotEnumMap.put(EquipmentSlot.Legs,     5);
        equipmentSlotEnumMap.put(EquipmentSlot.Head,     6);
        equipmentSlotEnumMap.put(EquipmentSlot.Neck,     7);
        equipmentSlotEnumMap.put(EquipmentSlot.Shoulder, 8);
        equipmentSlotEnumMap.put(EquipmentSlot.Trinket,  9);
        equipmentSlotEnumMap.put(EquipmentSlot.Waist,    10);
        equipmentSlotEnumMap.put(EquipmentSlot.Wrist,    11);
        equipmentSlotEnumMap.put(EquipmentSlot.MainHand, 12);
        equipmentSlotEnumMap.put(EquipmentSlot.OffHand,  13);

        this.character = character;
    }

    /**
     * Equips an item
     * @param equipment to be equipped
     */
    public Boolean equip(Equipment equipment) {
        if (equipment.getRequiredLevel() <= character.getLevel()) {
            if (equippedItems[equipmentSlotEnumMap.get(equipment.getEquipmentSlot())] != null) {
                return false;
            }
            equippedItems[equipmentSlotEnumMap.get(equipment.getEquipmentSlot())] = equipment;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Un-equips an item
     * @param slot indicates which piece to remove
     */
    public void unequip(EquipmentSlot slot) {
        equippedItems[equipmentSlotEnumMap.get(slot)] = null;
        // TODO: add code to transfer item to inventory
    }

    /**
     * Returns the currently equipped gear in the specified slot
     * @param slot which piece of gear we want
     * @return Equipment object currently equipped
     */
    public Equipment getEquippedItemInSlot(EquipmentSlot slot) {
        Equipment equipmentToReturn = null;

        switch(slot) {
            case Back:
                equipmentToReturn = equippedItems[equipmentSlotEnumMap.get(EquipmentSlot.Back)];
                break;
            case Chest:
                equipmentToReturn = equippedItems[equipmentSlotEnumMap.get(EquipmentSlot.Chest)];
                break;
            case Feet:
                equipmentToReturn = equippedItems[equipmentSlotEnumMap.get(EquipmentSlot.Feet)];
                break;
            case Finger:
                equipmentToReturn = equippedItems[equipmentSlotEnumMap.get(EquipmentSlot.Finger)];
                break;
            case Hands:
                equipmentToReturn = equippedItems[equipmentSlotEnumMap.get(EquipmentSlot.Hands)];
                break;
            case Legs:
                equipmentToReturn = equippedItems[equipmentSlotEnumMap.get(EquipmentSlot.Legs)];
                break;
            case Head:
                equipmentToReturn = equippedItems[equipmentSlotEnumMap.get(EquipmentSlot.Head)];
                break;
            case Neck:
                equipmentToReturn = equippedItems[equipmentSlotEnumMap.get(EquipmentSlot.Neck)];
                break;
            case Shoulder:
                equipmentToReturn = equippedItems[equipmentSlotEnumMap.get(EquipmentSlot.Shoulder)];
                break;
            case Trinket:
                equipmentToReturn = equippedItems[equipmentSlotEnumMap.get(EquipmentSlot.Trinket)];
                break;
            case Waist:
                equipmentToReturn = equippedItems[equipmentSlotEnumMap.get(EquipmentSlot.Waist)];
                break;
            case Wrist:
                equipmentToReturn = equippedItems[equipmentSlotEnumMap.get(EquipmentSlot.Wrist)];
                break;
            case MainHand:
                equipmentToReturn = equippedItems[equipmentSlotEnumMap.get(EquipmentSlot.MainHand)];
                break;
            case OffHand:
                equipmentToReturn = equippedItems[equipmentSlotEnumMap.get(EquipmentSlot.OffHand)];
                break;
        }
        return equipmentToReturn;
    }
}
