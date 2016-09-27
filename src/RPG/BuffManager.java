package RPG;

import java.util.ArrayList;

/**
 * Keeps track of the character's buffs. It is recommended to use two buff managers, one to keep track of buffs, the
 * other to keep track of de-buffs (buffs with negative effects) for organizational purposes.
 *
 * Created by johnathonwalker on 9/25/16.
 */
public class BuffManager {
    private ArrayList<Buff> buffs;
    private BaseCharacter character;

    public BuffManager(BaseCharacter character) {
        this.character = character;
        buffs = new ArrayList<>();
    }

    public void add(Buff buff) {
        if (buff != null) {
            buffs.add(buff);
        }
    }

    public void remove(Buff buff) {
        buffs.remove(buff);
    }

    public ArrayList<Buff> getBuffs() {
        return buffs;
    }
}
