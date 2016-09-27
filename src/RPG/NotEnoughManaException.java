package RPG;

/**
 * Created by johnathonwalker on 9/23/16.
 */
public class NotEnoughManaException extends Exception {
    private String message;
    public NotEnoughManaException(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
