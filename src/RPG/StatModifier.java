package RPG;

/**
 * A StatModifier is any entity in the game that changes a character's stats, whether it be an equipped item, buff,
 * debuff, talent, etc. It provides an easy interface using the Stat enum
 *
 * Created by johnathon on 9/19/2016.
 */
public class StatModifier {
    private StatList statList;

    /**
     * Creates a new StatModifier object
     * @param statList list of all stat modifications
     */
    public StatModifier(StatList statList) {
        this.statList = statList;
    }

    /**
     * Returns the stat modifier for the specified stat
     * @param stat we want
     * @return negative number is an error, anything else is successful
     */
    public int getStat(Stat stat) {
        int statToReturn = 0;
        switch (stat) {
            case Strength:
                statToReturn = statList.getStrength();
                break;
            case Dexterity:
                statToReturn = statList.getDexterity();
                break;
            case Constitution:
                statToReturn = statList.getConstitution();
                break;
            case Intelligence:
                statToReturn = statList.getIntelligence();
                break;
            case Spirit:
                statToReturn = statList.getSpirit();
                break;
            case RunSpeed:
                statToReturn = statList.getRunSpeed();
                break;
            case Health:
                statToReturn = statList.getHealth();
                break;
            case Mana:
                statToReturn = statList.getMana();
                break;
            case MeleeAttackPower:
                statToReturn = statList.getMeleeAttackPower();
                break;
            case RangedAttackPower:
                statToReturn = statList.getRangedAttackPower();
                break;
            case SpellPower:
                statToReturn = statList.getSpellPower();
                break;
            case MeleeHitChance:
                statToReturn = statList.getMeleeHitChance();
                break;
            case RangedHitChance:
                statToReturn = statList.getRangedHitChance();
                break;
            case SpellHitChance:
                statToReturn = statList.getSpellHitChance();
                break;
            case MeleeCritChance:
                statToReturn = statList.getMeleeCritChance();
                break;
            case RangedCritChance:
                statToReturn = statList.getRangedCritChance();
                break;
            case SpellCritChance:
                statToReturn = statList.getSpellCritChance();
                break;
            case DodgeChance:
                statToReturn = statList.getDodgeChance();
                break;
            case ParryChance:
                statToReturn = statList.getParryChance();
                break;
            case BlockChance:
                statToReturn = statList.getBlockChance();
                break;
            case HealthRegen:
                statToReturn = statList.getHealthRegen();
                break;
            case ManaRegen:
                statToReturn = statList.getManaRegen();
                break;
            case Armor:
                statToReturn = statList.getArmor();
                break;
            default:
                statToReturn = -1;
                break;
        }
        return statToReturn;
    }
}
