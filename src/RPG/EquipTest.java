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
    }
}
