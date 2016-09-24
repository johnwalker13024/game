package RPG;

import java.util.ArrayList;

/**
 * Keeps track of procs from equipment, talents, and any other source.
 * Created by johnathon on 9/23/2016.
 */
public class ProcManager {
    private ArrayList<Proc> procs;
    private BaseCharacter character;

    /**
     * Constructor: requires a character to reference
     * @param character
     */
    public ProcManager(BaseCharacter character) {
        this.character = character;
        procs = new ArrayList<>();
    }

    // need functions to compute the 3 types of procs, as well as add and remove procs
}
