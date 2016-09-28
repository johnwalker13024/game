package RPG;

/**
 * Created by johnathonwalker on 9/23/16.
 */
public class Spell {

    private String name;
    private Effect effect;
    private int range;
    private int cost;

    public Spell(String name, Effect effect, int range, int cost) {
        this.name = name;
        this.effect = effect;
        this.range = range;
        this.cost = cost;
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

    public void cast(BaseCharacter caster, BaseCharacter target) throws NotEnoughManaException {
        // make sure caster has enough mana
        if (caster.getCurrentMana() < cost) {
            throw new NotEnoughManaException("You do not have enough mana to cast this spell.");
        }

        // TODO: make sure caster is within range of target

        // TODO: make sure there are no barriers in Line of Sight (LoS)

        // compute hit chance
        // compute different hit chance if caster and target are the same (100% chance for self-cast)
        Boolean successfulCast = false;
        if (caster == target) {
            successfulCast = true;
        }
        int hitChance = 95 - (caster.getLevel() - target.getLevel()) * 3 + caster.getSpellHitChance();
        int randomNum = getRandomNumber();
        System.out.println("Hit Chance: " + hitChance);
        System.out.println("Random Number: " + randomNum);
        if (hitChance > randomNum || successfulCast) {
            EffectLibrary.execute(effect, caster, target);
        } else {
            System.out.println("Spell missed.");
        }
    }

    public static int getRandomNumber() {
        return (int)((Math.random() * 100) + 1);
    }
}
