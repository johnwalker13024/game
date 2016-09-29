package RPG;

/**
 * Created by johnathonwalker on 9/28/16.
 */
public class DamageOverTime extends Buff implements TimerListener {

    private int numTicks;
    private Spell spell;
    private BaseCharacter caster;
    private BaseCharacter target;
    private int currentTick;

    /**
     * constructor: name and description required, as well as at least one of the other two arguments
     *
     * @param name         of buff
     * @param description  what does it do (the player will rely on this)
     * @param proc         can be null
     * @param statModifier can be null, but statModifier and proc cannot both be null
     * @param duration     the length of the buff, in seconds
     * @param numTicks     how many times the spell will be cast
     * @param spell        the spell to be cast
     * @param caster       character casting the spell
     * @param target       character taking damage
     */
    public DamageOverTime(String name, String description, Proc proc, StatModifier statModifier, long duration,
                          int numTicks, Spell spell, BaseCharacter caster, BaseCharacter target) {
        super(name, description, proc, statModifier, duration);
        if (numTicks == 0 || spell == null || caster == null || target == null) {
            return; // todo: throw exception
        }
        this.numTicks = numTicks;
        this.spell = spell;
        this.caster = caster;
        this.target = target;
        currentTick = 0;
    }

    public void executue() {
        try {
            spell.cast(caster, target);
        } catch (NotEnoughManaException e) {
            System.out.println(e.getMessage());
            return;
        }
        numTicks++;
        new Timer(super.getDuration() / numTicks, this).execute();
    }

    @Override
    public void update() {
        if (currentTick < numTicks) {
            executue();
        }
    }
}
