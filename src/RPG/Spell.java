package RPG;

/**
 * Defines a spell that can be cast by a BaseCharacter
 *
 * Created by johnathonwalker on 9/23/16.
 */
public class Spell implements TimerListener {

    private String name;
    private Effect effect;
    private int range;
    private int cost;
    private Boolean readyToCast;
    private long coolDown;
    private Buff buff;

    /**
     * constructor
     * @param name of spell
     * @param effect reference to effect in library
     * @param range in meters
     * @param cost mana
     * @param coolDown milliseconds (how long until you can cast it again)
     * @param buff can be null, to be applied upon taking spell damage
     */
    public Spell(String name, Effect effect, int range, int cost, long coolDown, Buff buff) {
        this.name = name;
        this.effect = effect;
        this.range = range;
        this.cost = cost;
        this.coolDown = coolDown;
        readyToCast = true;
        if (buff != null) {
            this.buff = buff;
        }
    }

    public String getName() {
        return name;
    }

    public Effect getEffect() {
        return effect;
    }

    public int getRange() {
        return range;
    }

    public int getCost() {
        return cost;
    }

    public long getCoolDown() {
        return coolDown;
    }

    public Boolean isReadyToCast() {
        return readyToCast;
    }

    public void cast(BaseCharacter caster, BaseCharacter target) throws NotEnoughManaException {
        // make sure caster has enough mana
        if (caster.getCurrentMana() < cost) { // todo: should statements like this be turned into switches?
            throw new NotEnoughManaException();
        } else if (!readyToCast) {
            System.out.println("Cannot cast " + name + ". Please wait for the cooldown timer to expire.");
            return; // todo: create an exception
        }

        // TODO: make sure caster is within range of target

        // TODO: make sure there are no barriers in Line of Sight (LoS)

        // compute hit chance
        if (determineHit(caster, target)) {
            EffectLibrary.execute(effect, caster, target); // todo: replace execute with generic code built-in to Spell class
            readyToCast = false;
            new Timer(coolDown, this).execute();
        } else {
            System.out.println("Spell missed.");
        }
    }

    private Boolean determineHit(BaseCharacter caster, BaseCharacter target) {
        // can't miss when targeting self
        Boolean selfTarget = caster == target;

        int hitChance = 95 - (caster.getLevel() - target.getLevel()) * 3 + caster.getSpellHitChance();
        int randomNum = getRandomNumber();

        System.out.println("Hit Chance: " + hitChance); //todo: remove debug statement
        System.out.println("Random Number: " + randomNum); //todo: remove debug statement

        return hitChance > randomNum || selfTarget;
    }

    public static int getRandomNumber() {
        return (int)((Math.random() * 100) + 1);
    }

    /**
     * An update letting the class know that the coolDown is finished and the spell can be cast again
     */
    @Override
    public void update() {
        readyToCast = true;
        System.out.println(name + " is ready to cast again.");
    }
}
