package RPG;

/**
 * Created by johnathonwalker on 9/20/16.
 */
public class EquipTest {
    public static void main(String args[]) {
        BaseCharacter character = new BaseCharacter();

        Equipment oldShirt = new Equipment(
                new StatList(0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                "Old Shirt",
                EquipmentSlot.Chest,
                1
        );

        System.out.println("Equipping...");
        character.equip(oldShirt);
        Equipment currentlyEquipped = character.getCurrentlyEquippedItem(EquipmentSlot.Chest);
        System.out.println(currentlyEquipped.getName());
        System.out.println("Character constitution: " + character.getConstitution());

        System.out.println("\nUn-equipping...");
        character.unequip(EquipmentSlot.Chest);
        System.out.println("Character constitution: " + character.getConstitution());
        currentlyEquipped = character.getCurrentlyEquippedItem(EquipmentSlot.Chest);
        if (currentlyEquipped != null) {
            System.out.println(currentlyEquipped.getName());
        } else {
            System.out.println("Nothing is equipped in that slot.");
        }

        System.out.println("\nRe-equipping...");
        character.equip(oldShirt);
        currentlyEquipped = character.getCurrentlyEquippedItem(EquipmentSlot.Chest);
        System.out.println(currentlyEquipped.getName());
        System.out.println("Character constitution: " + character.getConstitution());

        System.out.println("\nTry to equip when something is already equipped...");
        character.equip(oldShirt);
        currentlyEquipped = character.getCurrentlyEquippedItem(EquipmentSlot.Chest);
        System.out.println(currentlyEquipped.getName());
        System.out.println("Character constitution: " + character.getConstitution());

        System.out.println("\nTry un-equipping when nothing is equipped");
        character.unequip(EquipmentSlot.Chest);
        character.unequip(EquipmentSlot.Chest);
        System.out.println("Character constitution: " + character.getConstitution());
        currentlyEquipped = character.getCurrentlyEquippedItem(EquipmentSlot.Chest);
        if (currentlyEquipped != null) {
            System.out.println(currentlyEquipped.getName());
        } else {
            System.out.println("Nothing is equipped in that slot.");
        }

        System.out.println("\nAdding old shirt to inventory and displaying inventory...");
        character.addItemToInventory(oldShirt);
        character.displayInventoryList();

        System.out.println("\nAdding several more items to the inventory...");
        character.addItemToInventory(oldShirt);
        character.addItemToInventory(oldShirt);
        character.addItemToInventory(oldShirt);
        character.addItemToInventory(oldShirt);
        character.addItemToInventory(oldShirt);
        character.addItemToInventory(oldShirt);
        character.addItemToInventory(oldShirt);
        character.addItemToInventory(oldShirt);
        character.addItemToInventory(oldShirt);
        character.displayInventoryList();

        System.out.println("\nRemoving a few shirts...");
        character.removeItemFromInventory(0);
        character.removeItemFromInventory(3);
        character.removeItemFromInventory(8);
        character.displayInventoryList();

        System.out.println("\nAdding two new items...");
        Equipment oldBoots = new Equipment(
                new StatList(1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                "Old Boots",
                EquipmentSlot.Feet,
                1
        );
        character.addItemToInventory(oldBoots);
        character.addItemToInventory(oldBoots);
        character.displayInventoryList();

        System.out.println("\nAdding two more new items...");
        character.addItemToInventory(oldBoots);
        character.addItemToInventory(oldBoots);
        character.displayInventoryList();
    }
}
