package RPG;

/**
 * A Buff is an effect that can be applied to a character. Spells, equipment, talents, etc can apply buffs. Buffs
 * generally have a duration that can last from 5 seconds to several hours, and some last indefinitely. Buffs can affect
 * the character's stats, or work as a Proc (an Effect that has a chance to occur after a specific event, such as a
 * melee attack or spell cast).
 *
 * Created by johnathonwalker on 9/25/16.
 */
public class Buff {
    private StatModifier statModifier;
    private Proc proc;
    private String name;
    private String description;
    private int duration;

    /**
     * constructor: name and description required, as well as at least one of the other two arguments
     * @param name of buff
     * @param description what does it do (the player will rely on this)
     * @param proc can be null
     * @param statModifier can be null, but statModifier and proc cannot both be null
     * @param duration the length of the buff, in seconds
     */
    public Buff(String name, String description, Proc proc, StatModifier statModifier, int duration) {
        if ((name == null || description == null) || (proc == null && statModifier == null)) {
            return;
        }
        this.name = name;
        this.description = description;
        this.proc = proc;
        this.statModifier = statModifier;
        this.duration = duration;
    }

    public StatModifier getStatModifier() {
        return statModifier;
    }

    public Proc getProc() {
        return proc;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }
}
