package RPG;

import java.util.ArrayList;

/**
 * Created by johnathon on 9/19/2016.
 */
public class EquipmentManager {
    private ArrayList<Equipment> equippedItems;

    public EquipmentManager() {
        equippedItems = new ArrayList<>(EquipmentSlot.values().length);
    }

    public void equip(Equipment equipment, int characterLevel) {
        if (equipment.getRequiredLevel() <= characterLevel) {
            if (equippedItems.get(equipment.getEquipmentSlot()) != null) {

            }
        }
    }

    public void unequip(Equipment equipment) {
        equippedItems.remove(equipment);
        // TODO: add code to transfer item to inventory
    }
}
