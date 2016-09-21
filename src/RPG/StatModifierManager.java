package RPG;

import java.util.ArrayList;

/**
 * StatModifierManager keeps track of what stat modifiers the character currently has. This could range from the bonus
 * stats you gan from equipped armor and weapons to temporary buffs.
 *
 * Created by johnathon on 9/19/2016.
 */
public class StatModifierManager {
    private ArrayList<StatModifier> statTable;

    // default constructor
    public StatModifierManager() {
        statTable = new ArrayList<>();
    }

    /**
     * Adds a StatModifier to the array
     * @param statModifier to be added
     */
    public void addStatModifier(StatModifier statModifier) {
        statTable.add(statModifier);
    }

    /**
     * Removes a StatModifier from the array
     * @param statModifier to be removed
     */
    public void removeStatModifier(StatModifier statModifier) {
        statTable.remove(statModifier);
    }

    /**
     * Returns the sum of all modifiers for the specified stat
     * @param stat modifiers will be returned for the specified stat
     */
    public int getStatModifierSum(Stat stat) {
        int sum = 0;

        for (StatModifier statModifier : statTable) {
            sum += statModifier.getStat(stat);
        }

        return sum;
    }
}
