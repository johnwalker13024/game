package RPG;

/**
 * Manages the player's inventory
 * Created by johnathon on 9/21/2016.
 */
public class InventoryManager {
    private Item[] items;
    private int nextAvailableSlot;
    private Boolean full;
    private static int MAX_ITEMS = 50;

    /**
     * default constructor
     */
    public InventoryManager() {
        items = new Item[MAX_ITEMS];
        nextAvailableSlot = 0;
        full = false;
    }

    /**
     * Attempts to add an item to the inventory
     * @param item to be added
     * @return success or fail
     */
    public Boolean add(Item item) {
        if (full || item == null) {
            return false;
        }
        items[nextAvailableSlot] = item;
        computeNextAvailableSlot();
        return true;
    }

    /**
     * Attempts to remove an item from the specified slot
     * @param slot specify which item is to be removed
     * @return success or fail
     */
    public Boolean remove(int slot) {
        if (slot < 0 || slot > MAX_ITEMS || items[slot] == null) {
            return false;
        }
        items[slot] = null;
        if (slot < nextAvailableSlot) {
            nextAvailableSlot = slot;
        }
        return true;
    }

    /** TODO: rewrite this algorithm... it doesn't work
     * Figures out what is the next item slot available. If none are, flags the 'full' variable as true
     */
    private void computeNextAvailableSlot() {
        // compute the next available slot
        nextAvailableSlot = -1;
        while (nextAvailableSlot + 1 < MAX_ITEMS &&
                items[nextAvailableSlot + 1] != null) {
            nextAvailableSlot++;
        }
        nextAvailableSlot++;
        if (nextAvailableSlot == MAX_ITEMS) {
            full = true;
        }
    }

    /**
     * Displays the names of all items in inventory in a list
     */
    public void display() {
        for (int i = 0; i < MAX_ITEMS; i++) {
            if (items[i] != null) {
                System.out.println(items[i].getName());
            } else {
                System.out.println("There isn't an item in this slot.");
            }
        }
    }
}
