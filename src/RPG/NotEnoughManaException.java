package RPG;

/**
 * Created by johnathonwalker on 9/23/16.
 */
public class NotEnoughManaException extends Exception {
    public String getMessage() {
        return "You do not have enough mana to cast this spell.";
    }
}
