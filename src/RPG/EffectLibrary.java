package RPG;

/**
 * All effects used by spells and abilities are found here, referenced by the Effect enum
 * Created by johnathon on 9/23/2016.
 */
public class EffectLibrary { // TODO: turn this class into a background thread, rename execute to run

    public static void execute(Effect effect, BaseCharacter caster, BaseCharacter target) {
        // data validation
        if (effect == null || caster == null || target == null) {
            return; // TODO: change this to throw an exception
        }
        switch (effect) {
            case Fireball_Rank_1:
                Fireball_Rank_1(caster, target);
                break;
            case Heal_Rank_1:
                Heal_Rank_1(caster, target);
                break;
        }
    }

    private static void Fireball_Rank_1(BaseCharacter caster, BaseCharacter target) {
        if (caster == null || target == null) {
            return;
        }
        // compute damage
        float damage = 10.0f + caster.getSpellPower();
        // did it crit?
        int randomNum = Spell.getRandomNumber();
        if (caster.getSpellCritChance() > randomNum) {
            damage *= 1.5f;
            System.out.println("Critical hit!");
        }
        target.takeSpellDamage((int)damage, SpellType.Fire, null/*todo: change this to add a burning debuff*/);
    }

    private static void Fireball_Rank_1_Burn_DoT(BaseCharacter caster, BaseCharacter target) {
        if (caster == null || target == null) {
            return;
        }
        float damage = 1.0f;
        //target.takeSpellDamage();
    }

    private static void Heal_Rank_1(BaseCharacter caster, BaseCharacter target) {

    }
}
