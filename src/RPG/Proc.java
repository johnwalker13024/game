package RPG;

/**
 * Procs are categorized into 3 categories, melee, ranged, and spell. A proc has a chance to activate depending on its
 * category.
 * Created by johnathon on 9/23/2016.
 * TODO: implement this class
 */
public interface Proc {
    public int getChance();
    public ProcType getType();
    public Effect getEffectID();

    //public Proc(int chance, ProcType procType, Effect effect) {  }
}
