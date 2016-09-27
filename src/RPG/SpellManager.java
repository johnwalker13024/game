package RPG;

import java.util.ArrayList;

/**
 * Created by johnathonwalker on 9/24/16.
 */
public class SpellManager {
    private ArrayList<Spell> spells;
    private BaseCharacter character;

    /**
     * constructor
     * @param character to reference
     */
    public SpellManager(BaseCharacter character) {
        this.character = character;
        spells = new ArrayList<>();
    }

    /**
     * adds a spell to the collection
     * @param spell to be added
     */
    public void add(Spell spell) {
        if (spell == null) {
            return;
        }
        spells.add(spell);
    }

    /**
     * removes a spell from the collection
     * @param spell to remove
     */
    public void remove(Spell spell) {
        spells.remove(spell);
    }

    /**
     * returns a list of known spells
     * @return
     */
    public ArrayList<Spell> getSpellList() {
        return spells;
    }
}
